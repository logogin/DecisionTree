package com.logogin.decisiontree.controller;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * @created Dec 13, 2010
 * @author Pavel Danchenko
 */
public class SwingConsole extends JFrame {
    
    private PipedInputStream piOut;
    private PipedInputStream piErr;
    private PipedOutputStream poOut;
    private PipedOutputStream poErr;

    private JTextArea textArea = new JTextArea();

    public SwingConsole() throws IOException {
        super("Swing Console");

        // Set up System.out
        piOut = new PipedInputStream();
        poOut = new PipedOutputStream(piOut);
        System.setOut(new PrintStream(poOut, true));

        // Set up System.err
        piErr = new PipedInputStream();
        poErr = new PipedOutputStream(piErr);
        System.setErr(new PrintStream(poErr, true));

        // Add a scrolling text area
        textArea.setEditable(false);
        textArea.setRows(20);
        textArea.setColumns(50);
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
        setVisible(true);

        // Create reader threads
        new ReaderThread(piOut).start();
        new ReaderThread(piErr).start();
    }

    private class ReaderThread extends Thread {

        //private PipedInputStream pi;
        private BufferedReader br;

        public ReaderThread(PipedInputStream pi) {
            //this.pi = pi;
            br = new BufferedReader(new InputStreamReader(pi));
        }

        public void run() {
            //final byte[] buf = new byte[1024];
            try {
                while (true) {
                    final String str = br.readLine();
                    if ( str == null ) {
                        break;
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            textArea.append(str + "\n");
                            // Make sure the last line is always visible
                            textArea.setCaretPosition(textArea.getDocument().getLength());
                            // Keep the text area down to a certain character size
                            int idealSize = 1000;
                            int maxExcess = 500;
                            int excess = textArea.getDocument().getLength() - idealSize;
                            if (excess >= maxExcess) {
                                textArea.replaceRange(null, 0, excess);
                            }
                        }
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {

            }
        }
    }
}
