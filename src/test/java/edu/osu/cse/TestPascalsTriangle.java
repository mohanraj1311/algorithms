package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPascalsTriangle {

	@Test
	public void testPT(){
		int[][] expected = new int[][] {{0,1,0,0,0}, {0,1,1,0,0}, {0,1,2,1,0}, {0,1,3,3,1}};
		int[][] got = PascalsTriangle.buildPascalsTriangle(4);
		assertEquals(true, compareArrays(expected, got, 4));
	}

	private boolean compareArrays(int[][] expected, int[][] got, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n+1; j++) {
				if(expected[i][j] != got[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
