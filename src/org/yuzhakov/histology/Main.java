package org.yuzhakov.histology;

import java.util.ArrayList;
import java.util.List;

import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.TriangulationAlgorithm;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;
import org.yuzhakov.histology.gui.MainFrame;

public class Main {
	public static void main(String[] args) {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//            	MainFrame mainFrame = new MainFrame();
//            	CellPropertiesFrame frame = new CellPropertiesFrame();
//            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	List<PolygonPoint> points = new ArrayList<>();
            	points.add(new PolygonPoint(1, 0, 0));
            	points.add(new PolygonPoint(0.25, 0.25, 0));
            	points.add(new PolygonPoint(0, 1, 0));
            	points.add(new PolygonPoint(-0.25, 0.25, 0));
            	points.add(new PolygonPoint(-1, 0, 0));
            	points.add(new PolygonPoint(-0.25, -0.25, 0));
            	points.add(new PolygonPoint(0, -1, 0));
            	points.add(new PolygonPoint(0.25, -0.25, 0));
            	Polygon polygon = new Polygon(points);
            	Poly2Tri.triangulate(polygon);
            	List<DelaunayTriangle> triangles = polygon.getTriangles();
            	System.out.println("Done");
            }
        });
	}
}
