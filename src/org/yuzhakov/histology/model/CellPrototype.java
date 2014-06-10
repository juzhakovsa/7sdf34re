package org.yuzhakov.histology.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.Util;

public class CellPrototype {
	private List<Topology> topologies = new ArrayList<>();
	private List<int[][]> mappings = new ArrayList<>();
	private Color color;
	
	public CellPrototype(){
		color = Util.getRandomColor();
	}

	@Deprecated
	public List<NodePrototype> getNodes() {
		return null;
	}

	@Deprecated
	public void setNodes(List<NodePrototype> nodes) {

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Topology> getTopologies() {
		return topologies;
	}
	
	public Topology getBottomTopology(){
		return topologies.get(0);
	}
	
	public Topology getTopTopology(){
		return topologies.get(topologies.size() - 1);
	}

	public List<int[][]> getMappings() {
		return mappings;
	}
	
	public List<Vertex[]> getTopologiesVertices(){
		List<Vertex[]> vertexs = new ArrayList<>();
		for (Topology topology : topologies){
			Vertex[] layer = new Vertex[topology.getSize()];
			vertexs.add(layer);
			for (int i = 0; i < layer.length; ++i){
				layer[i] = new Vertex(topology.getCoordinates()[i]); //copy
			}
		}
		return vertexs;
	}	
	
}
