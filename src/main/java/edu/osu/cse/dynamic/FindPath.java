package edu.osu.cse.dynamic;

import java.util.ArrayList;
import java.util.HashMap;

// imagine a robot sitting on the upper left corner of an X by Y grid. The robot
// can only move in two directions: right and down. How many possible paths are 
// there for the robot to go from (0,0) to (X,Y)?
public class FindPath {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// To reach point (X,Y) there are X ways of choosing to move right and
	// remaining Y ways to move down. So for choosing X out of (X+Y) the
	// complexity is (X+Y)!/X!Y!
	public static boolean findPathRecursive(int x, int y, ArrayList<Point> path) {
		Point p = new Point(x, y);
		path.add(p);

		// we reached the origin point
		if (x == 0 && y == 0) {
			return true;
		}

		boolean success = false;
		// if left is free then move left (imagine we are going from end to start)
		if (x > 0 && isFree(x - 1, y)) {
			success = findPathRecursive(x - 1, y, path);
		}

		// if top is free then move top (imagine we are going from end to start)
		if (!success && y > 0 && isFree(x, y - 1)) {
			success = findPathRecursive(x, y - 1, path);
		}

		// if both left and top are not free/invalid then remove the current point
		// and move in different direction
		if (!success) {
			path.remove(p);
		}

		return success;
	}

	// this method should be X*Y grid with points that are offlimit or invalid
	// point
	private static boolean isFree(int i, int y) {
		return true;
	}

	public static boolean findPathDynamic(int x, int y, ArrayList<Point> path,
	    HashMap<Point, Boolean> cache) {
		Point p = new Point(x, y);

		// if the point is already cached then return it
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		path.add(p);

		if (x == 0 && y == 0) {
			return true;
		}

		boolean success = false;
		if (x > 0 && isFree(x - 1, y)) {
			success = findPathDynamic(x - 1, y, path, cache);
		}

		if (!success && y > 0 && isFree(x, y - 1)) {
			success = findPathDynamic(x, y - 1, path, cache);
		}

		if (!success) {
			path.remove(p);
		}

		// cache the point
		cache.put(p, success);
		return success;
	}
}
