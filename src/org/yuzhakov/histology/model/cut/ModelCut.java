package org.yuzhakov.histology.model.cut;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.Settings;
import org.yuzhakov.histology.model.Vertex;

public class ModelCut {
	private Vertex normal;
	private Vertex offset;
	private List<Tetrahedron> tetrahedrons;
	
	public ModelCut(){
		offset = new Vertex();
		normal = new Vertex(0,0,1);
	}
	
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
			for (Vertex v : cutSegment(segment)){
				if (!intersections.contains(v))
					intersections.add(v);
			}
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
	
	public List<Vertex> getPlanePoints(double X, double Y, double Z){
		ArrayList<Vertex> points = new ArrayList<>();
		//Z
		double[][] params = new double[][]{
				{X,Y},
				{-X,Y},
				{-X,-Y},
				{X,-Y},
		};
		for (int i = 0; i < params.length && points.size() < 4; ++i){
			Vertex v = getZCoordinate(params[i][0], params[i][1]);
			if (v != null)
				points.add(v);
		}
		//Y
		params = new double[][]{
				{X,Z},
				{-X,Z},
				{-X,-Z},
				{X,-Z},
		};
		for (int i = 0; i < params.length && points.size() < 4; ++i){
			Vertex v = getYCoordinate(params[i][0], params[i][1]);
			if (v != null)
				points.add(v);
		}
		//X
		params = new double[][]{
				{Y,Z},
				{-Y,Z},
				{-Y,-Z},
				{Y,-Z},
		};
		for (int i = 0; i < params.length && points.size() < 4; ++i){
			Vertex v = getXCoordinate(params[i][0], params[i][1]);
			if (v != null)
				points.add(v);
		}
		
		return points;
	}
	
	private Vertex getXCoordinate(double y, double z){
		double D = -(normal.X*offset.X + normal.Y*offset.Y + normal.Z*offset.Z);
		double S = normal.Y*y + normal.Z*z + D;
		if (Math.abs(normal.X) < Settings.DEFAULT_PRECISION){
			if (Math.abs(S) < Settings.DEFAULT_PRECISION){
				return new Vertex(0,y,z); //ANY
			}
			return null; //NONE
		}
		double x = -S/normal.X;
		return new Vertex(x,y,z);
	}
	
	private Vertex getYCoordinate(double x, double z){
		double D = -(normal.X*offset.X + normal.Y*offset.Y + normal.Z*offset.Z);
		double S = normal.X*x + normal.Z*z + D;
		if (Math.abs(normal.Y) < Settings.DEFAULT_PRECISION){
			if (Math.abs(S) < Settings.DEFAULT_PRECISION){
				return new Vertex(x,0,z); //ANY
			}
			return null; //NONE
		}
		double y = -S/normal.Y;
		return new Vertex(x,y,z);
	}
	
	private Vertex getZCoordinate(double x, double y){
		double D = -(normal.X*offset.X + normal.Y*offset.Y + normal.Z*offset.Z);
		double S = normal.X*x + normal.Y*y + D;
		if (Math.abs(normal.Z) < Settings.DEFAULT_PRECISION){
			if (Math.abs(S) < Settings.DEFAULT_PRECISION){
				return new Vertex(x,y,0); //ANY
			}
			return null; //NONE
		}
		double z = -S/normal.Z;
		return new Vertex(x,y,z);
	}
	
	
}
