package org.yuzhakov.histology.model;

import java.awt.BorderLayout;

import org.yuzhakov.histology.model.samples.Samples;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.scene.IndexedFaceSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;

public class JRModelConverter {
	
	public static IndexedFaceSet getGeometry(Node node){
		IndexedFaceSetFactory ifsf = new IndexedFaceSetFactory();
		ifsf.setVertexCount(node.getVertexCount());
		ifsf.setFaceCount(node.getFacesCount());
		ifsf.setVertexCoordinates(node.getVerticesCoordinates());
		ifsf.setFaceIndices(node.getFaces());
		ifsf.setEdgeCount(node.getEdgesCount());
		ifsf.setEdgeIndices(node.getEdges());
		ifsf.setGenerateFaceNormals(true);
		ifsf.update();
		
		return ifsf.getIndexedFaceSet();
	}
	
	public static SceneGraphComponent getSGC(Cell cell){
		SceneGraphComponent cellSgc = SceneGraphUtility.createFullSceneGraphComponent();
		for (Node node:cell.getNodes()){
			IndexedFaceSet indexedFaceSet = getGeometry(node);
			SceneGraphComponent nodeSgc = SceneGraphUtility.createFullSceneGraphComponent();
			nodeSgc.setGeometry(indexedFaceSet);
			cellSgc.addChild(nodeSgc);
		}
		return cellSgc;
	}
}
