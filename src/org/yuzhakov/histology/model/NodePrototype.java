package org.yuzhakov.histology.model;

public class NodePrototype {
	protected Topology upperTopology;
	protected Topology bottomTopology;
	protected int[][] mapping;
	
	public Topology getUpperTopology() {
		return upperTopology;
	}

	public void setUpperTopology(Topology upperTopology) {
		this.upperTopology = upperTopology;
	}

	public Topology getBottomTopology() {
		return bottomTopology;
	}

	public void setBottomTopology(Topology bottomTopology) {
		this.bottomTopology = bottomTopology;
	}

	public int[][] getMapping() {
		return mapping;
	}

	public void setMapping(int[][] mapping) {
		this.mapping = mapping;
	}
}
