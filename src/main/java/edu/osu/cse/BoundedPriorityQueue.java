package edu.osu.cse;

import java.util.PriorityQueue;

public class BoundedPriorityQueue<E> extends PriorityQueue<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;
	public BoundedPriorityQueue(int maxCapacity) {
		this.limit = maxCapacity;
	}
	
	@Override
	public boolean add(E e) {
		if(super.size() < limit) {
			return super.add(e);
		} else {
			E smallest = super.peek();
			if(((Comparable<E>)smallest).compareTo(e) < 0) {
				super.remove();
				return super.add(e);
			}
		}
		
		return false;
	}
}
