package org.yuzhakov.histology.gui.jreality;

import static de.jreality.shader.CommonAttributes.*;

import java.util.ArrayList;
import java.util.List;

import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.m3D.Cell;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.scene.Appearance;
import de.jreality.scene.IndexedFaceSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.shader.Color;
import de.jreality.util.SceneGraphUtility;

public class JrCell {
	private Cell cell;
	private SceneGraphComponent sceneGraphComponent;
	
	public JrCell(Cell cell){
		this.cell = cell;
		double[][] coordinates = getVertexCoordinates(cell);
		int[][] faceIndices = getFaceIndices(cell);
		int[][] edges = getEdges(cell);
		
		sceneGraphComponent = SceneGraphUtility.createFullSceneGraphComponent();
		sceneGraphComponent.setGeometry(getIndexedFaceSet(coordinates, faceIndices, edges));
		setCommonAppearance(sceneGraphComponent.getAppearance());
		setAppearanceColor(sceneGraphComponent.getAppearance(), cell.getColor());
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
		return cell.getPrototype().getFaceIndices().toArray(new int[0][0]);
	}
	
	private static int[][] getEdges(Cell cell){
		ArrayList<int[]> edgesList = new ArrayList<>();
		for (int i = 0; i < cell.getNumberOfTopologies();++i){
			edgesList.addAll(getTopologyEdges(cell, i));
		}
		for (int i = 0; i < cell.getNumberOfTopologies() - 1;++i){
			edgesList.addAll(getSideEdges(cell, i));
		}
		return edgesList.toArray(new int[0][0]);
	}
	
	private static List<int[]> getTopologyEdges(Cell cell, int topology){
		int offset = cell.getNumberOfVertexes(topology);
		int topologySize = cell.getPrototype().getTopologies().get(topology).getSize();
		List<int[]> topologyEdges = new ArrayList<>();
		int i;
		for (i = offset; i < offset+topologySize-1; ++i){
			int[] edge = new int[2];
			edge[0] = i;
			edge[1] = i+1;
			topologyEdges.add(edge);
		}
		int[] edge = new int[2];
		edge[0] = i;
		edge[1] = offset;
		topologyEdges.add(edge);
		
		return topologyEdges;
	}
	
	private static List<int[]> getSideEdges(Cell cell, int layer){
		int offsetBottom = cell.getNumberOfVertexes(layer);
		int offsetTop = cell.getNumberOfVertexes(layer+1);
		int[][] layerMapping = cell.getPrototype().getMappings().get(layer);
		List<int[]> sideEdges = new ArrayList<>();
		
		int f = 0;
		for (; f < layerMapping.length; ++f){
			int[] map = layerMapping[f];
			int[] edge = new int[2];
			edge[0] = offsetBottom+map[0];
			edge[1] = offsetTop+map[1];
			sideEdges.add(edge);
		}
		
		return sideEdges;
	}
	
	private static void setCommonAppearance(Appearance appearance){
		appearance.setAttribute(LINE_SHADER+"."+DIFFUSE_COLOR, Color.BLACK);
		appearance.setAttribute(LINE_SHADER+"."+TUBE_RADIUS, .01);
		appearance.setAttribute(VERTEX_DRAW, false);
	}
	
	private static void setAppearanceColor(Appearance appearance, Color color){
		appearance.setAttribute(POLYGON_SHADER+"."+DIFFUSE_COLOR, color);
	}
	
	private static IndexedFaceSet getIndexedFaceSet(double[][] coordinates, int[][] faceIndices, int[][] edges){
		IndexedFaceSetFactory ifsf = new IndexedFaceSetFactory();
		ifsf.setVertexCount(coordinates.length);
		ifsf.setFaceCount(faceIndices.length);
		ifsf.setEdgeCount(edges.length);
		ifsf.setVertexCoordinates(coordinates);
		ifsf.setFaceIndices(faceIndices);
		ifsf.setEdgeIndices(edges);
		ifsf.setGenerateFaceNormals(true);
		ifsf.update();
		
		return ifsf.getIndexedFaceSet();
	}
}
