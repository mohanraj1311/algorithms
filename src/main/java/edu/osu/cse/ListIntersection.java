package edu.osu.cse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListIntersection {

	public static Set<Integer> intersect(List<Integer> listA, List<Integer> listB) {
		/* Boundary conditions. If listA or listB is null or if size of either list
		 * is 0 then return null. */
		if(listA == null || listA.size() == 0 || listB == null || listB.size() == 0) {
			return null;
		}
		
		// Build a hashset of all listA elements to remove duplicates
		Set<Integer> setA = new HashSet<Integer>(listA);
		Set<Integer> result = new HashSet<Integer>();

		// Check if each value in listB is contained in listA, if so then
		// add it to result set
		for (int val : listB) {
			if (setA.contains(val)) {
				result.add(val);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();

		listA.add(4);
		listA.add(2);
		listA.add(73);
		listA.add(11);
		listA.add(-5);
		
		listB.add(-5);
		listB.add(73);
		listB.add(-1);
		listB.add(9);
		listB.add(9);
		listB.add(4);
		listB.add(7);

		System.out.println(ListIntersection.intersect(listA, listB));
		System.out.println(ListIntersection.intersect(listA, null));
		System.out.println(ListIntersection.intersect(null, null));
		System.out.println(ListIntersection.intersect(null, listB));
		System.out.println(ListIntersection.intersect(listA, new ArrayList<Integer>()));
	}

}