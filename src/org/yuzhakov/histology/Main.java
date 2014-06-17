package org.yuzhakov.histology;

import java.util.ArrayList;
import org.yuzhakov.histology.gui.ModelFrame;
import org.yuzhakov.histology.gui.ResultFrame;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.gui.jreality.JrCutPlane;
import org.yuzhakov.histology.gui.jreality.JrModelCut;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.CutPlane;
import org.yuzhakov.histology.model.cut.ModelCut;
import org.yuzhakov.histology.model.samples.Gekko;
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
        		
        		final double height = 6;
        		
        		final SceneGraphComponent world = SceneGraphUtility.createFullSceneGraphComponent();
        		
        		CellPrototype typeA = Gekko.cellTypeA();
        		
        		Cell cellA1 = new Cell(Gekko.cellTypeA(), heights, 0, new Vertex(0,0,0));
        		Cell cellA2 = new Cell(Gekko.cellTypeA(), heights, 0, new Vertex(0,Gekko.H*2,0));
        		Cell cellB1 = new Cell(Gekko.cellTypeB(), heights, 0, new Vertex(Gekko.H,Gekko.H,0));
        		Cell cellB2 = new Cell(Gekko.cellTypeB(), heights, 0, new Vertex(Gekko.H,-Gekko.H,0));
        		Cell cellC1 = new Cell(Gekko.cellTypeC(), heights, 0, new Vertex(0.5,-Gekko.H,0));
        		Cell cellC2 = new Cell(Gekko.cellTypeC(), heights, 180, new Vertex(Gekko.H+Gekko.D,-Gekko.H,0));
        		Cell cellC3 = new Cell(Gekko.cellTypeC(), heights, 0, new Vertex(0.5,Gekko.H,0));
        		Cell cellC4 = new Cell(Gekko.cellTypeC(), heights, 180, new Vertex(Gekko.H+Gekko.D,Gekko.H,0));
        		Cell cellD1 = new Cell(Gekko.cellTypeD(), heightsD, 0, new Vertex(Gekko.H,0,0));
        		Cell cellD2 = new Cell(Gekko.cellTypeD(), heightsD, 0, new Vertex(Gekko.H,Gekko.H*2,0));
        		
//        		JrCell jrCellA = new JrCell(cellA);
//        		JrCell jrCellB = new JrCell(cellB1);
//        		JrCell jrCellC = new JrCell(cellC);
//				JrCell jrCellD = new JrCell(cellD);
				
				ArrayList<Cell> cells = new ArrayList<>();
				cells.add(cellA1);
				cells.add(cellA2);
				cells.add(cellB1);
				cells.add(cellB2);
				cells.add(cellC1);
				cells.add(cellC2);
				cells.add(cellC3);
				cells.add(cellC4);
				cells.add(cellD1);
				cells.add(cellD2);
				
				for (Cell cell : cells){
					JrCell jrCell = new JrCell(cell);
					world.addChild(jrCell.getSceneGraphComponent());
				}
				
				final CutPlane cutPlane = new CutPlane();
				cutPlane.construct();
				final JrCutPlane JRcutPlane = new JrCutPlane(cutPlane);
				
				final ModelCut modelCut = new ModelCut(cells, cutPlane);
				final JrModelCut jrModelCut = new JrModelCut(modelCut);
				
//				world.addChild(jrCellA.getSceneGraphComponent());
//				world.addChild(jrCellB.getSceneGraphComponent());
//				world.addChild(jrCellC.getSceneGraphComponent());
//				world.addChild(jrCellD.getSceneGraphComponent());
				
				world.addChild(JRcutPlane.getSceneGraphComponent());

            	ModelFrame modelTestFrame = new ModelFrame(world, "Модель Геккона"){
            		@Override
            		public void sliderStateChanged(double A, double B, double Z) {
            			cutPlane.setA(A);
            			cutPlane.setB(B);
            			cutPlane.setZ(Z*height);
            			cutPlane.construct();
            			JRcutPlane.update();
            			jrModelCut.update();
            		}
            	};
            	ResultFrame cutResultFrame = new ResultFrame(jrModelCut.getSceneGraphComponent(), "Сечение 1");
			}
        });
	}
}
