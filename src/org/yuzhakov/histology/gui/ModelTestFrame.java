package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

import org.yuzhakov.histology.Tetgen;
import org.yuzhakov.histology.gui.jreality.JRUtils;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.gui.jreality.JrCutPlane;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.ModelCut;
import org.yuzhakov.histology.model.samples.Samples;

import de.jreality.math.MatrixBuilder;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.tutorial.scene.CameraPathExample;
import de.jreality.util.CameraUtility;
import de.jreality.util.SceneGraphUtility;

public class ModelTestFrame extends JFrame{
	private JPanel mainPanel;
	
	private JButton plus;
	private JButton minus;
	
	
	public ModelTestFrame(SceneGraphComponent sceneGraphComponent) {
		super("Histology 3D");
		
//		ArrayList<Double> heights = new ArrayList<>();
//    	heights.add(0.0);
//    	heights.add(2.0);
//		
//		final SceneGraphComponent world = SceneGraphUtility.createFullSceneGraphComponent();
//		for (int i = 0; i < 10; ++i){
//			for (int j = 0; j < 10; ++j){
//				double X = -10 + 2*i;
//				double Y = -10 + 2*j;
//				Cell cell = new Cell(Samples.Star4(1), heights, 0, new Vertex(X,Y,0));
//				JrCell jrCell = new JrCell(cell);
//				world.addChild(jrCell.getSceneGraphComponent());
//			}
//		}
		
		setJMenuBar(new MainMenuBar());
		
		JRealityComponent jRealityComponent = new JRealityComponent(sceneGraphComponent);
		final SceneGraphComponent cameraNode = CameraUtility.getCameraNode(jRealityComponent.getJRViewer().getViewer());
		
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(jRealityComponent, BorderLayout.CENTER);
		mainPanel.add(getToolBar(), BorderLayout.NORTH);
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MatrixBuilder.euclidean(cameraNode).translate(0,0,1).assignTo(cameraNode);
			}
		});
		
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MatrixBuilder.euclidean(cameraNode).translate(0,0,-1).assignTo(cameraNode);
			}
		});
		
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	validate();
    	pack();
    	setVisible(true);
	}
	
	private JToolBar getToolBar(){
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		plus = SwingUtils.makeNavigationButton("ZoomIn24", "ZOOM_IN", "Увеличить");
		toolBar.add(plus);
		minus = SwingUtils.makeNavigationButton("ZoomOut24", "ZOOM_OUT", "Уменьшить");
		toolBar.add(minus);
		
		
		
		return toolBar;
	}
}
