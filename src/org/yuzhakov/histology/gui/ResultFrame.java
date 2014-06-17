package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import de.jreality.math.MatrixBuilder;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.CameraUtility;

public class ResultFrame extends JFrame{
	private JPanel mainPanel;
	
	private JButton plus;
	private JButton minus;
	
	
	public ResultFrame(SceneGraphComponent sceneGraphComponent, String caption) {
		super(caption);
		
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
