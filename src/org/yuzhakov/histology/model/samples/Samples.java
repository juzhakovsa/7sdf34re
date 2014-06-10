package org.yuzhakov.histology.model.samples;

import java.util.List;

import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.NodePrototype;
import org.yuzhakov.histology.model.Topology;
import org.yuzhakov.histology.model.Vertex;

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
	
	
	
	public static NodePrototype hexagonTriangle(){
		Vertex b1 = new Vertex(0.8660254037844387, 0.5, 0.0);
		Vertex b2 = new Vertex(6.123233995736766E-17, 1.0, 0.0);
		Vertex b3 = new Vertex(-0.8660254037844385, 0.5, 0.0);
		Vertex b4 = new Vertex(-0.8660254037844388, -0.5, 0.0);
		Vertex b5 = new Vertex(-1.8369701987210297E-16, -1.0, 0.0);
		Vertex b6 = new Vertex(0.8660254037844388, -0.5, 0.0);
		
		Vertex u1 = new Vertex(0.8660254037844387, 0.5, 0.0);
		Vertex u2 = new Vertex(-0.8660254037844385, 0.5, 0.0);
		Vertex u3 = new Vertex(0, -2.0, 0.0);
		
		Topology bottom = new Topology(new Vertex[]{b1,b2,b3,b4,b5,b6});
		Topology upper = new Topology(new Vertex[]{u1,u2,u3});
		
		int[][] mapping = new int[][]{
				{0,0},
				{1,0},
				{2,1},
				{3,1},
				{4,2},
				{5,2},
		};

		NodePrototype proto = new NodePrototype();
		proto.setBottomTopology(bottom);
		proto.setUpperTopology(upper);
		proto.setMapping(mapping);
		
		return proto;
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
