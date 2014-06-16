package org.yuzhakov.histology.model.samples;

import org.yuzhakov.histology.model.CellPrototype;
import org.yuzhakov.histology.model.Topology;
import org.yuzhakov.histology.model.Vertex;

public class Gekko {
	public static final double L = 2.414;
	public static final double D = L - 1;
	public static final double H = 0.5 + D;
	
	public static CellPrototype cellTypeA(){		
		Topology topology0 = new Topology(new Vertex[] {
				new Vertex(H, -0.5, 0.0), 				//0
				new Vertex(H, 0.5, 0.0), 				//1
				new Vertex((0.5+D/2), (0.5+D/2), 0.0), 	//2
				new Vertex(0.5, H, 0.0), 				//3
				new Vertex(-0.5, H, 0.0), 				//4
				new Vertex(-(0.5+D/2), (0.5+D/2), 0.0), //5
				new Vertex(-H, 0.5, 0.0), 				//6
				new Vertex(-H, -0.5, 0.0), 				//7
				new Vertex(-(0.5+D/2), -(0.5+D/2), 0.0),//8
				new Vertex(-0.5, -H, 0.0), 				//9
				new Vertex(0.5, -H, 0.0), 				//10
				new Vertex((0.5+D/2), -(0.5+D/2), 0.0),	//11
				});
		
		int[][] mapping0 = getDefaultMapping(topology0.getSize());
		
		Topology topology1 = topology0;
		
		int[][] mapping1 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{2,3},
				{3,4},
				{4,5},
				{5,6},
				{5,7},
				{6,8},
				{7,9},
				{8,10},
				{8,11},
				{9,12},
				{10,13},
				{11,14},
				{11,15},
		};
		
		Topology topology2 = new Topology(new Vertex[] {
				new Vertex(H, -0.5, 0.0), 		//0
				new Vertex(H, 0.5, 0.0), 		//1
				
				new Vertex((0.5+D/2), (0.5+D/2), 0.0), 	//2
				new Vertex((0.5+D/3), (0.5+D/3), 0.0), 	//3
				new Vertex(0.25, H, 0.0), 				//4
				
				new Vertex(-0.25, H, 0.0), 					//5
				new Vertex(-(0.5+D/3), (0.5+D/3), 0.0), 	//6
				new Vertex(-(0.5+D/2), (0.5+D/2), 0.0), 	//7
				
				new Vertex(-H, 0.5, 0.0), 		//8
				new Vertex(-H, -0.5, 0.0), 		//9
				
				new Vertex(-(0.5+D/2), -(0.5+D/2), 0.0), 	//10
				new Vertex(-(0.5+D/3), -(0.5+D/3), 0.0), 	//11
				new Vertex(-0.25, -H, 0.0), 				//12
				
				new Vertex(0.25, -H, 0.0), 					//13
				new Vertex((0.5+D/3), -(0.5+D/3), 0.0), 	//14
				new Vertex((0.5+D/2), -(0.5+D/2), 0.0), 	//15
				});
		
		int[][] mapping2 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{3,3},
				{3,4},
				{4,5},
				{4,6},
				{5,7},
				{5,8},
				{6,9},
				{6,10},
				{7,11},
				{8,12},
				{9,13},
				{10,14},
				{11,15},
				{11,16},
				{12,17},
				{12,18},
				{13,19},
				{13,20},
				{14,21},
				{14,22},
				{15,23},
		};
		
		Topology topology3 = new Topology(new Vertex[] {
				new Vertex(H, -0.5, 0.0), 		//0
				new Vertex(H, 0.5, 0.0), 		//1
				
				new Vertex((0.5+D/2), (0.5+D/2), 0.0), 	//2
				new Vertex((0.5+D/3), (0.5+D/3), 0.0), 	//3
				new Vertex(0.5, (0.5+D/3), 0.0), 		//4
				new Vertex(0.25, (0.5+D*7/12), 0.0), 	//5
				new Vertex(0.25, H, 0.0), 				//6
				
				new Vertex(-0.25, H, 0.0), 				//7
				new Vertex(-0.25, (0.5+D*7/12), 0.0), 	//8
				new Vertex(-0.5, (0.5+D/3), 0.0), 		//9
				new Vertex(-(0.5+D/3), (0.5+D/3), 0.0), //10
				new Vertex(-(0.5+D/2), (0.5+D/2), 0.0), //11
				
				new Vertex(-H, 0.5, 0.0), 		//12
				new Vertex(-H, -0.5, 0.0), 		//13
				
				new Vertex(-(0.5+D/2), -(0.5+D/2), 0.0),//14
				new Vertex(-(0.5+D/3), -(0.5+D/3), 0.0),//15
				new Vertex(-0.5, -(0.5+D/3), 0.0), 		//16
				new Vertex(-0.25, -(0.5+D*7/12), 0.0), 	//17
				new Vertex(-0.25, -H, 0.0), 			//18
				
				new Vertex(0.25, -H, 0.0), 				//19
				new Vertex(0.25, -(0.5+D*7/12), 0.0), 	//20
				new Vertex(0.5, -(0.5+D/3), 0.0), 		//21
				new Vertex((0.5+D/3), -(0.5+D/3), 0.0), //22
				new Vertex((0.5+D/2), -(0.5+D/2), 0.0), //23
				});
		
		int[][] mapping3 = getDefaultMapping(topology3.getSize());
		
		Topology topology4 = new Topology(new Vertex[] {
				new Vertex((0.5+D*2/3), -(0.5+D/3), 0.0), 	//0
				new Vertex((0.5+D*2/3), (0.5+D/3), 0.0), 	//1
				
				new Vertex((0.5+D/2), (0.5+D/2), 0.0), 	//2
				new Vertex((0.5+D/3), (0.5+D/3), 0.0), 	//3
				new Vertex(0.5, (0.5+D/3), 0.0), 		//4
				new Vertex(0.25, (0.5+D*7/12), 0.0), 	//5
				new Vertex(0.25, H, 0.0), 				//6
				
				new Vertex(-0.25, H, 0.0), 				//7
				new Vertex(-0.25, (0.5+D*7/12), 0.0), 	//8
				new Vertex(-0.5, (0.5+D/3), 0.0), 		//9
				new Vertex(-(0.5+D/3), (0.5+D/3), 0.0), //10
				new Vertex(-(0.5+D/2), (0.5+D/2), 0.0), //11
				
				new Vertex(-(0.5+D*2/3), (0.5+D/3), 0.0), 	//12
				new Vertex(-(0.5+D*2/3), -(0.5+D/3), 0.0), 	//13
				
				new Vertex(-(0.5+D/2), -(0.5+D/2), 0.0),//14
				new Vertex(-(0.5+D/3), -(0.5+D/3), 0.0),//15
				new Vertex(-0.5, -(0.5+D/3), 0.0), 		//16
				new Vertex(-0.25, -(0.5+D*7/12), 0.0), 	//17
				new Vertex(-0.25, -H, 0.0), 			//18
				
				new Vertex(0.25, -H, 0.0), 				//19
				new Vertex(0.25, -(0.5+D*7/12), 0.0), 	//20
				new Vertex(0.5, -(0.5+D/3), 0.0), 		//21
				new Vertex((0.5+D/3), -(0.5+D/3), 0.0), //22
				new Vertex((0.5+D/2), -(0.5+D/2), 0.0), //23
				});
		
		int[][] mapping4 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{1,3},
				{2,4},
				{3,5},
				{4,6},
				{5,7},
				{6,7},
				{7,7},
				{8,7},
				{9,8},
				{10,9},
				{11,10},
				{12,11},
				{12,12},
				{13,13},
				{13,14},
				{14,15},
				{15,16},
				{16,17},
				{17,18},
				{18,18},
				{19,18},
				{20,18},
				{21,19},
				{22,20},
				{23,21},
		};
		
		Topology topology5 = new Topology(new Vertex[] {
				new Vertex((0.5+D*2/3), -(0.5+D/3), 0.0), 	//0
				new Vertex((0.5+D/2), -(0.5+D/6), 0.0), 	//1
				new Vertex((0.5+D/2), (0.5+D/6), 0.0), 		//2				
				new Vertex((0.5+D*2/3), (0.5+D/3), 0.0), 	//3
				
				new Vertex((0.5+D/2), (0.5+D/2), 0.0), 	//4
				new Vertex((0.5+D/3), (0.5+D/3), 0.0), 	//5
				new Vertex(0.5, (0.5+D/3), 0.0), 		//6
				new Vertex(0.0, (0.5+D*2/3), 0.0), 		//7

				new Vertex(-0.5, (0.5+D/3), 0.0), 		//8
				new Vertex(-(0.5+D/3), (0.5+D/3), 0.0), //9
				new Vertex(-(0.5+D/2), (0.5+D/2), 0.0), //10
				
				new Vertex(-(0.5+D*2/3), (0.5+D/3), 0.0), 	//11
				new Vertex(-(0.5+D/2), (0.5+D/6), 0.0), 	//12
				new Vertex(-(0.5+D/2), -(0.5+D/6), 0.0), 	//13
				new Vertex(-(0.5+D*2/3), -(0.5+D/3), 0.0), 	//14
				
				new Vertex(-(0.5+D/2), -(0.5+D/2), 0.0),//15
				new Vertex(-(0.5+D/3), -(0.5+D/3), 0.0),//16
				new Vertex(-0.5, -(0.5+D/3), 0.0), 		//17
				new Vertex(0.0, -(0.5+D*2/3), 0.0), 	//18

				new Vertex(0.5, -(0.5+D/3), 0.0), 		//19
				new Vertex((0.5+D/3), -(0.5+D/3), 0.0), //20
				new Vertex((0.5+D/2), -(0.5+D/2), 0.0), //21
				});

		CellPrototype cellA = new CellPrototype();
		cellA.getTopologies().add(topology0);
		cellA.getTopologies().add(topology1);
		cellA.getTopologies().add(topology2);
		cellA.getTopologies().add(topology3);
		cellA.getTopologies().add(topology4);
		cellA.getTopologies().add(topology5);
//		cellA.getTopologies().add(topology5);
		
//		cellA.getMappings().add(getDefaultMapping(topology5.getSize()));
		cellA.getMappings().add(mapping0);
		cellA.getMappings().add(mapping1);
		cellA.getMappings().add(mapping2);
		cellA.getMappings().add(mapping3);
		cellA.getMappings().add(mapping4);
		
		return cellA;
	}
	
	public static CellPrototype cellTypeB(){		
		Topology topology0 = new Topology(new Vertex[] {
				new Vertex(D, 0.0, 0.0), //0
				new Vertex(0.0, D, 0.0), //1
				new Vertex(-D, 0.0, 0.0),//2
				new Vertex(0.0, -D, 0.0) //3
				});
		
		int[][] mapping0 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{2,3},
				{2,4},
				{3,5}
		};
		
		Topology topology1 = new Topology(new Vertex[] {
				new Vertex(D/2, -D/2, 0.0), //0
				new Vertex(D/2, D/2, 0.0), //1
				new Vertex(0.0, D, 0.0), //2
				new Vertex(-D/2, D/2, 0.0), //3
				new Vertex(-D/2, -D/2, 0.0), //4
				new Vertex(0.0, -D, 0.0) //5
				});
		
		int[][] mapping1 = getDefaultMapping(topology1.getSize());
		
		Topology topology2 = topology1;
		
		int[][] mapping2 = getDefaultMapping(topology2.getSize());
		
		Topology topology3 = topology2;
		
		int[][] mapping3 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{2,3},
				{3,4},
				{4,5},
				{5,6},
				{5,7}
		};
		
		Topology topology4 = new Topology(new Vertex[] {
				new Vertex(D/2, -D/2, 0.0),	//0
				new Vertex(D/2, D/2, 0.0),	//1
				new Vertex(D/3, D*2/3, 0.0),	//2
				new Vertex(-D/3, D*2/3, 0.0), //3
				new Vertex(-D/2, D/2, 0.0),	//4
				new Vertex(-D/2, -D/2, 0.0),	//5
				new Vertex(-D/3, -D*2/3, 0.0),//6
				new Vertex(D/3, -D*2/3, 0.0), //7
				});
		
		int[][] mapping4 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{1,3},
				{2,4},
				{2,5},
				{3,6},
				{3,7},
				{4,8},
				{4,9},
				{5,10},
				{5,11},
				{6,12},
				{6,13},
				{7,14},
				{7,15},
		};
		
		Topology topology5 = new Topology(new Vertex[] {
				new Vertex(D/2, -D/2, 0.0),	//0
				new Vertex(D/3, -D/3, 0.0), //1
				new Vertex(D/3, D/3, 0.0),	//2
				new Vertex(D/2, D/2, 0.0),	//3
				
				new Vertex(D/3, D*2/3, 0.0),//4
				new Vertex(D/6, D/2, 0.0),	//5
				new Vertex(-D/6, D/2, 0.0),	//6
				new Vertex(-D/3, D*2/3, 0.0),//7
				
				new Vertex(-D/2, D/2, 0.0),	//8
				new Vertex(-D/3, D/3, 0.0),	//9
				new Vertex(-D/3, -D/3, 0.0),//10
				new Vertex(-D/2, -D/2, 0.0),//11
				
				new Vertex(-D/3, -D*2/3, 0.0),//12
				new Vertex(-D/6, -D/2, 0.0),//13
				new Vertex(D/6, -D/2, 0.0),	//14
				new Vertex(D/3, -D*2/3, 0.0),//15
				});
		
		int[][] mapping5 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{2,3},
				{3,4},
				{4,5},
				{5,6},
				{5,7}
		};

		CellPrototype cellB = new CellPrototype();
		cellB.getTopologies().add(topology0);
		cellB.getTopologies().add(topology1);
		cellB.getTopologies().add(topology2);
		cellB.getTopologies().add(topology3);
		cellB.getTopologies().add(topology4);
		cellB.getTopologies().add(topology5);
		
		cellB.getMappings().add(mapping0);
		cellB.getMappings().add(mapping1);
		cellB.getMappings().add(mapping2);
		cellB.getMappings().add(mapping3);
		cellB.getMappings().add(mapping4);
		
		return cellB;
	}
	
	public static CellPrototype cellTypeC(){		
		Topology topology0 = new Topology(new Vertex[] {
				new Vertex(0.0, 0.0, 0.0), 				//0
				});
		
		int[][] mapping0 = new int[][]{
				{0,0},
				{0,1},
				{0,2},
		};
		
		Topology topology1 = new Topology(new Vertex[] {
				new Vertex(D/2, -D/2, 0.0), 			//0
				new Vertex(D/2, D/2, 0.0), 				//1
				new Vertex(0.0, 0.0, 0.0), 				//2
				});
		
		int[][] mapping1 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{1,3},
				{2,4},
		};
		
		Topology topology2 = new Topology(new Vertex[] {
				new Vertex(D/3, -D*2/3, 0.0), 			//0
				new Vertex(D/2, -D/2, 0.0), 			//1
				new Vertex(D/2, D/2, 0.0), 				//2
				new Vertex(D/3, D*2/3, 0.0), 			//3
				new Vertex(-0.25, 0.0, 0.0), 			//4
				});
		
		int[][] mapping2 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{2,3},
				{3,4},
				{3,5},
				{4,6},
				{4,7},
		};
		
		Topology topology3 = new Topology(new Vertex[] {
				new Vertex(0.0, -D*2/3, 0.0), 			//0
				new Vertex(D/3, -D*2/3, 0.0), 			//1
				new Vertex(D/2, -D/2, 0.0), 			//2
				new Vertex(D/2, D/2, 0.0), 				//3
				new Vertex(D/3, D*2/3, 0.0), 			//4
				new Vertex(0.0, D*2/3, 0.0), 			//5
				new Vertex(-0.25, D*5/12, 0.0), 		//6
				new Vertex(-0.25, -D*5/12, 0.0), 		//7
				});
		
		int[][] mapping3 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{3,3},
				{4,4},
				{5,5},
				{6,6},
				{7,10},
		};
		
		Topology topology4 = new Topology(new Vertex[] {
				new Vertex(0.0, -D*2/3, 0.0), 			//0
				new Vertex(D/3, -D*2/3, 0.0), 			//1
				new Vertex(D/2, -D/2, 0.0), 			//2
				new Vertex(D/2, D/2, 0.0), 				//3
				new Vertex(D/3, D*2/3, 0.0), 			//4
				new Vertex(0.0, D*2/3, 0.0), 			//5
				new Vertex(-0.25, D*5/12, 0.0), 		//6
				new Vertex(-0.25, 0.0001, 0.0), 		//7
				new Vertex(-0.5, 0.0, 0.0), 			//8
				new Vertex(-0.25, -0.0001, 0.0), 		//9
				new Vertex(-0.25, -D*5/12, 0.0), 		//10
				});
		
		int[][] mapping4 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{3,3},
				{4,4},
				{5,5},
				{6,6},
				{7,6},
				{7,7},
				{8,6},
				{8,7},
				{8,8},
				{9,8},
				{10,8},
		};
		
		Topology topology5 = new Topology(new Vertex[] {
				new Vertex(0.0, -D*2/3, 0.0), 			//0
				new Vertex(D/3, -D*2/3, 0.0), 			//1
				new Vertex(D*2/3, -D/3, 0.0), 			//2
				new Vertex(D*2/3, D/3, 0.0), 			//3
				new Vertex(D/3, D*2/3, 0.0), 			//4
				new Vertex(0.0, D*2/3, 0.0), 			//5
				new Vertex(-0.5, D/3, 0.0), 			//6
				new Vertex(-0.5, 0.0, 0.0), 			//7
				new Vertex(-0.5, -D/3, 0.0), 			//8
				});
		
		CellPrototype cellC = new CellPrototype();
		cellC.getTopologies().add(topology0);
		cellC.getTopologies().add(topology1);
		cellC.getTopologies().add(topology2);
		cellC.getTopologies().add(topology3);
		cellC.getTopologies().add(topology4);
		cellC.getTopologies().add(topology5);
//		cellA.getTopologies().add(topology5);
		
//		cellA.getMappings().add(getDefaultMapping(topology5.getSize()));
		cellC.getMappings().add(mapping0);
		cellC.getMappings().add(mapping1);
		cellC.getMappings().add(mapping2);
		cellC.getMappings().add(mapping3);
		cellC.getMappings().add(mapping4);
		
		return cellC;
	}
	
	public static CellPrototype cellTypeD(){		
		Topology topology0 = new Topology(new Vertex[] {
				new Vertex(0.0, 0.5, 0.0), //0
				new Vertex(0.0, -0.5, 0.0), //1
				});
		
		int[][] mapping0 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{1,3},
		};
		
		Topology topology1 = new Topology(new Vertex[] {
				new Vertex(D/3, (0.5 + D/3), 0.0), 	//0
				new Vertex(-D/3, (0.5 + D/3), 0.0),	//1
				new Vertex(-D/3, -(0.5 + D/3), 0.0),//2
				new Vertex(D/3, -(0.5 + D/3), 0.0), //3
				});
		
		int[][] mapping1 = new int[][]{
				{0,0},
				{0,1},
				{1,2},
				{1,3},
				{2,4},
				{2,5},
				{3,6},
				{3,7},
		};
		
		Topology topology2 = new Topology(new Vertex[] {
				new Vertex(D/2, (0.5 + D/6), 0.0), 	//0
				new Vertex(D/6, (0.5 + D/2), 0.0),	//1
				new Vertex(-D/6,(0.5 + D/2), 0.0),	//2
				new Vertex(-D/2,(0.5 + D/6), 0.0), 	//3
				
				new Vertex(-D/2, -(0.5 + D/6), 0.0), 		//4
				new Vertex(-D/6, -(0.5 + D/2), 0.0),		//5
				new Vertex(D/6,  -(0.5 + D/2), 0.0),		//6
				new Vertex(D/2,  -(0.5 + D/6), 0.0), 		//7
				});
		
		int[][] mapping2 = new int[][]{
				{0,0},
				{1,1},
				{2,2},
				{2,3},
				{3,4},
				{4,5},
				{5,6},
				{5,7}
		};
		
		CellPrototype cellD = new CellPrototype();
		cellD.getTopologies().add(topology0);
		cellD.getTopologies().add(topology1);
		cellD.getTopologies().add(topology2);
//		cellD.getTopologies().add(topology3);
//		cellD.getTopologies().add(topology4);
		
//		cellD.getMappings().add(getDefaultMapping(topology1.getSize()));
		cellD.getMappings().add(mapping0);
		cellD.getMappings().add(mapping1);
//		cellD.getMappings().add(mapping2);
//		cellD.getMappings().add(mapping3);
		
		return cellD;
	}
	
	private static int[][] getDefaultMapping(int size){
		int[][] mapping = new int[size][2];
		for (int i = 0; i < size; ++i){
			mapping[i][0] = i;
			mapping[i][1] = i;
		}
		return mapping;
	}
}
