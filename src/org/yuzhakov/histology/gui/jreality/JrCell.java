package org.yuzhakov.histology.gui.jreality;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.model.Cell;
import org.yuzhakov.histology.model.Topology;
import org.yuzhakov.histology.model.Vertex;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.scene.IndexedFaceSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;

public class JrCell {
	private Cell cell;
	private SceneGraphComponent sceneGraphComponent;
	
	public JrCell(Cell cell){
		this.cell = cell;
		double[][] coordinates = getVertexCoordinates(cell);
		int[][] faceIndices = getFaceIndices(cell);
		
		sceneGraphComponent = SceneGraphUtility.createFullSceneGraphComponent();
		sceneGraphComponent.setGeometry(getIndexedFaceSet(coordinates, faceIndices));
	}
	
	public Cell getCell() {
		return cell;
	}

	public SceneGraphComponent getSceneGraphComponent() {
		return sceneGraphComponent;
	}



	private static double[][] getVertexCoordinates(Cell cell){
		ArrayList<double[]> coordinates = new ArrayList<>();
		for (Vertex[] topologyCoordinates : cell.getTopologiesVertices()){
			for (Vertex v:topologyCoordinates){
				coordinates.add(v.getCoordinates());
			}
		}
		
		return coordinates.toArray(new double[0][0]);
	}
	
	private static int[][] getFaceIndices(Cell cell){
		ArrayList<int[]> facesList = new ArrayList<>();
		facesList.addAll(getBottomFaceIndices(cell));
		facesList.addAll(getTopFaceIndices(cell));
		int numberOfLayers = cell.getNumberOfTopologies() - 1;
		for (int i = 0; i < numberOfLayers; ++i){
			facesList.addAll(getSideFaceIndices(cell, i));
		}
		return facesList.toArray(new int[0][0]);
	}
	
	private static List<int[]> getBottomFaceIndices(Cell cell){
		return cell.getPrototype().getBottomTopology().getTriangles();
	}
	
	private static List<int[]> getTopFaceIndices(Cell cell){
		int offset = cell.getNumberOfVertexes(cell.getNumberOfTopologies() - 1);
		List<int[]> topFaceIndices = new ArrayList<>();
		for (int[] triangle : cell.getPrototype().getTopTopology().getTriangles()){
			int[] face = new int[triangle.length];
			for (int i = 0; i < triangle.length;++i){
				face[i] = triangle[i] + offset;
			}
			topFaceIndices.add(face);
		}
		return topFaceIndices;
	}
	
	private static List<int[]> getSideFaceIndices(Cell cell, int layer){
		int offsetBottom = cell.getNumberOfVertexes(layer);
		int offsetTop = cell.getNumberOfVertexes(layer+1);
		int[][] layerMapping = cell.getPrototype().getMappings().get(layer);
		List<int[]> sideFaceIndices = new ArrayList<>();
		
		int f = 0;
		for (; f < layerMapping.length - 1; ++f){
			int[] map1 = layerMapping[f];
			int[] map2 = layerMapping[f+1];
			int[] face = new int[4];
			face[0] = offsetBottom+map1[0];
			face[1] = offsetBottom+map2[0];
			face[2] = offsetTop+map2[1];
			face[3] = offsetTop+map1[1];
			sideFaceIndices.add(face);
		}
		
		int[] map1 = layerMapping[f];
		int[] map2 = layerMapping[0];
		int[] face = new int[4];
		face[0] = offsetBottom+map1[0];
		face[1] = offsetBottom+map2[0];
		face[2] = offsetTop+map2[1];
		face[3] = offsetTop+map1[1];
		sideFaceIndices.add(face);
		
		return sideFaceIndices;
	}
	
	private static IndexedFaceSet getIndexedFaceSet(double[][] coordinates, int[][] faceIndices){
		IndexedFaceSetFactory ifsf = new IndexedFaceSetFactory();
		ifsf.setVertexCount(coordinates.length);
		ifsf.setFaceCount(faceIndices.length);
		ifsf.setVertexCoordinates(coordinates);
		ifsf.setFaceIndices(faceIndices);
//		ifsf.setEdgeCount(node.getEdgesCount());
//		ifsf.setEdgeIndices(node.getEdges());
		ifsf.setGenerateFaceNormals(true);
		ifsf.setGenerateEdgesFromFaces(true);
		ifsf.update();
		
		return ifsf.getIndexedFaceSet();
	}
}
