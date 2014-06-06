package org.yuzhakov.histology.model;

public class TriangularNode {
	private Vertex[] bottomLayer;
	private Vertex[] topLayer;
	
	public TriangularNode(){
		bottomLayer = new Vertex[3];
		topLayer = new Vertex[3];
	}
	
	public void setEdge(int index, Vertex bottom, Vertex top){
		bottomLayer[index] = bottom;
		topLayer[index] = top;
	}
	
	public Vertex getBottomVertex(int index){
		return bottomLayer[index];
	}
	
	public Vertex getTopVertex(int index){
		return topLayer[index];
	}
	
	public void setBottomVertex(int index, Vertex v){
		bottomLayer[index] = v;
	}
	
	public void setTopVertex(int index, Vertex v){
		topLayer[index] = v;
	}
}
