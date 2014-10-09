package org.yuzhakov.histology;

import java.util.List;

import javax.swing.JFrame;

import org.yuzhakov.histology.gui.ModelFrame;
import org.yuzhakov.histology.gui.ResultFrame;
import org.yuzhakov.histology.gui.cell.CellFrame;
import org.yuzhakov.histology.gui.histion.HistionFrame;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.gui.jreality.JrCutPlane;
import org.yuzhakov.histology.gui.jreality.JrModelCut;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.CutPlane;
import org.yuzhakov.histology.model.cut.ModelCut;
import org.yuzhakov.histology.model.m3D.Cell;
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
        		final SceneGraphComponent world2 = SceneGraphUtility.createFullSceneGraphComponent();
        		     		
//				List<Cell> cells = Gekko.getModel(3, 3);
				
				List<Cell> gistion = Gekko.getGisteon(new Vertex());
        		JrCell jrCell2 = new JrCell(gistion.get(8));
        		world2.addChild(jrCell2.getSceneGraphComponent());
				
//				List<Cell> cells = gisteon;
//				cells.add(gisteon.get(2));
				
				for (Cell cell : gistion){
					JrCell jrCell = new JrCell(cell);
					world.addChild(jrCell.getSceneGraphComponent());
				}
				
				final CutPlane cutPlane = new CutPlane();
				cutPlane.construct();
				final JrCutPlane JRcutPlane = new JrCutPlane(cutPlane);
				JRcutPlane.setPlaneSize(40, 40, 20);
				JRcutPlane.update();
				
				final ModelCut modelCut = new ModelCut(gistion, cutPlane);
				final JrModelCut jrModelCut = new JrModelCut(modelCut);
				
				
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
//            	
//            	ResultFrame resultFrame = new ResultFrame(jrModelCut.getSceneGraphComponent(), "Сечение 1");
            	
            	ResultFrame resultFrame = new ResultFrame(world2, "");
            	resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            	ResultFrame cutFrame = new ResultFrame(jrModelCut.getSceneGraphComponent(), "Сечение 1");
//            	cutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				JrCell jrCell = new JrCell(gistion.get(0));
//				CellFrame cellFrame = new CellFrame(Gekko.cellTypeA(), jrCell.getSceneGraphComponent(), "Тип А");
//				cellFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				HistionFrame histionFrame = new HistionFrame(Gekko.getGisteon(new Vertex()), world, "Гистион сетчатки геккона");
//				histionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				ModelFrame modelFrame = new ModelFrame(Gekko.getGisteon(new Vertex()), world, "Cетчатка геккона");
//				modelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
        });
	}
}
