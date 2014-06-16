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
import org.yuzhakov.histology.gui.ModelTestFrame;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.ModelCut;
import org.yuzhakov.histology.model.cut.Segment;
import org.yuzhakov.histology.model.cut.Tetrahedron;
import org.yuzhakov.histology.model.samples.Gekko;
import org.yuzhakov.histology.model.samples.Samples;

import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		ArrayList<Double> heights = new ArrayList<>();
        		for (int i = 0; i < 10; ++i){
        			heights.add((double) i);
        		}
        		ArrayList<Double> heightsD = new ArrayList<>(heights);
        		heightsD.remove(0);
        		heightsD.remove(0);
        		heightsD.remove(0);
        		
        		final SceneGraphComponent world = SceneGraphUtility.createFullSceneGraphComponent();
        		
        		Cell cellA = new Cell(Gekko.cellTypeA(), heights, 0, new Vertex(0,0,0));
        		Cell cellB = new Cell(Gekko.cellTypeB(), heights, 0, new Vertex(Gekko.H,-Gekko.H,0));
        		Cell cellC = new Cell(Gekko.cellTypeC(), heights, 0, new Vertex(0.5,-Gekko.H,0));
        		Cell cellD = new Cell(Gekko.cellTypeD(), heightsD, 0, new Vertex(Gekko.H,0,0));
        		
        		JrCell jrCellA = new JrCell(cellA);
        		JrCell jrCellB = new JrCell(cellB);
        		JrCell jrCellC = new JrCell(cellC);
				JrCell jrCellD = new JrCell(cellD);
				
				world.addChild(jrCellA.getSceneGraphComponent());
				world.addChild(jrCellB.getSceneGraphComponent());
				world.addChild(jrCellC.getSceneGraphComponent());
				world.addChild(jrCellD.getSceneGraphComponent());
				
            	ModelTestFrame modelTestFrame = new ModelTestFrame(world);
			}
        });
	}
}
