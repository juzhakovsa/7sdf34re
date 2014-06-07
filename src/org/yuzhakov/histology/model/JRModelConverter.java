package org.yuzhakov.histology.model;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.scene.IndexedFaceSet;

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
}
