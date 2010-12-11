package com.logogin.decisiontree.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.dmg.pmml_3_1.DataField;
import org.dmg.pmml_3_1.Value;

import com.logogin.decisiontree.model.ComboBoxItem;
import com.logogin.decisiontree.model.DecisionTreeModel;
import com.logogin.decisiontree.model.TreeModelsTableModel;
import com.logogin.decisiontree.model.event.AliasChangeEvent;
import com.logogin.decisiontree.model.event.ModelChangeEvent;

/**
 * $Id$
 *
 * @created Nov 15, 2010
 * @author Pavel Danchenko
 */
public class TreeAnalyzerController extends BaseController {

    private DataField predictedDataField;
    private Map<String, DecisionTreeModel> treeModels;
    private Map<String, Boolean> enabledTreeModels;
    private Map<String, String> dataFieldAliases;

    public TreeAnalyzerController() {
        treeModels = new LinkedHashMap<String, DecisionTreeModel>();
        enabledTreeModels = new LinkedHashMap<String, Boolean>();
        dataFieldAliases = new LinkedHashMap<String, String>();
    }

    private void initDataFieldAliasesFromProperties() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("TreeAnalizer.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for ( String propertyName : props.stringPropertyNames() ) {
            String[] parts = propertyName.split("\\.");
            if ( parts.length == 2 ) {
                dataFieldAliases.put(propertyName, props.getProperty(propertyName));

            }
        }
    }

    public void addTreeModel(DecisionTreeModel treeModel) {
        treeModels.put(treeModel.getId(), treeModel);
        if ( null == predictedDataField ) {
            predictedDataField = treeModel.getPredictedDataField();
        }
        if ( !predictedDataField.getName().equals(treeModel.getPredictedDataField().getName()) ) {
            throw new IllegalArgumentException("Incompartible models: different predicted fields");
        }
        fireModelChanged(new ModelChangeEvent(this, treeModel));
    }

    public void unloadTreeModels() {
        treeModels.clear();
        predictedDataField = null;
        enabledTreeModels.clear();
        fireModelChanged(ModelChangeEvent.createModelsRemovedEvent(this));
    }

    public int getClassValuesCount() {
        return predictedDataField.getValue().size();
    }

    public String[] getColumnIdentifiers(Double coverageThreshold) {
        int classValuesCount = getClassValuesCount();
        String[] classValueAliases = getClassValueAliases();
        String[] columnNames = new String[2 + 3 * classValuesCount];
        columnNames[0] = "Name";
        columnNames[1] = "Rules";
        for (int i = 0; i < classValuesCount; i++) {
            columnNames[2 + i] = classValueAliases[i];
            columnNames[2 + classValuesCount + i] = "Frequent rules "
                    + classValueAliases[i];
            columnNames[2 + 2 * classValuesCount + i] = coverageThreshold + "% rules coverage "
                    + classValueAliases[i];
        }
        return columnNames;
    }

    public String[] getClassValueAliases() {
        String[] classValueAliases = new String[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            classValueAliases[i] = getClassValueAlias(value.getValue());
        }
        return classValueAliases;
    }

    public String getClassValueAlias(String classValue) {
        return dataFieldAliases.containsKey(createAliasKey(predictedDataField.getName(), classValue)) ? dataFieldAliases.get(predictedDataField.getName() + "." + classValue) : predictedDataField.getName() + "[" + classValue + "]";
    }

    private String createAliasKey(String dataFieldName, String classValue) {
        return dataFieldName + "." + classValue;
    }

    public int[] getRelativeRulesCounts(DecisionTreeModel treeModel, Double coverageThreshold) {
        int[] relativeRulesCounts = new int[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            relativeRulesCounts[i] = treeModel.getRelativeRulesCountForScore(value.getValue(), coverageThreshold);
        }
        return relativeRulesCounts;
    }

    public int[] getFrequentRulesCounts(DecisionTreeModel treeModel, Double scoreThreshold) {
        int[] frequentRulesCounts = new int[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            frequentRulesCounts[i] = treeModel.getFrequentRulesCountForScore(value.getValue(), scoreThreshold);
        }
        return frequentRulesCounts;
    }

    public int[] getRulesCounts(DecisionTreeModel treeModel) {
        int[] rulesCounts = new int[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            rulesCounts[i] = treeModel.getRulesCountForScore(value.getValue());
        }
        return rulesCounts;
    }

    public double[] getScoreRecordCounts(DecisionTreeModel treeModel) {
        double[] scoreRecordCounts = new double[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            scoreRecordCounts[i] = treeModel.getScoreRecordCount(value.getValue());
        }
        return scoreRecordCounts;
    }

    public double[] getRelativeScoreRecordCounts(DecisionTreeModel treeModel, Double coverageThreshold) {
        double[] relativeScoreRecordCounts = new double[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            relativeScoreRecordCounts[i] = treeModel.getRelativeScoreRecordCount(value.getValue(), coverageThreshold);
        }
        return relativeScoreRecordCounts;
    }

    public void initDataFieldAliases() {
        initDataFieldAliasesFromProperties();
    }

    public String[] getDataFieldNames() {
        Set<String> dataFieldNames = new LinkedHashSet<String>();
        for ( String treeModelId : getEnabledTreeModels() ) {
            dataFieldNames.addAll(treeModels.get(treeModelId).getDataFieldNames());
        }
        return dataFieldNames.toArray(new String[dataFieldNames.size()]);
    }

    public ComboBoxItem[] getEnabledTreeModelsItems() {
        List<ComboBoxItem> items = new ArrayList<ComboBoxItem>();
        for ( String treeModelId : getEnabledTreeModels() ) {
            items.add(new ComboBoxItem(treeModels.get(treeModelId).getName(), treeModelId));
        }
        return items.toArray(new ComboBoxItem[items.size()]);
    }

    public StringBuffer getWekaOutput(int rowIndex, TreeModelsTableModel treeModelsTableModel) {
        return treeModels.get(treeModelsTableModel.getTreeModel(rowIndex)).dumpWekaTree();
    }

    public void setDataFieldAlias(String dataFieldName, String classValue, String alias) {
        dataFieldAliases.put(createAliasKey(dataFieldName, classValue), alias);
        fireAliasChanged(new AliasChangeEvent(this));
    }

    public void setTreeModelEnabled(String treeModelId, boolean enabled) {
        enabledTreeModels.put(treeModelId, enabled);
        fireModelsChanged();
    }

    public List<String> getEnabledTreeModels() {
        List<String> result = new ArrayList<String>();
        for ( Map.Entry<String, Boolean> entry : enabledTreeModels.entrySet() ) {
            if ( entry.getValue() ) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public DecisionTreeModel getTreeModel(String treeModelId) {
        return treeModels.get(treeModelId);
    }

    public Map<String, String> getDataFieldAliases() {
        return new LinkedHashMap<String, String>(dataFieldAliases);
    }

    public String[] getClassValues() {
        if ( null == predictedDataField ) {
            return new String[] {};
        }
        String[] result = new String[predictedDataField.getValue().size()];
        for ( int i=0; i<predictedDataField.getValue().size(); i++ ) {
            result[i] = predictedDataField.getValue().get(i).getValue();
        }
        return result;
    }

    public void fireModelsChanged() {
        fireModelChanged(ModelChangeEvent.createModelsChangedEvent(this));
    }
}
