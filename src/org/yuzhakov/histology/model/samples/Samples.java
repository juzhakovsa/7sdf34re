package org.yuzhakov.histology.model.samples;

import org.yuzhakov.histology.model.Node;
import org.yuzhakov.histology.model.NodePrototype;
import org.yuzhakov.histology.model.Topology;
import org.yuzhakov.histology.model.Vertex;

import de.jreality.geometry.IndexedFaceSetFactory;
import de.jreality.scene.IndexedFaceSet;

public class Samples {
	public static final NodePrototype hexagonPrism = hexagonPrism();
	public static final NodePrototype hexagonTriangle = hexagonTriangle();
	
	
	public static NodePrototype hexagonPrism(){
		Vertex b1 = new Vertex(0.8660254037844387, 0.5, 0.0);
		Vertex b2 = new Vertex(6.123233995736766E-17, 1.0, 0.0);
		Vertex b3 = new Vertex(-0.8660254037844385, 0.5, 0.0);
		Vertex b4 = new Vertex(-0.8660254037844388, -0.5, 0.0);
		Vertex b5 = new Vertex(-1.8369701987210297E-16, -1.0, 0.0);
		Vertex b6 = new Vertex(0.8660254037844388, -0.5, 0.0);
		
		Vertex u1 = new Vertex(0.8660254037844387, 0.5, 0.0);
		Vertex u2 = new Vertex(6.123233995736766E-17, 1.0, 0.0);
		Vertex u3 = new Vertex(-0.8660254037844385, 0.5, 0.0);
		Vertex u4 = new Vertex(-0.8660254037844388, -0.5, 0.0);
		Vertex u5 = new Vertex(-1.8369701987210297E-16, -1.0, 0.0);
		Vertex u6 = new Vertex(0.8660254037844388, -0.5, 0.0);
		
		Topology bottom = Topology.getTopology(new Vertex[]{b1,b2,b3,b4,b5,b6});
		Topology upper = Topology.getTopology(new Vertex[]{u1,u2,u3,u4,u5,u6});
		
		int[][] mapping = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{3,3},
				{4,4},
				{5,5},
		};
		
		NodePrototype proto = new NodePrototype();
		proto.setBottomTopology(bottom);
		proto.setUpperTopology(upper);
		proto.setMapping(mapping);
		
		return proto;
	}
	
	public static NodePrototype hexagonTriangle(){
		Vertex b1 = new Vertex(0.8660254037844387, 0.5, 0.0);
		Vertex b2 = new Vertex(6.123233995736766E-17, 1.0, 0.0);
		Vertex b3 = new Vertex(-0.8660254037844385, 0.5, 0.0);
		Vertex b4 = new Vertex(-0.8660254037844388, -0.5, 0.0);
		Vertex b5 = new Vertex(-1.8369701987210297E-16, -1.0, 0.0);
		Vertex b6 = new Vertex(0.8660254037844388, -0.5, 0.0);
		
		Vertex u1 = new Vertex(0.8660254037844387, 0.5, 0.0);
		Vertex u2 = new Vertex(-0.8660254037844385, 0.5, 0.0);
		Vertex u3 = new Vertex(-1.8369701987210297E-16, -1.0, 0.0);
		
		Topology bottom = Topology.getTopology(new Vertex[]{b1,b2,b3,b4,b5,b6});
		Topology upper = Topology.getTopology(new Vertex[]{u1,u2,u3});
		
		int[][] mapping = new int[][]{
				{0,0},
				{1,0},
				{2,1},
				{3,1},
				{4,2},
				{5,2},
		};

		NodePrototype proto = new NodePrototype();
		proto.setBottomTopology(bottom);
		proto.setUpperTopology(upper);
		proto.setMapping(mapping);
		
		return proto;
	}
	
	public static NodePrototype Star4(){		
		Topology bottom = Topology.getTopology(new Vertex[]{
				new Vertex(1, 0, 0),
				new Vertex(0.25, 0.25, 0),
				new Vertex(0, 1, 0),
				new Vertex(-0.25, 0.25, 0),
				new Vertex(-1, 0, 0),
				new Vertex(-0.25, -0.25, 0),
				new Vertex(0, -1, 0),
				new Vertex(0.25, -0.25, 0)
		});
		Topology upper = Topology.getTopology(new Vertex[]{
				new Vertex(1, 0, 0),
				new Vertex(0.25, 0.25, 0),
				new Vertex(0, 1, 0),
				new Vertex(-0.25, 0.25, 0),
				new Vertex(-1, 0, 0),
				new Vertex(-0.25, -0.25, 0),
				new Vertex(0, -1, 0),
				new Vertex(0.25, -0.25, 0)
		});
		
		int[][] mapping = new int[][]{
//				{0,0},
//				{1,1},
				{2,2},
				{3,3},
				{4,4},
				{5,5},
				{6,6},
				{7,7}
		};

		NodePrototype proto = new NodePrototype();
		proto.setBottomTopology(bottom);
		proto.setUpperTopology(upper);
		proto.setMapping(mapping);
		
		return proto;
	}
	
	public static IndexedFaceSet Star4Flat(){		
		Topology bottom = Topology.getTopology(new Vertex[]{
				new Vertex(1, 0, 0),
				new Vertex(0.25, 0.25, 0),
				new Vertex(0, 1, 0),
				new Vertex(-0.25, 0.25, 0),
				new Vertex(-1, 0, 0),
				new Vertex(-0.25, -0.25, 0),
				new Vertex(0, -1, 0),
				new Vertex(0.25, -0.25, 0)
		});
		IndexedFaceSetFactory ifsf = new IndexedFaceSetFactory();
	    
	    double [][] vertices  = new double[][] {
	    		{1, 0, 0},
				{0.5, 0.5, 0},
				{0, 1, 0},
				{-0.25, 0.25, 0},
				{-1, 0, 0},
				{-0.25, -0.25, 0},
				{0, -1, 0},
				{0.25, -0.25, 0}
	    };
	    
//	    int [][] faceIndices = new int [][] {
//	      {0, 1, 2, 3, 4, 5, 6, 7}
//	    };
	    int [][] faceIndices = new int [][] {
	  	      {0, 1, 2, 4, 6}
	  	    };
	    
	    ifsf.setVertexCount( vertices.length );
	    ifsf.setVertexCoordinates( vertices );
	    ifsf.setFaceCount( faceIndices.length);
	    ifsf.setFaceIndices( faceIndices );

	    ifsf.setGenerateEdgesFromFaces( false );
//	    ifsf.setGenerateFaceNormals( true );
	 
	    ifsf.update();
		
		return ifsf.getIndexedFaceSet();
	}
}
