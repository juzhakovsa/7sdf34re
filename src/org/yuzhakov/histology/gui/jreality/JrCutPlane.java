package org.yuzhakov.histology.gui.jreality;

import static de.jreality.shader.CommonAttributes.*;

import java.awt.Color;
import java.util.List;

import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.cut.CutPlane;
import org.yuzhakov.histology.model.cut.ModelCut;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.scene.Appearance;
import de.jreality.scene.IndexedFaceSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;

public class JrCutPlane {
	private CutPlane cutPlane;
	private SceneGraphComponent sceneGraphComponent;

	public JrCutPlane(CutPlane cutPlane) {
		this.cutPlane = cutPlane;
		sceneGraphComponent = SceneGraphUtility.createFullSceneGraphComponent();
		update();
		setAppearance(sceneGraphComponent.getAppearance());
	}

	public CutPlane getCutPlane() {
		return cutPlane;
	}

	public SceneGraphComponent getSceneGraphComponent() {
		return sceneGraphComponent;
	}
	
	public void update(){
		List<Vertex> points = cutPlane.getPlanePoints(10, 10, 10);
		double[][] coordinates = new double[points.size()][];
		for (int i = 0; i < coordinates.length; ++i){
			coordinates[i] = points.get(i).getCoordinates();
		}
		sceneGraphComponent.setGeometry(getIndexedFaceSet(coordinates));
	}
	
	private static void setAppearance(Appearance appearance){
		appearance.setAttribute(POLYGON_SHADER+"."+DIFFUSE_COLOR, Color.GRAY);
		appearance.setAttribute(POLYGON_SHADER+"."+TRANSPARENCY, 0.7);
		appearance.setAttribute(TRANSPARENCY_ENABLED, true);
		appearance.setAttribute(VERTEX_DRAW, false);
		appearance.setAttribute(EDGE_DRAW, false);
	}
	
	private static IndexedFaceSet getIndexedFaceSet(double[][] coordinates){
		int[][] faces = new int[1][coordinates.length];
		for (int i = 0; i < coordinates.length; ++i){
			faces[0][i] = i;
		}
		IndexedFaceSetFactory ifsf = new IndexedFaceSetFactory();
		ifsf.setVertexCount(coordinates.length);
		ifsf.setVertexCoordinates(coordinates);
		ifsf.setFaceCount(faces.length);
		ifsf.setFaceIndices(faces);
		ifsf.setGenerateFaceNormals(true);
		ifsf.update();
		
		return ifsf.getIndexedFaceSet();
	}

}
