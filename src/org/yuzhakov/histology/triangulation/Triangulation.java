package org.yuzhakov.histology.triangulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.TriangulationPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;
import org.yuzhakov.histology.model.Vertex;

public class Triangulation {	
	public static List<int[]> triangulate(Vertex[] vertexes){
		List<Vertex> vertexList = new ArrayList<>(Arrays.asList(vertexes));		
		List<PolygonPoint> points = new ArrayList<>();
		for (Vertex v:vertexes){
			points.add(new PolygonPoint(v.X, v.Y, v.Z));
		}
    	Polygon polygon = new Polygon(points);
    	Poly2Tri.triangulate(polygon);
    	List<int[]> triangles = new ArrayList<>();
    	for (DelaunayTriangle dTriangle : polygon.getTriangles()){
			triangles.add(
					getTriangleIndices(
							getTriangleVertexes(dTriangle),
							vertexList));
    	}
		return triangles;
	}
	
	private static Vertex getVertex(TriangulationPoint point){
		return new Vertex(point.getX(),point.getY(),point.getZ());
	}
	
	private static Vertex[] getTriangleVertexes(DelaunayTriangle triangle){
		Vertex[] result = new Vertex[3];
		int i = 0;
		for (TriangulationPoint p : triangle.points){
			result[i] = getVertex(p);
			++i;
		}
		return result;
	}
	
	private static int[] getTriangleIndices(Vertex[] triangle, List<Vertex> indexList){
		int[] indices = new int[3];
		for (int i = 0; i < triangle.length; ++i){
			indices[i] = indexList.indexOf(triangle[i]);
		}
		return indices;
	}
}
