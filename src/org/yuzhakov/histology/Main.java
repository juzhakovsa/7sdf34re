package org.yuzhakov.histology;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.gui.MainFrame;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.Node;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.samples.Samples;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainFrame mainFrame = new MainFrame();
			}
        });
	}
}
