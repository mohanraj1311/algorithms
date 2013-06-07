package edu.osu.cse;

public class RotatedBinarySearch {

	public static int search(int[] vals, int key) {
		return searchImpl(vals, 0, vals.length - 1, key);
	}

	private static int searchImpl(int[] vals, int low, int high, int key) {
		
		// if input array is empty
		if(low > high) return -1;
		
		// if input array contains only one element
		if(low == high) {
			if(vals[low] == key) {
				return 0;
			} else {
				return -1;
			}
		}
			
		int mid = low + (high - low)/2;
		if(key == vals[mid]) {
			return 0;
		} 
		
		// if the array is ordered then use simple binary search
		if(vals[low] < vals[high]) {
			if(key < vals[mid]) {
				return searchImpl(vals, low, mid - 1, key);
			} else {
				return searchImpl(vals, mid + 1, high, key);
			}
		} else {
			// rotated input case
			
			// right half is sorted
			if(vals[mid] < vals[high]) {
				if(key > vals[mid] && key <= vals[high]) {
					// key exists in right half
					return searchImpl(vals, mid + 1, high, key);
				} else {
					// key exists in left rotated half
					return searchImpl(vals, low, mid - 1, key);
				}
			} 
			
			// left half is sorted
			if(vals[low] < vals[mid]) {
				if(key >= vals[low] && key < vals[mid]) {
					// key exists in left half
					return searchImpl(vals, low, mid - 1, key);
				} else {
					// key exists in right rotated half
					return searchImpl(vals, mid + 1, high, key);
				}
			} 
		}
		return -1;
	}
}
