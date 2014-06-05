package org.yuzhakov.histology.model;

import java.util.HashMap;
import java.util.List;

public class ModelCut {
	private Vertex normal;
	private Vertex offset;
	
	private HashMap<Node, Vertex[]> cuts = new HashMap<>();

	public ModelCut(Vertex normal, Vertex offset) {
		super();
		this.normal = normal;
		this.offset = offset;
	}
	
	public void cut(Node node){
		List<Vertex[]> edges = node.getSideEdgesCoordinates();
		edges = node.getSideEdgesCoordinates();	
	}
	
}
