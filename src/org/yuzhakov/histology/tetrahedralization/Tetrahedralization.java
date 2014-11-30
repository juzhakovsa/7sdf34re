package org.yuzhakov.histology.tetrahedralization;

import java.util.List;

import org.yuzhakov.histology.Tetgen;
import org.yuzhakov.histology.model.cut.Tetrahedron;
import org.yuzhakov.histology.model.m3D.Cell;

public class Tetrahedralization {
	public static List<Tetrahedron> createTetrahedralization(Cell cell){
		Tetgen tetgen = new Tetgen(cell);
		tetgen.tetrahedralize(null);
		return tetgen.getTetrahedronList();
	}
}
