package edu.osu.cse;

import java.util.ArrayList;
import java.util.List;

public class CubeAndRollup {

	public static List<String> computeCube(String inp) {
		List<String> out = new ArrayList<String>();
		computeCubeImpl(inp, 0, "", out);
		return out;
	}

	private static void computeCubeImpl(String inp, int i, String temp, 
			List<String> out) {
		if(i == inp.length()) {
			out.add(temp);
			return;
		}
		temp = temp + String.valueOf(inp.charAt(i));
		computeCubeImpl(inp, i+1, temp, out);
		String newstr = temp.substring(0,i) + "*" + temp.substring(i+1);
		computeCubeImpl(inp, i+1, newstr, out);
	}
	
	public static List<String> computeRollup(String inp) {
		List<String> out = new ArrayList<String>();
		if(inp == null) return null;
		if(inp.isEmpty()) return out;
		
		String last = getAllStar(inp);
		out.add(inp);
		out.add(last);
		for(int i=1; i<inp.length(); i++) {
			String val = inp.substring(0, i) + last.substring(i);
			out.add(val);
		}
		return out;
	}

	private static String getAllStar(String inp) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<inp.length(); i++) {
			sb.append("*");
		}
		return sb.toString();
	}
	
}
