package org.yuzhakov.histology;

import java.io.File;
import java.util.ArrayList;

import org.omg.CosNaming.IstringHelper;
import org.yuzhakov.histology.model.Node;

public class Tetgen {
	private double[] vertexes;
	private int numberOfVertexes;
	
	private int[] faces;
	private int[] facesSizes;
	private int numberOfFaces;
	
	private int[] tetrahedrons;
	private int numberOfTetrahedrons;
	
	
	static {
		System.load(
				new File("lib/JavaTetgen.dll").getAbsolutePath());
	}
	
	public Tetgen(Node node){
		//vertexes
		numberOfVertexes = node.getVertexCount();
		vertexes = new double[numberOfVertexes*3];
		double[][] nodeCoords = node.getVerticesCoordinates();
		int i = 0;
		int j = 0;
		for (; i < numberOfVertexes; ++i){
			vertexes[j] = nodeCoords[i][0];
			vertexes[j+1] = nodeCoords[i][1];
			vertexes[j+2] = nodeCoords[i][2];
			j+=3;
		}
		
		//faces
		numberOfFaces = node.getFacesCount();
		facesSizes = new int[numberOfFaces];
		int[][] nodeFaces = node.getFaces();
		int sum = 0;
		i = 0;
		for (; i < numberOfFaces; ++i){
			int s = nodeFaces[i].length;
			facesSizes[i] = s;
			sum += s;
		}
		faces = new int[sum];
		i = 0;
		j = 0;
		for (; i < numberOfFaces; ++i){
			int[] f = nodeFaces[i];
			for (int k = 0; k < f.length; ++k){
				faces[j] = f[k];
				++j;
			}
		}
		
		
	}
	
	public native void tetrahedralize(String params);

	public double[] getVertexes() {
		return vertexes;
	}

	public int getNumberOfVertexes() {
		return numberOfVertexes;
	}

	public int[] getFaces() {
		return faces;
	}

	public int[] getFacesSizes() {
		return facesSizes;
	}

	public int getNumberOfFaces() {
		return numberOfFaces;
	}

	public int[] getTetrahedrons() {
		return tetrahedrons;
	}

	public int getNumberOfTetrahedrons() {
		return numberOfTetrahedrons;
	}

	//For native executing: methods looks better in JNI
	private void setVertexes(double[] vertexes) {
		this.vertexes = vertexes;
	}

	private void setNumberOfVertexes(int numberOfVertexes) {
		this.numberOfVertexes = numberOfVertexes;
	}

	private void setFaces(int[] faces) {
		this.faces = faces;
	}

	private void setFacesSizes(int[] facesSizes) {
		this.facesSizes = facesSizes;
	}

	private void setNumberOfFaces(int numberOfFaces) {
		this.numberOfFaces = numberOfFaces;
	}

	private void setTetrahedrons(int[] tetrahedrons) {
		this.tetrahedrons = tetrahedrons;
	}

	private void setNumberOfTetrahedrons(int numberOfTetrahedrons) {
		this.numberOfTetrahedrons = numberOfTetrahedrons;
	}
	
	
	
	
}