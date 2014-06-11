package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.yuzhakov.histology.Tetgen;
import org.yuzhakov.histology.gui.jreality.JrCell;
import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.JRModelConverter;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.ModelCut;
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
		
		long time = System.currentTimeMillis();
    	ArrayList<Double> heights = new ArrayList<>();
    	heights.add(0.0);
    	heights.add(2.0);
    	heights.add(3.0);
    	heights.add(5.0);
		Cell cell = new Cell(Samples.Star4(3), heights, 0, new Vertex());
		JrCell jrCell = new JrCell(cell);
		Tetgen tetgen = new Tetgen(cell.getPrototype());
		tetgen.tetrahedralize(null);
		time = System.currentTimeMillis() - time;
		System.out.println(time);
		
		View.setTitle("The Icosahedron");
		viewer = JRViewer.createJRViewer(jrCell.getSceneGraphComponent());
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
