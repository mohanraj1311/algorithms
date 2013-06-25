package edu.osu.cse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoValuesAddUptoSum {

	public static int find(int[] inp, int sum) {
		if(inp == null || inp.length == 0) {
			return -1;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i:inp) {
			if(map.containsKey(sum-i)) {
				System.out.println(i);
				System.out.println(sum-i);
				return 0;
			} else {
				map.put(i, 1);
			}
		}
		
		return -1;
	}
	
	public static int find2(int[] inp, int sum) {
		if(inp == null || inp.length == 0) {
			return -1;
		}
		
		Arrays.sort(inp);
		int start = 0;
		int end = inp.length - 1;
		while(start < end) {
			if(inp[start] + inp[end] == sum) {
				System.out.println(inp[start]);
				System.out.println(inp[end]);
				return 0;
			} else if((inp[start] + inp[end]) < sum) {
				start++;
			} else {
				end--;
			}
		}
		return -1;
	}
}
