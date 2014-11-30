package org.yuzhakov.histology.model.m3D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.m2D.Base;

public class Slice {
	private Base top;
	private Base bottom;
	private int[][] mapping;
	
	private List<Vertex> vertices;
	private List<Integer[]> faces;
	
	public Slice(Base top, Base bottom, int[][] mapping) {
		super();
		this.top = top;
		this.bottom = bottom;
		this.mapping = mapping;
		initFaces();
	}
	public Base getTop() {
		return top;
	}
	public void setTop(Base top) {
		this.top = top;
	}
	public Base getBottom() {
		return bottom;
	}
	public void setBottom(Base bottom) {
		this.bottom = bottom;
	}
	public int[][] getMapping() {
		return mapping;
	}
	public void setMapping(int[][] mapping) {
		this.mapping = mapping;
	}
	public List<Vertex> getVertices() {
		return vertices;
	}
	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	public List<Integer[]> getFaces() {
		return faces;
	}
	public void setFaces(List<Integer[]> faces) {
		this.faces = faces;
	}
	private void initFaces(){
		Factory factory = new Factory(top.getAllVertices(), bottom.getAllVertices());
		
		int f = 0;
		for (; f < mapping.length - 1; ++f){
			int[] map1 = mapping[f];
			int[] map2 = mapping[f+1];
			factory.addSideFace(map1[0], map2[0], map1[1], map2[1]);			
		}		
		int[] map1 = mapping[f];
		int[] map2 = mapping[0];
		factory.addSideFace(map1[0], map2[0], map1[1], map2[1]);
		
		factory.addTopFace(top.getCentralVerticesIndex());
		factory.addBottomFace(bottom.getCentralVerticesIndex());
		
		this.vertices = factory.getVertices();
		this.faces = factory.getFaces();
	}
	
	private class Factory{
		private List<Vertex> topVertices;
		private List<Vertex> bottomVertices;
		
		private List<Integer> topIndexList = new LinkedList<>();
		private List<Integer> bottomIndexList = new LinkedList<>();
		private List<Vertex> newIndexList = new LinkedList<>();
		private List<Integer[]> faces = new LinkedList<>();
		
		public Factory(List<Vertex> topVertices, List<Vertex> bottomVertices) {
			super();
			this.topVertices = topVertices;
			this.bottomVertices = bottomVertices;
		}
		
		public void addSideFace(int bottom1, int bottom2, int top1, int top2){
			List<Integer> face = new ArrayList<>(4);
			
			face.add(getIndexVertexBottom(bottom1));
			if (bottom2 != bottom1)
				face.add(getIndexVertexBottom(bottom2));
			face.add(getIndexVertexTop(top2));
			if (bottom1 != bottom2)
				face.add(getIndexVertexTop(top1));
			
			if (face.size() < 3)
				return; //Not a face
			faces.add(face.toArray(new Integer[0]));
		}
		
		public void addTopFace(List<Integer> top){
			List<Integer> face = new ArrayList<>(top.size());
			
			for (Integer index : top)
				face.add(getIndexVertexTop(index));
			
			if (face.size() < 3)
				return; //Not a face
			faces.add(face.toArray(new Integer[0]));
		}
		
		public void addBottomFace(List<Integer> bottom){
			List<Integer> face = new ArrayList<>(bottom.size());
			
			for (Integer index : bottom)
				face.add(getIndexVertexBottom(index));
			
			if (face.size() < 3)
				return; //Not a face
			faces.add(face.toArray(new Integer[0]));
		}
		
		public List<Integer[]> getFaces() {
			return new ArrayList<>(faces);
		}

		public List<Vertex> getVertices() {
			return new ArrayList<>(newIndexList);
		}

		private int getIndexVertexTop(int index){
			Integer newIndex = topIndexList.get(index);
			if (newIndex == null){
				newIndex =  newIndexList.size();
				topIndexList.add(index, newIndex);
				Vertex vertex = topVertices.get(index);
				newIndexList.add(newIndex, vertex);				
			}
			return newIndex;
		}
		
		private int getIndexVertexBottom(int index){
			Integer newIndex = bottomIndexList.get(index);
			if (newIndex == null){
				newIndex =  newIndexList.size();
				bottomIndexList.add(index, newIndex);
				Vertex vertex = bottomVertices.get(index);
				newIndexList.add(newIndex, vertex);				
			}
			return newIndex;
		}
		
	}
	
}
