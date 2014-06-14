package org.yuzhakov.histology.model.samples;

import java.awt.Color;

import org.la4j.matrix.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;

import de.jreality.geometry.IndexedLineSetFactory;
import de.jreality.scene.IndexedLineSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;

public class Axes {
	private double A;
	private double B;
	private SceneGraphComponent sceneGraphComponent;
	
	public Axes(){
		sceneGraphComponent = SceneGraphUtility.createFullSceneGraphComponent();
	}
	
	public void update(){
//		List<Vertex> points = modelCut.getPlanePoints(10, 10, 10);
//		double[][] coordinates = new double[points.size()][];
//		for (int i = 0; i < coordinates.length; ++i){
//			coordinates[i] = points.get(i).getCoordinates();
//		}
		double[][] c = new double[][]{
				{0,0,0},
				{1,0,0},
				{0,1,0},
				{0,0,1},
		};
		
		Matrix coordinates = new Basic2DMatrix(new double[][]{
				{0,0,0},
				{1,0,0},
				{0,1,0},
				{0,0,1}
				});
		Matrix rotA = new Basic2DMatrix(new double[][]{
				{Math.cos(A),0, Math.sin(A)},
				{0,1,0},
				{-Math.sin(A),0,Math.cos(A)},
				});
		
		Matrix rotB = new Basic2DMatrix(new double[][]{
				{1,0,0},
				{0,Math.cos(B),-Math.sin(B)},
				{0,Math.sin(B),Math.cos(B)},
				});
		
		Basic2DMatrix res = (Basic2DMatrix) coordinates.multiply(rotA).multiply(rotB);
		
		sceneGraphComponent.setGeometry(getIndexedLineSet(res.toArray()));
	}
	
	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

	public double getB() {
		return B;
	}

	public void setB(double b) {
		B = b;
	}

	public SceneGraphComponent getSceneGraphComponent() {
		return sceneGraphComponent;
	}

	private static IndexedLineSet getIndexedLineSet(double[][] coordinates){
		int[][] edges = new int[][]{
				{0,1},
				{0,2},
				{0,3}
		};
		IndexedLineSetFactory ilsf = new IndexedLineSetFactory();
	    
	    ilsf.setVertexCount( coordinates.length );
	    ilsf.setVertexCoordinates( coordinates );
	    ilsf.setEdgeCount(edges.length);
	    ilsf.setEdgeIndices(edges);
	    ilsf.setEdgeColors(new Color[]{
	    		Color.RED,
	    		Color.GREEN,
	    		Color.BLACK
	    });
	    
	    ilsf.update();
		
		return ilsf.getIndexedLineSet();
	}
	
	
}
