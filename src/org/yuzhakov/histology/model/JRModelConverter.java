package org.yuzhakov.histology.model;

import java.awt.Color;

import org.yuzhakov.histology.model.samples.Samples;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.geometry.Primitives;
import de.jreality.scene.IndexedFaceSet;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.util.SceneGraphUtility;
import static de.jreality.shader.CommonAttributes.*;

public class JRModelConverter {
	
	public static SceneGraphComponent getSGC(Cell cell){
		final SceneGraphComponent cellSgc = SceneGraphUtility.createFullSceneGraphComponent();
//		for (Node node:cell.getNodes()){
//			IndexedFaceSet indexedFaceSet = getGeometry(node);
//			SceneGraphComponent nodeSgc = SceneGraphUtility.createFullSceneGraphComponent();
//			nodeSgc.setGeometry(indexedFaceSet);
//			cellSgc.addChild(nodeSgc);
//		}
		cellSgc.getAppearance().setAttribute(POLYGON_SHADER+"."+DIFFUSE_COLOR, Color.GREEN);
		cellSgc.getAppearance().setAttribute(LINE_SHADER+"."+DIFFUSE_COLOR, Color.BLACK);
		cellSgc.getAppearance().setAttribute(LINE_SHADER+"."+TUBE_RADIUS, .01);
		cellSgc.getAppearance().setAttribute(VERTEX_DRAW, false);
		return cellSgc;
	}
}
