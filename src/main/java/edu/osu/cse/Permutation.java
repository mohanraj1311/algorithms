package edu.osu.cse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	private static String sort(String inp) {
		char[] ch1 = inp.toCharArray();
		Arrays.sort(ch1);
		return new String(ch1);
	}
	public static boolean checkPermutation(String inp1, String inp2) {
		if(inp1 == null || inp2 == null) return false;

		if(inp1.length() != inp2.length()) {
			return false;
		}

		return sort(inp1).equals(sort(inp2));
	}
	
	public static boolean checkPermutation2(String inp1, String inp2) {
		if(inp1 == null || inp2 == null) return false;

		if(inp1.length() != inp2.length()) return false;

		// assuming ASCII string
		int[] check = new int[256];
		char[] ch1 = inp1.toCharArray();
		for(char ch: ch1) {
			check[ch]++;
		}

		for(int i=0; i<inp2.length(); i++) {
			int ch = inp2.charAt(i);
			if(--check[ch] < 0) {
				return false;
			}
		}

		return true;
	}
	
	public static void printAllPermutations(String inp) {
		printAllPermutationsImpl("", inp);
	}

	public static void printAllPermutationsImpl(String prefix, String inp) {
		if(inp.length() == 0) {
			System.out.println(prefix);
		} else {
			for(int i=0; i<inp.length(); i++) {
				printAllPermutationsImpl(prefix + inp.charAt(i), inp.substring(0,i) + inp.substring(i+1));
			}
		}
	}
	public static List<String> getAllPermutations(String inp) {
		List<String> output = new ArrayList<String>();
		if(inp == null) return null;
		if(inp == "") return new ArrayList<String>();
		
		getAllPermutationsImpl("", inp, output);
		return output;
	}
	private static void getAllPermutationsImpl(String prefix, String inp,
			List<String> output) {
		if(inp.length() == 0) {
			output.add(prefix);
		} else {
			for(int i=0; i<inp.length(); i++) {
				getAllPermutationsImpl(prefix + inp.charAt(i), inp.substring(0, i) + inp.substring(i+1), output);
			}
		}
	}
}
