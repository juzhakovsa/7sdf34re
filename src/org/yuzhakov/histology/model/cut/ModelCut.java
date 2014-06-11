package org.yuzhakov.histology.model.cut;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.Settings;
import org.yuzhakov.histology.model.Vertex;

public class ModelCut {
	private Vertex normal;
	private Vertex offset;
	private List<Tetrahedron> tetrahedrons;
	
	public Vertex getNormal() {
		return normal;
	}
	public void setNormal(Vertex normal) {
		this.normal = normal;
	}
	public Vertex getOffset() {
		return offset;
	}
	public void setOffset(Vertex offset) {
		this.offset = offset;
	}
	public List<Tetrahedron> getTetrahedrons() {
		return tetrahedrons;
	}
	public void setTetrahedrons(List<Tetrahedron> tetrahedrons) {
		this.tetrahedrons = tetrahedrons;
	}
	
	public List<Vertex[]> getCut(){
		ArrayList<Vertex[]> cuts = new ArrayList<>();
		for (Tetrahedron tetrahedron : tetrahedrons){
			cuts.add(cutTetrahedron(tetrahedron).toArray(new Vertex[0]));
		}
		return cuts;
	}
	
	private List<Vertex> cutTetrahedron(Tetrahedron tetrahedron){
		ArrayList<Vertex> intersections = new ArrayList<>();
		for (Segment segment : tetrahedron.getSegments()){
			intersections.addAll(cutSegment(segment));
		}
		return intersections;
	}
	
	private List<Vertex> cutSegment(Segment segment){
		ArrayList<Vertex> intersections = new ArrayList<>();
		double A = (normal.X*segment.vector.X + normal.Y*segment.vector.Y + normal.Z*segment.vector.Z);
		double f = (normal.X*segment.start.X + normal.Y*segment.start.Y + normal.Z*segment.start.Z);
		double g = (normal.X*offset.X + normal.Y*offset.Y + normal.Z*offset.Z);
		double B = g-f;
		if (Math.abs(A) < Settings.DEFAULT_PRECISION){
			if (Math.abs(B) >= Settings.DEFAULT_PRECISION)
				return intersections;
			
			intersections.add(new Vertex(segment.start));
			intersections.add(new Vertex(segment.end));
			return intersections;
		}
		double R = B/A;
		if (R > 1 || R < 0)
			return intersections;
		
		Vertex add = new Vertex(segment.vector);
		add.multiply(R);
		
		Vertex result = Vertex.getSumm(
				segment.start,
				add);
		intersections.add(result);
		return intersections;
	}
}
