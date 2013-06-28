package edu.osu.cse;

import java.util.Iterator;

public class IterateSquares implements Iterator<Long>{

	private int a = 2;
	private int b = 2;
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long next() {
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	public void reset() {
		this.a = 2;
		this.b = 2;
	}
	
}
