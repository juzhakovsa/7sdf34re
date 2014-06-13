package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

import de.jreality.plugin.JRViewer;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.scene.Viewer;

public class JRealityComponent extends JPanel{
	private static final long serialVersionUID = 5745189816553846673L;
	private JRViewer viewer;
	private Component viewingComponent;

	public JRealityComponent(SceneGraphComponent component) {
		super(new BorderLayout());
		
		
		viewer = JRViewer.createJRViewer(component);
		viewer.startupLocal();
		Viewer v = viewer.getViewer();
		viewingComponent = (Component) v.getViewingComponent();
		this.add(viewingComponent);
		this.setVisible(true);
	}
	

	public JRViewer getJRViewer() {
		return viewer;
	}
	
	public Component getViewingComponent(){
		return viewingComponent;
	}
}
