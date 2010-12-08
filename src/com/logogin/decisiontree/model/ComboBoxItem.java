package com.logogin.decisiontree.model;

/**
 * $Id$
 *
 * @created Nov 26, 2010
 * @author Pavel Danchenko
 */
public class ComboBoxItem {

    private String label;
    private Object value;

    public ComboBoxItem(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return label;
    }
}
