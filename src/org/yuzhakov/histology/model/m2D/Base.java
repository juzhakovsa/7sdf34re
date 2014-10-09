package org.yuzhakov.histology.model.m2D;

import java.util.List;

import org.yuzhakov.histology.model.Vertex;

public class Base{
	private List<Vertex> topologyVertices;
	private List<Vertex> auxilaryVertices;
	private List<Vertex> allVertices;
	private List<Boolean> isTopologicalList;
	
	public List<Vertex> getTopologyVertices() {
		return topologyVertices;
	}
	public void setTopologyVertices(List<Vertex> topologyVertices) {
		this.topologyVertices = topologyVertices;
	}
	public List<Vertex> getAuxilaryVertices() {
		return auxilaryVertices;
	}
	public void setAuxilaryVertices(List<Vertex> auxilaryVertices) {
		this.auxilaryVertices = auxilaryVertices;
	}
	public List<Vertex> getAllVertices() {
		return allVertices;
	}
	public void setAllVertices(List<Vertex> allVertices) {
		this.allVertices = allVertices;
	}
	public int addTopologyVertex(Vertex vertex){
		topologyVertices.add(vertex);
		allVertices.add(vertex);
		isTopologicalList.add(true);
		return allVertices.size()-1;
	}
	public int addAuxilaryVertex(Vertex vertex){
		auxilaryVertices.add(vertex);
		allVertices.add(vertex);
		isTopologicalList.add(false);
		return allVertices.size()-1;
	}
	public int size(){
		return allVertices.size();
	}
	
}
