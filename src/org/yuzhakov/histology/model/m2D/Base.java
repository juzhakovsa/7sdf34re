package org.yuzhakov.histology.model.m2D;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.triangulation.Triangulation;

public class Base{
	private List<Vertex> topologyVertices = new ArrayList<>();
	private List<Vertex> auxilaryVertices = new ArrayList<>();
	private List<Vertex> allVertices = new ArrayList<>();
	private List<Integer> topologyVerticesIndex = new ArrayList<>();
	
	public Base(){
		super();
	}
	
	public Base(Topology topology){
		this();
		for (Vertex vertex : topology.getCoordinates()){
			addTopologyVertex(vertex);
		}
	}
	
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
	
	public List<Integer> getTopologyVerticesIndex() {
		return topologyVerticesIndex;
	}
	public void setTopologyVerticesIndex(List<Integer> topologyVerticesIndex) {
		this.topologyVerticesIndex = topologyVerticesIndex;
	}
	public int addTopologyVertex(Vertex vertex){
		allVertices.add(vertex);
		int index = allVertices.size()-1;
		topologyVertices.add(vertex);
		topologyVerticesIndex.add(index);
		return index;
	}
	public int addAuxilaryVertex(Vertex vertex){
		allVertices.add(vertex);
		auxilaryVertices.add(vertex);
		return allVertices.size()-1;
	}
	public int size(){
		return allVertices.size();
	}
	public List<int[]> getTriangulation(){
		return Triangulation.triangulate(
				topologyVertices,
				topologyVerticesIndex);
	}
	
}
