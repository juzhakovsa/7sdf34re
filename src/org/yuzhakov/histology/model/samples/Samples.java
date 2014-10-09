package org.yuzhakov.histology.model.samples;

import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.m2D.Topology;
import org.yuzhakov.histology.model.m3D.CellPrototype;

public class Samples {
	
	public static CellPrototype hexagonPrismNode(){		
		Topology topology = new Topology(new Vertex[] {
				new Vertex(0.8660254037844387, 0.5, 0.0),
				new Vertex(0, 1.0, 0.0),
				new Vertex(-0.8660254037844385, 0.5, 0.0),
				new Vertex(-0.8660254037844388, -0.5, 0.0),
				new Vertex(0, -1.0, 0.0),
				new Vertex(0.8660254037844388, -0.5, 0.0) });
		
		
		int[][] mapping = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{3,3},
				{4,4},
				{5,5},
		};

		CellPrototype hexagonPrism = new CellPrototype();
		hexagonPrism.getTopologies().add(topology);
		hexagonPrism.getTopologies().add(topology);
		hexagonPrism.getMappings().add(mapping);
		
		return hexagonPrism;
	}
	
	
	public static Topology star4Topology(){
		return new Topology(new Vertex[]{
				new Vertex(1, 0, 0),
				new Vertex(0.25, 0.25, 0),
				new Vertex(0, 1, 0),
				new Vertex(-0.25, 0.25, 0),
				new Vertex(-1, 0, 0),
				new Vertex(-0.25, -0.25, 0),
				new Vertex(0, -1, 0),
				new Vertex(0.25, -0.25, 0)
		});
	}
	
	public static CellPrototype Star4(int layers){		
		Topology topology = star4Topology();
		
		int[][] mapping = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{3,3},
				{4,4},
				{5,5},
				{6,6},
				{7,7}
		};

		CellPrototype star4 = new CellPrototype();
		star4.getTopologies().add(topology);
		for (int i = 0; i < layers; ++i){
			star4.getTopologies().add(topology);
			star4.getMappings().add(mapping);
		}
		
		return star4;
	}
}
