package com.logogin.decisiontree.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

/**
 * $Id$
 *
 * @created Nov 16, 2010
 * @author Pavel Danchenko
 */
public class OverviewTableModel extends AbstractTableModel {

    private Class<?>[] types = new Class [] {Boolean.class, String.class, Integer.class};
    private boolean[] canEdit = new boolean [] {true, false, false};

    private List<Object[]> rows;

    public OverviewTableModel() {
        rows = new ArrayList<Object[]>();
    }

    public Class<?> getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return types.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        rows.get(rowIndex)[columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addTreeModel(String id, String name, int rulesCount) {
        boolean updated = false;
        for ( int i = 0; i < rows.size(); i++ ) {
            Object[] row = rows.get(i);
            if ( id.equals(row[3]) ) {
                setValueAt(name, i, 1);
                setValueAt(rulesCount, i, 2);
                updated = true;
                break;
            }
        }
        if ( !updated ) {
            rows.add(new Object[] {true, name, rulesCount, id});
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public void clear() {
        int rowCount = getRowCount();
        if ( rowCount > 0) {
            rows.clear();
            fireTableRowsDeleted(0, rowCount - 1);
        }
    }

    public Set<String> getEnabledTreeModels() {
        Set<String> result = new LinkedHashSet<String>();
        for ( Object[] row : rows ) {
            if ( (Boolean)row[0] ) {
                result.add((String)row[3]);
            }
        }
        return result;
    }

    public void addTreeModel(DecisionTreeModel treeModel) {
        String id = treeModel.getId();
        //boolean updated = false;
        for ( int i = 0; i < rows.size(); i++ ) {
            Object[] row = rows.get(i);
            if ( id.equals(row[3]) ) {
                setValueAt(treeModel.getName(), i, 1);
                setValueAt(treeModel.getRulesCount(), i, 2);
                fireTableRowsUpdated(i, i);
                //updated = true;
                return;
                //break;
            }
        }
        rows.add(new Object[] {true, treeModel.getName(), treeModel.getRulesCount(), id});
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
//        if ( !updated ) {
//            rows.add(new Object[] {true, name, rulesCount, id});
//            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
//        }
    }

    public String getTreeModelId(int rowIndex) {
        return (String)getValueAt(rowIndex, 3);
    }

    public boolean getTreeModelEnabled(int rowIndex) {
        return (Boolean)getValueAt(rowIndex, 0);
    }
}
