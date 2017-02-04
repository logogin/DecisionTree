package com.logogin.decisiontree.model.event;

import java.util.EventListener;

/**
 * @created Dec 8, 2010
 * @author Pavel Danchenko
 */
public interface ModelChangeListener extends EventListener {

    public void modelChanged(ModelChangeEvent e);
}
