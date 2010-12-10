package com.logogin.decisiontree.model.event;

import java.util.EventObject;

import com.logogin.decisiontree.model.DecisionTreeModel;

/**
 * $Id$
 *
 * @created Dec 8, 2010
 * @author Pavel Danchenko
 */
public class ModelChangeEvent extends EventObject {

//    public static final int MODEL_ENABLED = 1;
//    public static final int MODEL_DISABLED = 2;
    public static final int MODEL_ADDED = 3;
    public static final int MODELS_REMOVED = 4;
    public static final int MODELS_CHANGED = 5;

    private DecisionTreeModel treeModel;
    private int type;

    public ModelChangeEvent(Object source) {
        super(source);
    }

    public ModelChangeEvent(Object source, DecisionTreeModel treeModel) {
        this(source);
        this.treeModel = treeModel;
        this.type = MODEL_ADDED;
    }

//    public ModelChangeEvent(Object source, DecisionTreeModel treeModel, boolean enabled) {
//        this(source, treeModel);
//        this.type = enabled ? MODEL_ENABLED : MODEL_DISABLED;
//    }

    public DecisionTreeModel getTreeModel() {
        return treeModel;
    }

    public int getType() {
        return type;
    }

    public static ModelChangeEvent createModelsRemovedEvent(Object source) {
        ModelChangeEvent e = new ModelChangeEvent(source);
        e.type = MODELS_REMOVED;
        return e;
    }

    public static ModelChangeEvent createModelsChangedEvent(Object source) {
        ModelChangeEvent e = new ModelChangeEvent(source);
        e.type = MODELS_CHANGED;
        return e;
    }
}
