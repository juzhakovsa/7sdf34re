package org.yuzhakov.histology.model.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.yuzhakov.histology.model.Vertex;

public class Vertexes {
	public static List<Vertex> unique(Collection<Vertex> vertexs){
		ArrayList<Vertex> init = new ArrayList<>(vertexs);
		ArrayList<Vertex> result = new ArrayList<>();
		Vertex curr = init.get(0);
		Vertex closest = null;
		double minDist = 0;
		result.add(curr);
		init.remove(0);
		while (init.size() > 0){
			for (Vertex candidate : init){
				//first element
				if (closest == null){
					closest = candidate;
					minDist = Vertex.getDistance(curr, candidate);
					continue;
				}
				
				double dist = Vertex.getDistance(curr, candidate);
				if (dist < minDist){
					closest = candidate;
					minDist = dist;
				}
			}
			curr = closest;
			result.add(closest);
			init.remove(closest);
			closest = null;
			
		}
		return result;
	}
}
