package org.yuzhakov.histology;

import java.util.ArrayList;
import java.util.List;

import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.TriangulationAlgorithm;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;
import org.yuzhakov.histology.gui.MainFrame;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.samples.Samples;

public class Main {
	public static void main(String[] args) {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainFrame mainFrame = new MainFrame();
            }
        });
	}
}
