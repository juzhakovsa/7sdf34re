package org.yuzhakov.histology.model;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.Util;

import de.jreality.shader.Color;

public class CellPrototype {
	private List<Topology> topologies = new ArrayList<>();
	private List<int[][]> mappings = new ArrayList<>();
	private Color color;
	
	public CellPrototype(){
		color = Util.getRandomColor();
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
	
	public int getNumberOfVertexes(int till_level){
		int s = 0;
		for (int i = 0; i < till_level;++i){
			s += topologies.get(i).getSize();
		}
		return s;
	}
	
	public int getNumberOfVertexes(){
		return getNumberOfVertexes(topologies.size());
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
	
	public List<int[]> getFaceIndices(){
		ArrayList<int[]> facesList = new ArrayList<>();
		facesList.addAll(getBottomFaceIndices());
		facesList.addAll(getTopFaceIndices());
		int numberOfLayers = topologies.size() - 1;
		for (int i = 0; i < numberOfLayers; ++i){
			facesList.addAll(getSideFaceIndices(i));
		}
		return facesList;
	}
	
	private List<int[]> getBottomFaceIndices(){
		return getBottomTopology().getTriangles();
	}
	
	private List<int[]> getTopFaceIndices(){
		int offset = getNumberOfVertexes(topologies.size() - 1);
		List<int[]> topFaceIndices = new ArrayList<>();
		for (int[] triangle : getTopTopology().getTriangles()){
			int[] face = new int[triangle.length];
			for (int i = 0; i < triangle.length;++i){
				face[i] = triangle[i] + offset;
			}
			topFaceIndices.add(face);
		}
		return topFaceIndices;
	}
	
	private List<int[]> getSideFaceIndices(int layer){
		int offsetBottom = getNumberOfVertexes(layer);
		int offsetTop = getNumberOfVertexes(layer+1);
		int[][] layerMapping = mappings.get(layer);
		List<int[]> sideFaceIndices = new ArrayList<>();
		
		int f = 0;
		for (; f < layerMapping.length - 1; ++f){
			int[] map1 = layerMapping[f];
			int[] map2 = layerMapping[f+1];
			int[] face = new int[4];
			face[0] = offsetBottom+map1[0];
			face[1] = offsetBottom+map2[0];
			face[2] = offsetTop+map2[1];
			face[3] = offsetTop+map1[1];
			sideFaceIndices.add(face);
		}
		
		int[] map1 = layerMapping[f];
		int[] map2 = layerMapping[0];
		int[] face = new int[4];
		face[0] = offsetBottom+map1[0];
		face[1] = offsetBottom+map2[0];
		face[2] = offsetTop+map2[1];
		face[3] = offsetTop+map1[1];
		sideFaceIndices.add(face);
		
		return sideFaceIndices;
	}
	
}
