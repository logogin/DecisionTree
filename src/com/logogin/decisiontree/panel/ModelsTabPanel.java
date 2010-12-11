/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModelsTabPanel.java
 *
 * Created on Nov 27, 2010, 6:56:52 PM
 */

package com.logogin.decisiontree.panel;

import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;

import com.logogin.decisiontree.TreeAnalyzerApp;
import com.logogin.decisiontree.model.DecisionTreeModel;
import com.logogin.decisiontree.model.Rule;
import com.logogin.decisiontree.model.TreeModelsTableModel;
import com.logogin.decisiontree.model.event.AliasChangeEvent;
import com.logogin.decisiontree.model.event.AliasChangeListener;
import com.logogin.decisiontree.model.event.ModelChangeEvent;
import com.logogin.decisiontree.model.event.ModelChangeListener;
import com.logogin.decisiontree.view.ModelPropertiesFrame;

/**
 *
 * @author pavel
 */
public class ModelsTabPanel extends javax.swing.JPanel {

    private TreeAnalyzerApp app;
    private ModelPropertiesFrame propertiesFrame;

    /** Creates new form ModelsTabPanel */
    public ModelsTabPanel() {
        app = TreeAnalyzerApp.getApplication();
        propertiesFrame = new ModelPropertiesFrame(app);
        initComponents();
        postInitComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        scoreThresholdText = new JTextField();
        jLabel2 = new JLabel();
        coverageThresholdText = new JTextField();
        jScrollPane1 = new JScrollPane();
        modelsTable = new JTable();
        jScrollPane2 = new JScrollPane();
        rulesTable = new JTable();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setName("Form"); // NOI18N

        ResourceMap resourceMap = Application.getInstance(TreeAnalyzerApp.class).getContext().getResourceMap(ModelsTabPanel.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        scoreThresholdText.setText(resourceMap.getString("scoreThresholdText.text")); // NOI18N
        scoreThresholdText.setName("scoreThresholdText"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        coverageThresholdText.setText(resourceMap.getString("coverageThresholdText.text")); // NOI18N
        coverageThresholdText.setName("coverageThresholdText"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        modelsTable.setAutoCreateRowSorter(true);
        modelsTable.setModel(new TreeModelsTableModel());
        modelsTable.setName("modelsTable"); // NOI18N
        modelsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(modelsTable);
        modelsTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("modelsTable.columnModel.title0")); // NOI18N
        modelsTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("modelsTable.columnModel.title1")); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        rulesTable.setAutoCreateRowSorter(true);
        rulesTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Rule", "Class", "No. instances"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rulesTable.setName("rulesTable"); // NOI18N
        rulesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(rulesTable);
        rulesTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        rulesTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("rulesTable.columnModel.title0")); // NOI18N
        rulesTable.getColumnModel().getColumn(1).setPreferredWidth(1000);
        rulesTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("rulesTable.columnModel.title1")); // NOI18N
        rulesTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        rulesTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("rulesTable.columnModel.title2")); // NOI18N
        rulesTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        rulesTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("rulesTable.columnModel.title3")); // NOI18N

        ActionMap actionMap = Application.getInstance(TreeAnalyzerApp.class).getContext().getActionMap(ModelsTabPanel.class, this);
        jButton1.setAction(actionMap.get("recalculateAction")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("showPropertiesAction")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(scoreThresholdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(coverageThresholdText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {coverageThresholdText, scoreThresholdText});

        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(scoreThresholdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(coverageThresholdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void postInitComponents() {

        modelsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( e.getFirstIndex() != -1 && !e.getValueIsAdjusting() ) {
                    updateRulesTable(e.getFirstIndex());
                }
            }
        });

        app.getController().addAliasChangeListener(new AliasChangeListener() {
            @Override
            public void aliasChanged(AliasChangeEvent e) {
                recalculateAction();
            }
        });

        app.getController().addModelChangeListener(new ModelChangeListener() {
            @Override
            public void modelChanged(ModelChangeEvent e) {
                if ( ModelChangeEvent.MODELS_CHANGED == e.getType() ) {
                    recalculateAction();
                }
            }
        });
    }

    @Action
    public void recalculateAction() {
        Double scoreThreshold = Double.valueOf(scoreThresholdText.getText());
        Double coverageThreshold = Double.valueOf(coverageThresholdText.getText())/100.0;

        TreeModelsTableModel treeModelsTableModel = (TreeModelsTableModel)modelsTable.getModel();
        DefaultTableModel rulesTableModel = (DefaultTableModel)rulesTable.getModel();
        modelsTable.clearSelection();
        treeModelsTableModel.clear();
        rulesTableModel.setRowCount(0);

        treeModelsTableModel.setColumns(createColumnNames(coverageThreshold), createColumnClasses());
        int width = 80 / (modelsTable.getColumnCount() - 2);
        modelsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        modelsTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        for ( int i = 2; i < modelsTable.getColumnCount(); i++ ) {
            modelsTable.getColumnModel().getColumn(i).setPreferredWidth(width);
        }
        for ( String treeModelId : app.getController().getEnabledTreeModels() ) {
            DecisionTreeModel treeModel = app.getController().getTreeModel(treeModelId);
            treeModelsTableModel.addTreeModel(
                    treeModel.getId()
                    , treeModel.getName()
                    , treeModel.getRulesCount()
                    , app.getController().getRulesCounts(treeModel)
                    , app.getController().getFrequentRulesCounts(treeModel, scoreThreshold)
                    , app.getController().getRelativeRulesCounts(treeModel, coverageThreshold)
                    , app.getController().getScoreRecordCounts(treeModel)
                    , app.getController().getRelativeScoreRecordCounts(treeModel, coverageThreshold));
        }
    }

    private void updateRulesTable(int rowIndex) {
        DefaultTableModel rulesTableModel = (DefaultTableModel)rulesTable.getModel();
        rulesTableModel.setRowCount(0);

        String selectedTreeModelId = ((TreeModelsTableModel)modelsTable.getModel()).getTreeModel(rowIndex);
        List<Rule> rules = app.getController().getTreeModel(selectedTreeModelId).getRules();
        int i = 1;
        DecimalFormat format = new DecimalFormat("#,##0.0#");
        for ( Rule rule : rules ) {
            rulesTableModel.addRow(
                    new Object[] {i++
                            , rule.getExpression()
                            , app.getController().getClassValueAlias(rule.getScore())
                            , format.format(rule.getRecordCount()) + "/" + format.format(rule.getRecordCount() - rule.getScoreRecordCount())});
        }
    }

    private String[] createColumnNames(Double coverageThreshold) {
        int classValuesCount = app.getController().getClassValuesCount();
        String[] classValueAliases = app.getController().getClassValueAliases();
        List<String> columnNames = new ArrayList<String>();
        columnNames.add("Name");
        columnNames.add("Rules");
        for (int i = 0; i < classValuesCount; i++) {
            columnNames.add(classValueAliases[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnNames.add("No. instances " + classValueAliases[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnNames.add("Frequent rules " + classValueAliases[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnNames.add(coverageThreshold * 100 + "% rules coverage " + classValueAliases[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnNames.add("No. instances rules coverage " + classValueAliases[i]);
        }
        return columnNames.toArray(new String[columnNames.size()]);
    }

    private Class<?>[] createColumnClasses() {
        int classValuesCount = app.getController().getClassValuesCount();
        List<Class<?>> columnClasses = new ArrayList<Class<?>>();
        columnClasses.add(String.class);
        columnClasses.add(Integer.class);
        for (int i = 0; i < classValuesCount; i++) {
            columnClasses.add(Integer.class);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnClasses.add(Double.class);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnClasses.add(Integer.class);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnClasses.add(Integer.class);
        }
        for (int i = 0; i < classValuesCount; i++) {
            columnClasses.add(Double.class);
        }
        return columnClasses.toArray(new Class<?>[columnClasses.size()]);
    }

    @Action
    public void showPropertiesAction() {
        int rowIndex = modelsTable.getSelectedRow();
        if ( -1 != rowIndex ) {
            Double scoreThreshold = Double.valueOf(scoreThresholdText.getText());
            Double coverageThreshold = Double.valueOf(coverageThresholdText.getText())/100.0;

            String treeModelId = ((TreeModelsTableModel)modelsTable.getModel()).getTreeModel(rowIndex);
            propertiesFrame.setTreeModel(treeModelId, scoreThreshold, coverageThreshold);
            app.show(propertiesFrame);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField coverageThresholdText;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable modelsTable;
    private JTable rulesTable;
    private JTextField scoreThresholdText;
    // End of variables declaration//GEN-END:variables

}
