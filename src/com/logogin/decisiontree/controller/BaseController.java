package com.logogin.decisiontree.controller;

import javax.swing.event.EventListenerList;

import com.logogin.decisiontree.model.event.AliasChangeEvent;
import com.logogin.decisiontree.model.event.AliasChangeListener;
import com.logogin.decisiontree.model.event.ModelChangeEvent;
import com.logogin.decisiontree.model.event.ModelChangeListener;

public abstract class BaseController {

    private EventListenerList listenerList = new EventListenerList();

    public void addModelChangeListener(ModelChangeListener l) {
        listenerList.add(ModelChangeListener.class, l);
    }

    public void addAliasChangeListener(AliasChangeListener l) {
        listenerList.add(AliasChangeListener.class, l);
    }

    protected void fireModelChanged(ModelChangeEvent e) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==ModelChangeListener.class) {
                ((ModelChangeListener)listeners[i+1]).modelChanged(e);
            }
        }
    }

    protected void fireAliasChanged(AliasChangeEvent e) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==AliasChangeListener.class) {
                ((AliasChangeListener)listeners[i+1]).aliasChanged(e);
            }
        }
    }
}
