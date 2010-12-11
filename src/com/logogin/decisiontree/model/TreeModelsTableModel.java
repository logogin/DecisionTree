package com.logogin.decisiontree.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * $Id$
 *
 * @created Nov 24, 2010
 * @author Pavel Danchenko
 */
public class TreeModelsTableModel extends AbstractTableModel {

    private List<Object[]> rows;
    private String[] columnNames;
    private Class<?>[] columnClasses;

    public TreeModelsTableModel() {
        columnNames = new String[] {"Name", "Rules"};
        columnClasses = new Class<?>[] {String.class, Integer.class};
        rows = new ArrayList<Object[]>();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addTreeModel(String id, String name
            , int rulesCount
            , int[] rulesCounts
            , int[] frequentRulesCounts
            , int[] relativeRulesCounts
            , double[] scoreRecordCounts
            , double[] relativeScoreRecordCounts) {
        int classValuesCount = rulesCounts.length;
        List<Object> row = new ArrayList<Object>();
        row.add(name);
        row.add(rulesCount);
        for (int i = 0; i < classValuesCount; i++) {
            row.add(rulesCounts[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            row.add(scoreRecordCounts[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            row.add(frequentRulesCounts[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            row.add(relativeRulesCounts[i]);
        }
        for (int i = 0; i < classValuesCount; i++) {
            row.add(relativeScoreRecordCounts[i]);
        }
        row.add(id);
        rows.add(row.toArray());
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public String getTreeModel(int rowIndex) {
        return (String)getValueAt(rowIndex, getColumnCount());
    }

    public void clear() {
        int rowCount = getRowCount();
        if ( rowCount > 0) {
            rows.clear();
            fireTableRowsDeleted(0, rowCount - 1);
        }
    }

    public void setColumns(String[] columnNames, Class<?>[] columnClasses) {
        this.columnNames = columnNames;
        this.columnClasses = columnClasses;
        fireTableStructureChanged();
    }
}
