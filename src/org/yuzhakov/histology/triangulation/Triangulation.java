package org.yuzhakov.histology.triangulation;

import java.util.ArrayList;
import java.util.List;

import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.TriangulationPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;
import org.yuzhakov.histology.model.Vertex;

public class Triangulation {	
	public static List<int[]> triangulate(List<Vertex> vertices, List<Integer> index){
		if (vertices.size() < 3){
			return new ArrayList<>();
		}
		
		List<PolygonPoint> points = new ArrayList<>();
		if (index == null){
			for (int i = 0; i < vertices.size(); ++i) {
				points.add(new TriangulationVertex(vertices.get(i), i));
			}
		}else{
			for (int i = 0; i < vertices.size(); ++i) {
				points.add(new TriangulationVertex(vertices.get(i), index.get(i)));
			}
		}
    	Polygon polygon = new Polygon(points);
    	Poly2Tri.triangulate(polygon);
    	List<int[]> triangles = new ArrayList<>();
    	for (DelaunayTriangle dTriangle : polygon.getTriangles()){
			triangles.add(
					getTriangleIndices(dTriangle));
    	}
		return triangles;
	}
	
	public static List<int[]> triangulate(List<Vertex> vertices){
		return triangulate(vertices,null);
	}
	
	private static int[] getTriangleIndices(DelaunayTriangle triangle){
		int[] indices = new int[3];
		int i = 0;
		for (TriangulationPoint point : triangle.points){
			if (point instanceof TriangulationVertex){
				TriangulationVertex vertex = (TriangulationVertex) point;
				indices[i++] = vertex.getIndex();
			}else{
				//The case, then triangulation add some extra points. Check that your polygon is flat.
				throw new ClassCastException("Not realized case, read comments for details");
			}
		}
		return indices;
	}
	
	private static class TriangulationVertex extends PolygonPoint{
		private Vertex vertex;
		private int index;
		
		public TriangulationVertex(Vertex vertex, int index) {
			super(vertex.X, vertex.Y, vertex.Z);
			this.vertex = vertex;
			this.index = index;
		}

		public Vertex getVertex() {
			return vertex;
		}

		public int getIndex() {
			return index;
		}		
	}
}
