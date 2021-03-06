/*
 * TreeAnalyzerApp.java
 */

package com.logogin.decisiontree;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

import com.logogin.decisiontree.controller.EventQueueProxy;
import com.logogin.decisiontree.controller.OutputViewer;
import com.logogin.decisiontree.controller.SwingConsole;
import com.logogin.decisiontree.controller.TreeAnalyzerController;

/**
 * The main class of the application.
 */
public class TreeAnalyzerApp extends SingleFrameApplication {

    private TreeAnalyzerController controller;

    public TreeAnalyzerApp() {
        super();
        controller = new TreeAnalyzerController();
    }

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        //controller = new TreeAnalyzerController();
        //EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        //queue.push(new EventQueueProxy());
//        try {
//            new SwingConsole();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        OutputViewer.init();
        show(new TreeAnalyzerView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TreeAnalyzerApp
     */
    public static TreeAnalyzerApp getApplication() {
        return Application.getInstance(TreeAnalyzerApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(TreeAnalyzerApp.class, args);
    }

    public TreeAnalyzerController getController() {
        return controller;
    }
}
