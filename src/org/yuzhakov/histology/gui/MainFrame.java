package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
import org.yuzhakov.histology.model.cut.CutPlane;
import org.yuzhakov.histology.model.cut.ModelCut;
import org.yuzhakov.histology.model.samples.Samples;

import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	
	private JSlider sliderA;
	private JSlider sliderB;
	private JSlider sliderZ;
	
	
	public MainFrame() {
		super("Histology 3D");
		
		ArrayList<Double> heights = new ArrayList<>();
    	heights.add(0.0);
    	heights.add(1.0);
    	heights.add(2.0);
		Cell cell = new Cell(Samples.Star4(2), heights, 0, new Vertex());
		JrCell jrCell = new JrCell(cell);
		Tetgen tetgen = new Tetgen(cell.getPrototype());
		tetgen.tetrahedralize(null);

		final CutPlane cutPlane = new CutPlane();
		cutPlane.construct();
		final ModelCut modelCut = new ModelCut(cutPlane);
		modelCut.setTetrahedrons(tetgen.getTetrahedronList());
//		for (Vertex[] tet : modelCut.getCut()) {
//			for (Vertex v : tet) {
//				System.out.println(v);
//			}
//			System.out.println("---------------------------");
//		}
		
//		final JrCutPlane cutPlane = new JrCutPlane(modelCut);
		final SceneGraphComponent world = SceneGraphUtility.createFullSceneGraphComponent();
		world.setGeometry(JRUtils.getIndexedFaceSet(modelCut.getCut()));
//		world.addChild(cutPlane.getSceneGraphComponent());
//		world.addChild(jrCell.getSceneGraphComponent());
		
		setJMenuBar(new MainMenuBar());
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(new JRealityComponent(world), BorderLayout.CENTER);
		mainPanel.add(getSliderPanel(), BorderLayout.EAST);
		
		sliderA.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				JSlider slider = (JSlider) event.getSource();
				if (slider.getValueIsAdjusting())
					return;
				double A = (double) sliderA.getValue() * Math.PI / 90;
				cutPlane.setA(A);
				cutPlane.construct();
				world.setGeometry(JRUtils.getIndexedFaceSet(modelCut.getCut()));
			}
		});

		sliderB.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				JSlider slider = (JSlider) event.getSource();
				if (slider.getValueIsAdjusting())
					return;
				double B = (double) sliderB.getValue() * Math.PI / 90;
				cutPlane.setB(B);
				cutPlane.construct();
				world.setGeometry(JRUtils.getIndexedFaceSet(modelCut.getCut()));
			}
		});

		sliderZ.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				JSlider slider = (JSlider) event.getSource();
				if (slider.getValueIsAdjusting())
					return;
				double Z = (double) slider.getValue() * 2 / 100;
				cutPlane.setZ(Z);
				cutPlane.construct();
				world.setGeometry(JRUtils.getIndexedFaceSet(modelCut.getCut()));
			}
		});
		
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	validate();
    	pack();
    	setVisible(true);
	}
	
	private JPanel getSliderPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		sliderA = new JSlider(-90, 90, 0);
		sliderA.setName("Parameter A");
		panel.add(sliderA);
		sliderB = new JSlider(-90, 90, 0);
		sliderB.setName("Parameter B");
		panel.add(sliderB);
		sliderZ = new JSlider(0, 100, 0);
		sliderZ.setName("Parameter Z");
		panel.add(sliderZ);
		
		return panel;
	}
}
