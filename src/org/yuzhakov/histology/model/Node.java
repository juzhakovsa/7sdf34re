package org.yuzhakov.histology.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	protected NodePrototype prototype;
	protected double height;
	protected Vertex offset;
	private Vertex[] bottomLayer;
	private Vertex[] upperLayer;
	private double[][] coordinates;
	private int[][] faces;
	private int facesCount;
	private int[][] edges;
	private int edgesCount;

	public Node(NodePrototype prototype, double height, Vertex offset) {
		super();
		this.prototype = prototype;
		this.height = height;
		this.offset = offset;
		
		Vertex[] bv = prototype.getBottomTopology().getCoordinates();
		bottomLayer = copyWithOffset(bv, offset);
		
		Vertex[] uv = prototype.getUpperTopology().getCoordinates();
		Vertex heightVertex = new Vertex(0, 0, height);
		upperLayer = copyWithOffset(uv, Vertex.getSumm(offset, heightVertex));
		
		initVerticesCoordinates();
		initFaces();
		initEdges();
	}

	public Topology getUpperTopology() {
		return prototype.getUpperTopology();
	}

	public Topology getBottomTopology() {
		return prototype.getBottomTopology();
	}

	public int[][] getMapping() {
		return prototype.getMapping();
	}
	
	public double[][] getVerticesCoordinates(){
		return coordinates;
	}
	
	public int getVertexCount(){
		return bottomLayer.length + upperLayer.length;
	}
	
	public int[][] getFaces(){		
		return faces;
	}
	
	public int getFacesCount(){
		return facesCount;
	}

	public int[][] getEdges() {
		return edges;
	}

	public int getEdgesCount() {
		return edgesCount;
	}

	public double getHeight() {
		return height;
	}
	
	private Vertex[] copyWithOffset(Vertex[] v, Vertex offset){
		Vertex[] result = new Vertex[v.length];
		for (int i = 0; i < result.length; ++i){
			result[i] = Vertex.getSumm(v[i], offset);
		}
		return result;
	}

	public void initVerticesCoordinates(){
		coordinates = new double[bottomLayer.length + upperLayer.length][3];
		int i = 0;
		for (; i < bottomLayer.length; ++i){
			coordinates[i] = bottomLayer[i].getCoordinates();
		}
		for (int j = 0; j < upperLayer.length; ++j){
			coordinates[i] = upperLayer[j].getCoordinates();
			++i;
		}
	}
	
	public void initFaces(){
		int[][] mapping = prototype.getMapping();
		int offset = bottomLayer.length;
		ArrayList<int[]> indices = new ArrayList<>();
		
		//bottomIndices
		List<int[]> bottomTriangles = prototype.getBottomTopology().getTriangles();
		for (int[] triangle : bottomTriangles){
			indices.add(triangle);
		}
		
		//upperIndices		
		List<int[]> upperTriangles = prototype.getUpperTopology().getTriangles();
		for (int[] triangle : upperTriangles){
			int[] offsetTriangle = new int[3];
			for (int i = 0; i < offsetTriangle.length; ++i){
				offsetTriangle[i] = offset + triangle[i];
			}
			indices.add(offsetTriangle);
		}
		
		int f = 0;
		for (; f < mapping.length - 1; ++f){
			int[] map1 = mapping[f];
			int[] map2 = mapping[f+1];
			int[] face = new int[4];
			face[0] = map1[0];
			face[1] = map2[0];
			face[2] = offset+map2[1];
			face[3] = offset+map1[1];
			indices.add(face);
		}
		
		int[] map1 = mapping[f];
		int[] map2 = mapping[0];
		int[] face = new int[4];
		face[0] = map1[0];
		face[1] = map2[0];
		face[2] = offset+map2[1];
		face[3] = offset+map1[1];
		indices.add(face);
		
		facesCount = mapping.length + bottomTriangles.size() + upperTriangles.size();
		
		faces = indices.toArray(new int[0][0]);
	}
	
	public void initEdges(){
		int[][] mapping = prototype.getMapping();
		int offset = bottomLayer.length;
		ArrayList<int[]> edgesList = new ArrayList<>();
		
		//bottom
		for (int i = 0; i < bottomLayer.length - 1; ++i){
			edgesList.add(new int[]{i, i+1});
		}
		edgesList.add(new int[]{bottomLayer.length - 1, 0});
		
		//upper		
		for (int i = offset; i < upperLayer.length - 1 + offset; ++i){
			edgesList.add(new int[]{i, i+1});
		}
		edgesList.add(new int[]{upperLayer.length - 1 + offset, offset});
		
		//side
		for (int i = 0; i < mapping.length; ++i){
			int[] map = mapping[i];
			edgesList.add(new int[]{map[0], map[1]+offset});
		}
		
		edgesCount = edgesList.size();
		
		edges = edgesList.toArray(new int[0][0]);
	}
	
	public List<Vertex[]> getFacesCoordinates(){
		int[][] mapping = prototype.getMapping();
		List<Vertex[]> facesCoordinates = new ArrayList<>();
		
		//bottom
		Vertex[] bottom = new Vertex[bottomLayer.length];
		for (int i = 0; i < bottomLayer.length; ++i){
			bottom[i] = new Vertex(bottomLayer[i]); //copy
		}
		facesCoordinates.add(bottom);
		
		//upper
		Vertex[] upper = new Vertex[upperLayer.length];
		for (int i = 0; i < upperLayer.length; ++i){
			upper[i] = new Vertex(upperLayer[i]); //copy
		}
		facesCoordinates.add(upper);
		
		int f = 0;
		for (; f < mapping.length - 1; ++f){
			int[] map1 = mapping[f];
			int[] map2 = mapping[f+1];
			Vertex[] face = new Vertex[4];
			face[0] = new Vertex(bottomLayer[map1[0]]);
			face[1] = new Vertex(bottomLayer[map2[0]]);
			face[2] = new Vertex(upperLayer[map2[1]]);
			face[3] = new Vertex(upperLayer[map1[1]]);
			facesCoordinates.add(face);
		}
		
		int[] map1 = mapping[f];
		int[] map2 = mapping[0];
		Vertex[] face = new Vertex[4];
		face[0] = new Vertex(bottomLayer[map1[0]]);
		face[1] = new Vertex(bottomLayer[map2[0]]);
		face[2] = new Vertex(upperLayer[map2[1]]);
		face[3] = new Vertex(upperLayer[map1[1]]);
		facesCoordinates.add(face);
		
		return facesCoordinates;
	}
	
	public List<Vertex[]> getSideEdgesCoordinates(){
		int[][] mapping = prototype.getMapping();
		List<Vertex[]> edges = new ArrayList<>();
		
		Vertex vertexA,vertexB;		
		int f = 0;
		for (; f < mapping.length; ++f){
			int[] map = mapping[f];
			vertexA = new Vertex(bottomLayer[map[0]]);
			vertexB = new Vertex(upperLayer[map[1]]);
			edges.add(new Vertex[]{vertexA,vertexB});
		}
		
		return edges;
	}
	
}
