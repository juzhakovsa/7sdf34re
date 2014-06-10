package org.yuzhakov.histology.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CellPrototype {
	private int numberOfTopologies;
	private List<Topology> topologies = new ArrayList<>();
	private List<int[]> mappings = new ArrayList<>();
	private List<NodePrototype> nodes = new ArrayList<>();
	private Color color;

	public List<NodePrototype> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodePrototype> nodes) {
		this.nodes = nodes;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
