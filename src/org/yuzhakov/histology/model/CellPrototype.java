package org.yuzhakov.histology.model;

import java.util.ArrayList;
import java.util.List;

public class CellPrototype {
	private List<NodePrototype> nodes = new ArrayList<>();

	public List<NodePrototype> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodePrototype> nodes) {
		this.nodes = nodes;
	}
	
}
