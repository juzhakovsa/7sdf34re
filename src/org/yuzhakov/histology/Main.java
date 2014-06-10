package org.yuzhakov.histology;

import org.yuzhakov.histology.gui.MainFrame;
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
//				Node node = new Node(Samples.Star4(), 2, 0, new Vertex());
//				long time = System.currentTimeMillis();
//				for (int i = 0; i < 10000; ++i){
//					Tetgen tetgen = new Tetgen(node);
//					tetgen.tetrahedralize("");
//				}
//				time = System.currentTimeMillis() - time;
//				System.out.println(time);
			}
        });
	}
}
