package org.yuzhakov.histology.model.utils;

import java.util.ArrayList;
import java.util.LinkedList;

import org.yuzhakov.histology.model.Topology;

public class TopologyRotator {
	/**
	 * ������ ������� ����� ���, ����� � ������ ������������� ���������� ������������������.
	 */
	public static void rollEdges(Topology topology){
		LinkedList<Sequence> sequences = createSequences(topology);
	}
		
	private static LinkedList<Sequence> createSequences(Topology topology){
		double[] edges = topology.getEdges();
		int size = edges.length;
		//���� ������ ������ �������� �����
		double maxValue = edges[0];
		for (int i = 1; i < size; ++i){
			if (edges[i] > maxValue)
				maxValue = edges[i];
		}
		
		//�������� ������������ ������������������
		LinkedList<Sequence> sequences = new LinkedList<>();
		int seqStart = 0;
		int seqEnd;
		Sequence seq = new Sequence();
		sequences.add(seq);
		seq.put(0, edges[0]);
		for (int i = 1; i < size; ++i){
			double diff = edges[i] - edges[i-1];
			// ���� ���������� ��� ������ ���������, � ������ �������� - ����� ������������������
			if (edges[i] == maxValue && diff > 0){
				seq = new Sequence();
				sequences.add(seq);
			}
			seq.put(i, edges[i]);
		}
		//��������� ������ � ��������� ������������������, ���� ����.
		//���� ������, ����� ������ ����� ����� ��������� � ������ ���� ����������� � ������ - ��������.
		double diff = edges[0] - edges[size-1];
		if (edges[0] != maxValue || diff <= 0){
			sequences.getLast().merge(sequences.getFirst());
			sequences.remove();//First
		}
		
		return sequences;
	}
	
	
	
	
	
	private static class Sequence{
		ArrayList<Integer> order = new ArrayList<>();
		ArrayList<Double> value = new ArrayList<>();
		
		public void put (int o, double v){
			order.add(o);
			value.add(v);
		}
		
		public void merge(Sequence other){
			order.addAll(other.order);
			value.addAll(other.value);
		}
		
		public int size(){
			return value.size();
		}
	}
}
