package com.logogin.decisiontree;

import java.beans.PropertyChangeEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.dmg.pmml_3_1.DataField;
import org.dmg.pmml_3_1.Value;
import org.jdesktop.application.AbstractBean;

import com.logogin.decisiontree.model.ComboBoxItem;
import com.logogin.decisiontree.model.DecisionTreeModel;
import com.logogin.decisiontree.model.OverviewTableModel;
import com.logogin.decisiontree.model.Rule;
import com.logogin.decisiontree.model.TreeModelsTableModel;

/**
 * $Id$
 *
 * @created Nov 15, 2010
 * @author Pavel Danchenko
 */
public class TreeAnalyzerController /* extends AbstractBean*/ {

//    private static final String DATA_FIELD_ALIASES_PROPERTY = "dataFieldAliases";
    //private OverviewTableModel overviewTableModel;
    //private DefaultTableModel dataFieldAliasesTableModel;
//    private TreeModelsTableModel treeModelsTableModel;
//    private DefaultTableModel rulesTableModel;
//    private DefaultTableModel ignoredDataFieldsTableModel;
//    private DefaultTableModel leftRulesTableModel;
//    private DefaultTableModel rightRulesTableModel;

    private DataField predictedDataField;
    private Map<String, DecisionTreeModel> treeModels;
//    private Set<String> dataFieldNames;
    private Map<String, String> dataFieldAliases;

    public TreeAnalyzerController() {
        treeModels = new HashMap<String, DecisionTreeModel>();
        dataFieldAliases = new HashMap<String, String>();
        //initDataFieldAliasesFromProperties();
    }

    private void initDataFieldAliasesFromProperties() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("PMMLAnalizer.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for ( String propertyName : props.stringPropertyNames() ) {
            String[] parts = propertyName.split("\\.");
            if ( parts.length == 2 ) {
                dataFieldAliases.put(propertyName, props.getProperty(propertyName));
            }
        }
        //firePropertyChange(DATA_FIELD_ALIASES_PROPERTY, null, null);
    }

//    private Map<String, String> getDataFieldAliases() {
//        Map<String, String> aliases = new HashMap<String, String>();
//        for ( int i=0; i<dataFieldAliasesTableModel.getRowCount(); i++  ) {
//            String value = dataFieldAliasesTableModel.getValueAt(i, 0) + "." + dataFieldAliasesTableModel.getValueAt(i, 1);
//            String alias = (String)dataFieldAliasesTableModel.getValueAt(i, 2);
//            aliases.put(value, alias);
//        }
//        return aliases;
//    }

//    public void addTableModel(OverviewTableModel tableModel) {
//        overviewTableModel = tableModel;
//    }

    public void addTreeModel(DecisionTreeModel treeModel, OverviewTableModel overviewTableModel) {
        if ( null == predictedDataField ) {
            predictedDataField = treeModel.getPredictedDataField();
        }
        if ( !predictedDataField.getName().equals(treeModel.getPredictedDataField().getName()) ) {
            throw new IllegalArgumentException("Incompartible models: different predicted fields");
        }
        treeModels.put(treeModel.getId(), treeModel);
        overviewTableModel.addTreeModel(treeModel.getId(), treeModel.getName(), treeModel.getRulesCount());
    }

//    public List<DecisionTreeModel> getTreeModels() {
//        return new ArrayList<DecisionTreeModel>(treeModels.values());
//    }

    public void unloadTreeModels(OverviewTableModel overviewTableModel) {
        treeModels.clear();
        predictedDataField = null;
        overviewTableModel.clear();
    }

    public void recalculateTreeModelsTable(Double scoreThreshold, Double coverageThreshold
            , OverviewTableModel overviewTableModel
            , TreeModelsTableModel treeModelsTableModel) {
        treeModelsTableModel.clear();
        for ( String treeModelId : overviewTableModel.getEnabledTreeModels() ) {
            DecisionTreeModel treeModel = treeModels.get(treeModelId);
            treeModelsTableModel.addTreeModel(
                    treeModel.getId()
                    , treeModel.getName()
                    , treeModel.getRulesCount()
                    , getRulesCounts(treeModel)
                    , getFrequentRulesCounts(treeModel, scoreThreshold)
                    , getRelativeRulesCounts(treeModel, coverageThreshold));
        }
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

    public void setColumnIdentifiers(TreeModelsTableModel treeModelsTableModel) {
        int classValuesCount = getClassValuesCount();
        String[] classValueAliases = getClassValueAliases();
        String[] columnNames = new String[2 + 3 * classValuesCount];
        columnNames[0] = "Name";
        columnNames[1] = "Rules";
        for (int i = 0; i < classValuesCount; i++) {
            columnNames[2 + i] = classValueAliases[i];
            columnNames[2 + classValuesCount + i] = "Frequent rules "
                    + classValueAliases[i];
            columnNames[2 + 2 * classValuesCount + i] = "90% rules coverage "
                    + classValueAliases[i];
        }
        treeModelsTableModel.setColumnIdentifiers(columnNames);
    }

    private String[] getClassValueAliases() {
        String[] classValueAliases = new String[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            classValueAliases[i] = getClassValueAlias(value.getValue());
        }
        return classValueAliases;
    }

    private String getClassValueAlias(String classValue) {
        return dataFieldAliases.containsKey(predictedDataField.getName() + "." + classValue) ? dataFieldAliases.get(predictedDataField.getName() + "." + classValue) : predictedDataField.getName() + "[" + classValue + "]";
    }

    private int[] getRelativeRulesCounts(DecisionTreeModel treeModel, Double coverageThreshold) {
        int[] relativeRulesCounts = new int[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            relativeRulesCounts[i] = treeModel.getRelativeRulesCountForScore(value.getValue(), coverageThreshold);
        }
        return relativeRulesCounts;
    }

    private int[] getFrequentRulesCounts(DecisionTreeModel treeModel, Double scoreThreshold) {
        int[] frequentRulesCounts = new int[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            frequentRulesCounts[i] = treeModel.getFrequentRulesCountForScore(value.getValue(), scoreThreshold);
        }
        return frequentRulesCounts;
    }

    private int[] getRulesCounts(DecisionTreeModel treeModel) {
        int[] rulesCounts = new int[predictedDataField.getValue().size()];
        for ( int i = 0; i < predictedDataField.getValue().size(); i++ ) {
            Value value = predictedDataField.getValue().get(i);
            rulesCounts[i] = treeModel.getRulesCountForScore(value.getValue());
        }
        return rulesCounts;
    }

    public void updateTreeModelRulesTable(int rowIndex
            , TreeModelsTableModel treeModelsTableModel
            , DefaultTableModel rulesTableModel) {
        rulesTableModel.setRowCount(0);
        if ( rowIndex < 0 || treeModelsTableModel.getRowCount() == 0 ) {
            return;
        }
        String selectedTreeModelId = treeModelsTableModel.getTreeModel(rowIndex);
        List<Rule> rules = treeModels.get(selectedTreeModelId).getRules();
        int i = 1;
        DecimalFormat format = new DecimalFormat("#,##0.00");
        for ( Rule rule : rules ) {
            rulesTableModel.addRow(
                    new Object[] {i++
                            , rule.getExpression()
                            , getClassValueAlias(rule.getScore())
                            , format.format(rule.getRecordCount()) + "/" + format.format(rule.getScoreRecordCount())});
        }
    }

    public void compareTreeModels(String leftTreeModelId, String rightTreeModelId
            , DefaultTableModel leftRulesTableModel
            , DefaultTableModel rightRulesTableModel
            , DefaultTableModel dataFieldAliasesTableModel)
    {
        DecimalFormat format = new DecimalFormat("#,##0.00");
        DecisionTreeModel leftTreeModel = treeModels.get(leftTreeModelId);
        DecisionTreeModel rightTreeModel = treeModels.get(rightTreeModelId);

        Set<String> ignoredDataFields = getIgnoredDataFields(dataFieldAliasesTableModel);
        Set<Rule> leftIntersection = leftTreeModel.getRulesIntersection(rightTreeModel.getRules(), ignoredDataFields);
        Set<Rule> rightIntersection = rightTreeModel.getRulesIntersection(leftTreeModel.getRules(), ignoredDataFields);

        leftRulesTableModel.setRowCount(0);
        rightRulesTableModel.setRowCount(0);
        int i = 0;
        for ( Rule rule : leftIntersection ) {
            i++;
            leftRulesTableModel.addRow(new Object[] {i, rule.getExpression(), getClassValueAlias(rule.getScore()), format.format(rule.getScoreRecordCount())});
        }

        i = 0;
        for ( Rule rule : rightIntersection ) {
            i++;
            rightRulesTableModel.addRow(new Object[] {i, rule.getExpression(), getClassValueAlias(rule.getScore()), format.format(rule.getScoreRecordCount())});
        }
    }

    private Set<String> getIgnoredDataFields(DefaultTableModel ignoredDataFieldsTableModel) {
        Set<String> ignoredDataFields = new HashSet<String>();
        for ( int i=0; i<ignoredDataFieldsTableModel.getRowCount(); i++ ) {
            if ( (Boolean)ignoredDataFieldsTableModel.getValueAt(i, 0) ) {
                ignoredDataFields.add((String)ignoredDataFieldsTableModel.getValueAt(i, 1));
            }
        }
        return ignoredDataFields;
    }

    public void onDataFieldAliasesTableChanged(TableModelEvent e) {
        if ( TableModelEvent.INSERT == e.getType() || TableModelEvent.INSERT == e.getType() ) {
            TableModel tableModel = (TableModel)e.getSource();
            int rowIndex = e.getFirstRow();
            String value = tableModel.getValueAt(rowIndex, 0) + "." + tableModel.getValueAt(rowIndex, 1);
            String alias = (String)tableModel.getValueAt(rowIndex, 2);
            dataFieldAliases.put(value, alias);
        }
    }

//    public void onDataFieldAliasesChanged(PropertyChangeEvent evt, TableModel tableModel) {
//        if (evt.getPropertyName().equals(DATA_FIELD_ALIASES_PROPERTY)) {
//            DefaultTableModel dataFieldAliasesTableModel = (DefaultTableModel)tableModel;
//            for ( Map.Entry<String, String> entry : dataFieldAliases.entrySet() ) {
//                String[] parts = entry.getKey().split("\\.");
//                dataFieldAliasesTableModel.addRow(new Object[]{parts[0], parts[1], entry.getValue()});
//            }
//        }
//    }

//    public void setOverviewTableModel(OverviewTableModel overviewTableModel) {
//        this.overviewTableModel = overviewTableModel;
//    }

    public void initDataFieldAliases(DefaultTableModel dataFieldAliasesTableModel) {
        initDataFieldAliasesFromProperties();
        for ( Map.Entry<String, String> entry : dataFieldAliases.entrySet() ) {
            String[] parts = entry.getKey().split("\\.");
            dataFieldAliasesTableModel.addRow(new Object[]{parts[0], parts[1], entry.getValue()});
        }
    }

    public String[] getDataFieldNames(OverviewTableModel overviewTableModel) {
        Set<String> dataFieldNames = new LinkedHashSet<String>();
        for ( String treeModelId : overviewTableModel.getEnabledTreeModels() ) {
            dataFieldNames.addAll(treeModels.get(treeModelId).getDataFieldNames());
        }
        return dataFieldNames.toArray(new String[dataFieldNames.size()]);
    }

    public ComboBoxItem[] getEnabledTreeModelsItems(OverviewTableModel overviewTableModel) {
        List<ComboBoxItem> items = new ArrayList<ComboBoxItem>();
        for ( String treeModelId : overviewTableModel.getEnabledTreeModels() ) {
            items.add(new ComboBoxItem(treeModels.get(treeModelId).getName(), treeModelId));
        }
        return items.toArray(new ComboBoxItem[items.size()]);
    }
}
