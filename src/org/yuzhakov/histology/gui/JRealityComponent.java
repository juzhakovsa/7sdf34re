package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import org.yuzhakov.histology.model.JRModelConverter;
import org.yuzhakov.histology.model.ModelCut;
import org.yuzhakov.histology.model.Node;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.samples.Samples;

import de.jreality.plugin.JRViewer;
import de.jreality.plugin.basic.View;
import de.jreality.scene.IndexedFaceSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.scene.Viewer;
import de.jreality.util.SceneGraphUtility;

public class JRealityComponent extends JPanel{
	private static final long serialVersionUID = 5745189816553846673L;
	private JRViewer viewer;
	private Component viewingComponent;

	public JRealityComponent() {
		super(new BorderLayout());
		Node sample1 = new Node(Samples.hexagonTriangle(), 4, new Vertex());
//		Node sample2 = new Node(Samples.hexagonPrism, 1, new Vertex(1,1,4));
//		
//		ModelCut cut = new ModelCut(new Vertex(0, 0, 1), new Vertex(0,0,1));
//		cut.cut(sample1);
//		
		IndexedFaceSet g1 = JRModelConverter.getGeometry(sample1);
//		IndexedFaceSet g2 = JRModelConverter.getGeometry(sample2);
//		
		SceneGraphComponent c1 = SceneGraphUtility.createFullSceneGraphComponent();
		c1.setGeometry(g1);
//		SceneGraphComponent c2 = SceneGraphUtility.createFullSceneGraphComponent();
//		c2.setGeometry(g2);
//		
//		SceneGraphComponent world = SceneGraphUtility.createFullSceneGraphComponent();
//		world.addChild(c1);
//		world.addChild(c2);
		
		View.setTitle("The Icosahedron");
		viewer = JRViewer.createJRViewer(c1);
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
