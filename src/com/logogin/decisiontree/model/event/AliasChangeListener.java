package com.logogin.decisiontree.model.event;

import java.util.EventListener;

/**
 * $Id$
 *
 * @created Dec 8, 2010
 * @author Pavel Danchenko
 */
public interface AliasChangeListener extends EventListener {

    public void aliasChanged(AliasChangeEvent e);
}
