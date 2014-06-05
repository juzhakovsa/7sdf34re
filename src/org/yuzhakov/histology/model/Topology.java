package org.yuzhakov.histology.model;

import org.yuzhakov.histology.Util;

public class Topology {
	private int size;
	private double[] edges;
	private double[] angles;
	private Vertex[] coordinates;
	
	public Topology(int size) {
		this.size = size;
		edges = new double[size];
		angles = new double[size];
		coordinates = new Vertex[size];
	}

	public int getSize() {
		return size;
	}

	public double[] getEdges() {
		return edges;
	}

	public double[] getAngles() {
		return angles;
	}

	public Vertex[] getCoordinates() {
		return coordinates;
	}
	
	public void normalize(){
		//Ищем размер самого большого ребра
		double maxValue = edges[0];
		for (int i = 1; i < size; ++i){
			if (edges[i] > maxValue)
				maxValue = edges[i];
		}
		
		//Нормализуем и округляем ребра
		for (int c = 0; c < size;++c){
			edges[c] = Util.round(edges[c]/maxValue);
		}
		//Пересчитываем координаты
		for (int i = 0; i < size; ++i){
			coordinates[i].multiply(1/maxValue);
		}
	}
	
	
	public static Topology getTopology(Vertex[] v){
		int size = v.length;		
		Topology topology = new Topology(size);
		topology.edges = getEdges(v);
		topology.angles = getAngles(v);
		for (int i = 0; i < v.length; ++i){
			topology.coordinates[i] = new Vertex(v[i]);
		}
		topology.normalize();
		return topology;
	}
	
	private static double[] getEdges(Vertex[] v){
		int size = v.length;
		double[] lengths = new double[size];
		int i;
		for (i = 0; i < size - 1; ++i){
			lengths[i] = Vertex.getDistance(v[i], v[i+1]);
		}
		lengths[i] = Vertex.getDistance(v[i], v[0]);
		//round
		for (int c = 0; c < lengths.length;++c){
			lengths[c] = Util.round(lengths[c]);
		}
		
		return lengths;
	}
	
	private static double[] getAngles(Vertex[] v){
		int size = v.length;
		double[] angles = new double[size];
		int i;
		for (i = 0; i < size - 2; ++i){
			angles[i] = Vertex.getAngle(v[i], v[i+1], v[i+2]);
		}
		angles[i] = Vertex.getAngle(v[i], v[i+1], v[0]);
		++i;
		angles[i] = Vertex.getAngle(v[i], v[0], v[1]);		
		// round
		for (int c = 0; c < angles.length; ++c) {
			angles[c] = Util.round(angles[c]);
		}
		return angles;
	}

	public void setEdges(double[] edges) {
		this.edges = edges;
	}
}
