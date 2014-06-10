package org.yuzhakov.histology.model;

import java.util.ArrayList;
import java.util.List;

public class GisteonPrototype {
	private List<CellPrototype> cells = new ArrayList<>();
	private List<Vertex> offsets = new ArrayList<>();
	private List<Double> heights = new ArrayList<>();
	
	public List<CellPrototype> getCells() {
		return cells;
	}

	public List<Vertex> getOffsets() {
		return offsets;
	}

	public List<Double> getHeights() {
		return heights;
	}	
		
}
