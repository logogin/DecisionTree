package com.logogin.decisiontree.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dmg.pmml_3_1.DataField;
import org.dmg.pmml_3_1.FieldUsageType;
import org.dmg.pmml_3_1.MiningField;
import org.dmg.pmml_3_1.Node;
import org.dmg.pmml_3_1.PMML;
import org.dmg.pmml_3_1.ScoreDistribution;
import org.dmg.pmml_3_1.SimplePredicate;
import org.dmg.pmml_3_1.Value;

import com.logogin.decisiontree.model.expression.LogicalExpression;
import com.logogin.decisiontree.model.expression.LogicalTerm;

/**
 * $Id$
 *
 * @created Nov 18, 2010
 * @author Pavel Danchenko
 */
public class DecisionTreeModel {

    private String id;
    private String name;
    private PMML pmml;
    private List<List<Node>> spreadedTree;
    private List<Rule> rules;
    private Map<String, Double> scoreRecordCounts;
    private Map<String, List<Rule>> sortedRules;

    public DecisionTreeModel(String id, String name, PMML pmml) {
        this.id = id;
        this.name = name;
        this.pmml = pmml;
        spreadTree();
        buildRules();
        sortRules();
    }

    private void spreadTree() {
        spreadedTree = new ArrayList<List<Node>>();
        Deque<Node> nodeStack = new ArrayDeque<Node>();
        Deque<List<Node>> exprStack = new ArrayDeque<List<Node>>();
        for ( Node root : getRootNodes() ) {
            nodeStack.push(root);
            exprStack.push(new ArrayList<Node>());
        }

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            List<Node> rule = exprStack.pop();
            List<Node> children = node.getNodes();
            rule.add(node);
            if ( !children.isEmpty() ) {
                for ( Node child : children ) {
                    nodeStack.push(child);
                    exprStack.push(new ArrayList<Node>(rule));
                }
            } else {
                spreadedTree.add(rule);
            }
        }
        assert !exprStack.isEmpty() : "exprStack not empty";
    }

    private void buildRules() {
        rules = new ArrayList<Rule>();
        for ( List<Node> rule : spreadedTree ) {
            LogicalExpression expr = new LogicalExpression();
            for ( Node node : rule ) {
                for ( SimplePredicate predicate : node.getSimplePredicates() ) {
                  expr.and(createTerm(predicate));
                }
            }
            Node node = rule.get(rule.size() - 1);
            rules.add(new Rule(expr, node.getScore(), node.getRecordCount(), getScoreDistributionRecordCount(node, node.getScore())));
        }
    }

    private void sortRules() {
        sortedRules = new HashMap<String, List<Rule>>();
        scoreRecordCounts = new HashMap<String, Double>();
        for ( Value value : getPredictedDataField().getValue() ) {
            sortedRules.put(value.getValue(), new ArrayList<Rule>());
            scoreRecordCounts.put(value.getValue(), 0.0);
        }
        for ( Rule rule : rules ) {
            sortedRules.get(rule.getScore()).add(rule);
            double scoreRecordCount = scoreRecordCounts.get(rule.getScore()) + rule.getRecordCount();
            scoreRecordCounts.put(rule.getScore(), scoreRecordCount);
        }

        for ( Value value : getPredictedDataField().getValue() ) {
            Collections.sort(sortedRules.get(value.getValue()), new Comparator<Rule>() {
                @Override
                public int compare(Rule o1, Rule o2) {
                    return o2.getRecordCount().compareTo(o1.getRecordCount());
                }
            });
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public DataField getPredictedDataField() {
        String predictedDataFieldName = null;
        for ( MiningField field : pmml.getTreeModel().getMiningSchema().getMiningField() ) {
            if ( FieldUsageType.PREDICTED == field.getUsageType() ) {
                predictedDataFieldName = field.getName();
            }
        }
        for ( DataField field : getDataFields() ) {
            if ( field.getName().equals(predictedDataFieldName) ) {
                return field;
            }
        }
        return null;
    }

    public Set<String> getDataFieldNames() {
        Set<String> result = new LinkedHashSet<String>();
        for ( DataField dataField : getDataFields() ) {
            result.add(dataField.getName());
        }
        return result;
    }

    private List<DataField> getDataFields() {
        return pmml.getDataDictionary().getDataField();
    }

    private List<Node> getRootNodes() {
        return pmml.getTreeModel().getNodes();
    }

    public int getRulesCount() {
        return rules.size();
    }

    public int getRulesCountForScore(String score) {
        return sortedRules.get(score).size();
    }

    private Double getScoreDistributionRecordCount(Node node, String classValue) {
        for ( ScoreDistribution distribution : node.getScoreDistributions() ) {
            if ( distribution.getValue().equals(classValue) ) {
                return distribution.getRecordCount();
            }
        }
        return null;
    }

    public int getFrequentRulesCountForScore(String score, double threshold) {
        int result = 0;
        for ( Rule rule : rules ) {
            if ( rule.getScore().equals(score) && rule.getScoreRecordCount() >= threshold ) {
                result++;
            }
        }
        return result;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public Set<Rule> getRulesIntersection(Collection<Rule> rulesToRetain, Set<String> ignoredDataFields) {
        Set<Rule> result = new HashSet<Rule>();
        for ( Rule rule : rules ) {
            for ( Rule ruleToRetain : rulesToRetain ) {
                if (rule.getExpression().equalsIgnoreTerms(ruleToRetain.getExpression(), ignoredDataFields)) {
                    result.add(rule);
                }
            }
        }
        return result;
    }

    public StringBuffer dumpWekaTree() {
        StringBuffer text = new StringBuffer();

        Deque<Node> nodeStack = new ArrayDeque<Node>();
        Deque<Integer> depthStack = new ArrayDeque<Integer>();
        //Deque<LogicalExpression> exprStack = new ArrayDeque<LogicalExpression>();
        for (Node root : getRootNodes()) {
            nodeStack.push(root);
            depthStack.push(0);
        }

        while (!nodeStack.isEmpty()) {
            int depth = depthStack.pop();
            for (int i = 0; i < depth; i++) {
                text.append("|   ");
            }
            Node node = nodeStack.pop();
            LogicalExpression expr = new LogicalExpression();
            List<Node> children = node.getNodes();
            List<SimplePredicate> predicates = node.getSimplePredicates();
            for (SimplePredicate predicate : predicates) {
                expr.and(createTerm(predicate));
            }
            text.append(expr.toString());
            if (!children.isEmpty()) {
                depth++;
                for (Node child : children) {
                    nodeStack.push(child);
                    depthStack.push(depth);
                }
            } else {
                text.append(": ").append(node.getScore()).append(" (").append(node.getRecordCount());
                Double numIncorrect = node.getRecordCount() - getScoreDistributionRecordCount(node, node.getScore());
                if ( numIncorrect > 0.0 ) {
                    text.append("/").append(numIncorrect);
                }
                text.append(")");
                text.append(" id=").append(node.getId()+" ");
//                result.add(new Rule(expr, node.getScore(), node
//                        .getRecordCount(), getScoreDistributionRecordCount(
//                        node, node.getScore())));
            }
            text.append("\n");
        }
        assert !nodeStack.isEmpty() : "nodeStack not empty";
        assert !depthStack.isEmpty() : "depthStack not empty";

        return text;
    }

    private LogicalTerm.Operator translateOperator(SimplePredicate.Operator operator) {
        switch (operator) {
        case EQUAL: return LogicalTerm.Operator.EQ;
        case GREATER_OR_EQUAL: return LogicalTerm.Operator.GE;
        case GREATER_THAN: return LogicalTerm.Operator.GT;
        case LESS_OR_EQUAL: return LogicalTerm.Operator.LE;
        case LESS_THAN: return LogicalTerm.Operator.LT;
        }
        throw new IllegalArgumentException("Illegal argument " + operator);
    }

    private LogicalTerm createTerm(SimplePredicate predicate) {
        return new LogicalTerm(predicate.getField(), predicate.getValue(), translateOperator(predicate.getOperator()));
    }

    public List<Rule> getFrequentRules(Double threshold) {
        List<Rule> result = new ArrayList<Rule>();
        for ( Rule rule : rules ) {
            if ( rule.getScoreRecordCount() >= threshold ) {
                result.add(rule);
            }
        }
        return result;
    }

    public List<Rule> getRelativeRules(Double percentage) {
        List<Rule> result = new ArrayList<Rule>();
        for ( Value value : getPredictedDataField().getValue() ) {
            double threshold = scoreRecordCounts.get(value.getValue()) * percentage;
            double total = 0.0;
            for ( Rule rule : sortedRules.get(value.getValue()) ) {
                total += rule.getRecordCount();
                result.add(rule);
                if ( total >= threshold ) {
                    break;
                }
            }
        }
        return result;
    }

    public int getRelativeRulesCountForScore(String score, double percentage) {
        int result = 0;
        double total = 0.0;
        double threshold = scoreRecordCounts.get(score) * percentage;
        for ( Rule rule : sortedRules.get(score) ) {
            total += rule.getRecordCount();
            result++;
            if ( total >= threshold ) {
                break;
            }
        }
        return result;
    }

    public double getScoreRecordCount(String score) {
        return scoreRecordCounts.get(score);
    }

    public double getRelativeScoreRecordCount(String score, double percentage) {
        double result = 0.0;
        double total = 0.0;
        double threshold = scoreRecordCounts.get(score) * percentage;
        for ( Rule rule : sortedRules.get(score) ) {
            total += rule.getRecordCount();
            result += rule.getScoreRecordCount();
            if ( total >= threshold ) {
                break;
            }
        }
        return result;
    }
}
