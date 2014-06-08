package org.yuzhakov.histology.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private CellPrototype prototype;
	private List<Node> nodes = new ArrayList<>();
	private List<Double> heights;
	private Vertex offset;
	
	public Cell(CellPrototype prototype, List<Double> heights, double angle, Vertex offset) {
		super();
		this.prototype = prototype;
		this.heights = heights;
		this.offset = offset;
		
		initNodes(prototype, heights, angle, offset);
	}
	
	private void initNodes(CellPrototype prototype, List<Double> heights, double angle, Vertex offset){
		List<NodePrototype> prototypes = prototype.getNodes();
		double heightOffset = 0;
		for (int i = 0; i < prototypes.size(); ++i){
			NodePrototype prot = prototypes.get(i);
			double height = heights.get(i);
			Node node = new Node(prot, height, angle, Vertex.getSumm(offset, new Vertex(0,0,heightOffset)));
			heightOffset += height;
			nodes.add(i, node);
		}
	}

	public List<Node> getNodes() {
		return nodes;
	}
	
}
