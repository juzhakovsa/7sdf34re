package org.yuzhakov.histology.model;

import java.awt.Color;
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
	
//	private void initNodes(CellPrototype prototype, List<Double> heights, double angle, Vertex offset){
//		List<NodePrototype> prototypes = prototype.getNodes();
//		double heightOffset = 0;
//		for (int i = 0; i < prototypes.size(); ++i){
//			NodePrototype prot = prototypes.get(i);
//			double height = heights.get(i);
//			Node node = new Node(prot, height, angle, Vertex.getSumm(offset, new Vertex(0,0,heightOffset)));
//			heightOffset += height;
//			nodes.add(i, node);
//		}
//	}
	
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
		int s = 0;
		for (int i = 0; i < till_level;++i){
			s += prototype.getTopologies().get(i).getSize();
		}
		return s;
	}
	
	public int getNumberOfVertexes(){
		return getNumberOfVertexes(prototype.getTopologies().size());
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
