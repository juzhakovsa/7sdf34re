package org.yuzhakov.histology.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.yuzhakov.histology.model.Vertex;
import org.yuzhakov.histology.model.m3D.Cell;
import org.yuzhakov.histology.model.samples.Gekko;

public class SliceTest {

	@Test
	public void test() {
		Cell cell = new Cell(Gekko.cellTypeA());
	}

}
