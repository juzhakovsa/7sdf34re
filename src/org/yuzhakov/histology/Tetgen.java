package org.yuzhakov.histology;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.IstringHelper;
import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.Vertex;

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
	
	public Tetgen(CellPrototype cellPrototype){
		//vertexes
		numberOfVertexes = cellPrototype.getNumberOfVertexes();
		vertexes = new double[numberOfVertexes*3];
		int i = 0;
		int j = 0;
		int layer = 0;
		for (Vertex[] topologyCoordinates : cellPrototype.getTopologiesVertices()){
			for (Vertex v:topologyCoordinates){
				vertexes[i] = v.X;
				vertexes[i+1] = v.Y;
				vertexes[i+2] = layer;
				i+=3;
			}
			++layer;
		}
		
		//faces
		int[][] nodeFaces = cellPrototype.getFaceIndices().toArray(new int[0][0]);
		numberOfFaces = nodeFaces.length;
		facesSizes = new int[numberOfFaces];
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
