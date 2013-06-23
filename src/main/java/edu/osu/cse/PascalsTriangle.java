package edu.osu.cse;

// checkout the amazing properties of pascal's triangle
// http://www.mathsisfun.com/pascals-triangle.html
public class PascalsTriangle {

	public static int[][] buildPascalsTriangle(int n) {
		int[][] triangle = new int[n][n+1];
		triangle[0][1] = 1;
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<n+1; j++) {
				triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
			}
		}
		return triangle;
	}
}
