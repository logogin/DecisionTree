package com.logogin.decisiontree.controller;

import java.awt.AWTEvent;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

/**
 * @created Dec 13, 2010
 * @author Pavel Danchenko
 */
public class EventQueueProxy extends EventQueue {

    @Override
    protected void dispatchEvent(AWTEvent event) {
        try {
            super.dispatchEvent(event);
        } catch (Throwable t) {
            t.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occured", t.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
