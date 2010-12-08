package com.logogin.decisiontree.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.dmg.pmml_3_1.DataField;

/**
 * $Id$
 *
 * @created Nov 16, 2010
 * @author Pavel Danchenko
 */
public class OverviewTableModel extends AbstractTableModel {

    private Class<?>[] types = new Class [] {Boolean.class, String.class, Integer.class};
    private boolean[] canEdit = new boolean [] {true, false, false};

    private Map<String, DecisionTreeModel> pmmlModels = new LinkedHashMap<String, DecisionTreeModel>();
    private List<Object[]> rows;

    public OverviewTableModel() {
        rows = new ArrayList<Object[]>();
        //super(new Object[][] {}, new String[] {"Enabled", "Model", "Rules"});
    }

    public Class<?> getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

//    public void addPMMLModel(String absolutePath, DecisionTreeModel adapter) {
//        if ( !pmmlModels.containsKey(getUniqueName(absolutePath)) ) {
//            pmmlModels.put(getUniqueName(absolutePath), adapter);
//            rows.add(new Object[] {true, adapter.getName(), adapter.getRulesCount(), getUniqueName(absolutePath)});
//            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
//        }
//    }

//    public List<DecisionTreeModel> getEnabledDecisionTreeModels() {
//        List<DecisionTreeModel> result = new ArrayList<DecisionTreeModel>();
//        for ( int i=0; i<getRowCount(); i++ ) {
//            if ( (Boolean)getValueAt(i, 0) ) {
//                result.add(pmmlModels.get(getValueAt(i, getColumnCount())));
//            }
//        }
//        return result;
//    }

//    public Set<String> getEnabledDataFieldNames() {
//        Set<String> result = new LinkedHashSet<String>();
//        for ( DecisionTreeModel treeModel : getEnabledDecisionTreeModels() ) {
//            result.addAll(treeModel.getDataFieldNames());
//        }
//        return result;
//    }
//    public Set<String> getDataFieldNames() {
//        Set<String> result = new LinkedHashSet<String>();
//        for ( int i=0; i<getRowCount(); i++ ) {
//            if ( (Boolean)getValueAt(i, 0) ) {
//                PMMLModelAdapter adapter = pmmlModels.get(getValueAt(i, 3));
//                for ( DataField dataField : adapter.getDataFields() ) {
//                    result.add(dataField.getName());
//                }
//            }
//
//        }
//    }

//    private String getUniqueName(String absolutePath) {
//        return absolutePath;
//    }
//
//    private String getDistinguishingName(String absolutePath) {
//        String[] parts = absolutePath.split("/");
//        return parts[parts.length - 1];
//    }

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
}
