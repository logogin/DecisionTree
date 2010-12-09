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
    //private int classValuesCount;
    private String[] columnNames;

    public TreeModelsTableModel() {
        //this.classValuesCount = 0;
        this.columnNames = new String[] {"Name", "Rules"};
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
            , int[] relativeRulesCounts) {
        int classValuesCount = rulesCounts.length;
        Object[] row = new Object[2 + 3 * classValuesCount + 1];
        row[0] = name;
        row[1] = rulesCount;
        for ( int i=0; i<classValuesCount; i++ ) {
            row[2 + i] = rulesCounts[i];
            row[2 + classValuesCount + i] = frequentRulesCounts[i];
            row[2 + 2 * classValuesCount + i] = relativeRulesCounts[i];
        }
        row[2 + 3 * classValuesCount] = id;
        rows.add(row);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public String getTreeModel(int rowIndex) {
        return (String)getValueAt(rowIndex, getColumnCount());
    }

//    public void setColumnIdentifiers(String[] columnIdentifiers) {
//        this.columnIdentifiers = columnIdentifiers;
//    }

    public void clear() {
        int rowCount = getRowCount();
        if ( rowCount > 0) {
            rows.clear();
            fireTableRowsDeleted(0, rowCount - 1);
        }
    }

    public void setColumnNames(String[] columnIdentifiers) {
        this.columnNames = columnIdentifiers;
        fireTableStructureChanged();
    }
}
