package org.yuzhakov.histology;

import java.util.ArrayList;
import java.util.List;

import org.la4j.LinearAlgebra;
import org.la4j.inversion.MatrixInverter;
import org.la4j.linear.LinearSystemSolver;
import org.la4j.matrix.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.Vector;
import org.la4j.vector.dense.BasicVector;
import org.yuzhakov.histology.gui.AxesFrame;
import org.yuzhakov.histology.gui.MainFrame;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.ModelCut;
import org.yuzhakov.histology.model.cut.Segment;
import org.yuzhakov.histology.model.cut.Tetrahedron;
import org.yuzhakov.histology.model.samples.Samples;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//            	MainFrame mainFrame = new MainFrame();
            	AxesFrame axesFrame = new AxesFrame();
			}
        });
	}
}
