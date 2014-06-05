package org.yuzhakov.histology.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.yuzhakov.histology.model.Topology;
import org.yuzhakov.histology.model.utils.TopologyRotator;

public class TopologyTest {

	@Test
	public void test() {
		test1();
	}
	
	public void test1(){
		Topology topology = TopologyRotator.getTestTopology();
		
	}

}
