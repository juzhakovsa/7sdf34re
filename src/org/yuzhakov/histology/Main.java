package org.yuzhakov.histology;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
        		final double height = 6;
        		
        		final SceneGraphComponent world = SceneGraphUtility.createFullSceneGraphComponent();
        		     		
				List<Cell> cells = Gekko.getModel(3, 3);
				
//				List<Cell> gisteon = Gekko.getGisteon(new Vertex());
				
//				List<Cell> cells = gisteon;
//				cells.add(gisteon.get(2));
				
				for (Cell cell : cells){
					JrCell jrCell = new JrCell(cell);
					world.addChild(jrCell.getSceneGraphComponent());
				}
				
				final CutPlane cutPlane = new CutPlane();
				cutPlane.construct();
				final JrCutPlane JRcutPlane = new JrCutPlane(cutPlane);
				JRcutPlane.setPlaneSize(40, 40, 20);
				JRcutPlane.update();
				
				final ModelCut modelCut = new ModelCut(cells, cutPlane);
				final JrModelCut jrModelCut = new JrModelCut(modelCut);
				
				
				world.addChild(JRcutPlane.getSceneGraphComponent());

            	ModelFrame modelTestFrame = new ModelFrame(world, "������ �������"){
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
            	ResultFrame cutResultFrame = new ResultFrame(jrModelCut.getSceneGraphComponent(), "������� 1");
			}
        });
	}
}
