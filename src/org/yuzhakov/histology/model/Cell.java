package org.yuzhakov.histology.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private CellPrototype prototype;
	private List<Node> nodes = new ArrayList<>();
	private List<Double> heights;
	private Vertex offset;
	
	public Cell(CellPrototype prototype, List<Double> heights, Vertex offset) {
		super();
		this.prototype = prototype;
		this.heights = heights;
		this.offset = offset;
		
		initNodes(prototype, heights, offset);
	}
	
	private void initNodes(CellPrototype prototype, List<Double> heights, Vertex offset){
		List<NodePrototype> prototypes = prototype.getNodes();
		for (int i = 0; i < prototypes.size(); ++i){
			NodePrototype prot = prototypes.get(i);
			double height = heights.get(i);
			Node node = new Node(prot, height, offset);
			nodes.add(i, node);
		}
	}

	
}
