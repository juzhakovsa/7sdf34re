package org.yuzhakov.histology.model;

import de.jreality.shader.Color;
import java.util.ArrayList;
import java.util.List;

public class Cell {
	private CellPrototype prototype;
	private List<Double> heights;
	private Vertex offset;
	private double angle;
	
	public Cell(CellPrototype prototype, List<Double> heights, double angle, Vertex offset) {
		this.prototype = prototype;
		this.heights = new ArrayList<>(heights);
		this.offset = offset;
		this.angle = angle;
	}
	
	public List<Vertex[]> getTopologiesVertices(){
		List<Vertex[]> vertexs = new ArrayList<>();
		int level = 0;
		for (Topology topology : prototype.getTopologies()){
			double height = heights.get(level);
			Vertex[] layer = copyWithOffsetRotationHeight(topology.getCoordinates(),offset,angle,height);
			vertexs.add(layer);
			++level;
		}
		return vertexs;
	}
	
	public Color getColor(){
		return prototype.getColor();
	}

	public CellPrototype getPrototype() {
		return prototype;
	}

	public List<Double> getHeights() {
		return heights;
	}

	public Vertex getOffset() {
		return offset;
	}

	public double getAngle() {
		return angle;
	}
	
	public int getNumberOfTopologies(){
		return prototype.getTopologies().size();
	}
	
	public int getNumberOfVertexes(int till_level){
		return prototype.getNumberOfVertexes(till_level);
	}
	
	public int getNumberOfVertexes(){
		return prototype.getNumberOfVertexes();
	}
	
	private static Vertex[] copyWithOffsetRotationHeight(Vertex[] v, Vertex offset, double angle, double Z){
		Vertex[] result = new Vertex[v.length];
		for (int i = 0; i < result.length; ++i){
			result[i] = Vertex.getSumm(offset, Vertex.rotate(v[i], angle));
			result[i].Z = Z;
		}
		return result;
	}
	
}
