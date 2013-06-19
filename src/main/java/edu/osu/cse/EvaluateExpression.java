package edu.osu.cse;

import java.util.Stack;

public class EvaluateExpression {

	// every alternate characters should be operator
	public static boolean evaluateInfixExpression(String expr) {
		if (expr == null)
			return false;
		if (expr == "")
			return true;

		char[] tokens = expr.toCharArray();
		for(int i=0; i<tokens.length; i++) {
			if(i%2 == 0) {
				// variable
				if(isOperator(tokens[i]) == true) {
					return false;
				}
			} else {
				// operator
				if(isOperator(tokens[i]) == false) {
					return false;
				}
			}
		}
		return true;
	}

	// reverse the string and use postfix evaluation
	public static boolean evaluatePrefixExpression(String expr) {
		return evaluatePostfixExpression(reverse(expr));
	}

	private static String reverse(String expr) {
		if(expr == null) return null;
		if(expr.isEmpty()) return "";
		if(expr.length() == 1) return expr;
		
		String first = expr.substring(0,1);
		String last = expr.substring(expr.length()-1);
		return last + reverse(expr.substring(1, expr.length() - 1)) + first;
	}

	public static boolean evaluatePostfixExpression(String expr) {
		if (expr == null)
			return false;
		if (expr == "")
			return true;

		char[] tokens = expr.toCharArray();
		Stack<String> stack = new Stack<String>();
		for (char t : tokens) {
			if (isOperator(t)) {
				if(stack.size() < 2) {
					return false;
				}
				String val1 = stack.pop();
				String val2 = stack.pop();
				if(t == '+') {
					stack.push(val1 + "+"+ val2);
				} else if( t == '-') {
					stack.push(val1 + "-"+ val2);
				} else if( t == '*') {
					stack.push(val1 + "*"+ val2);
				} else {
					stack.push(val1 + "/"+ val2);
				}
			} else {
				stack.push(String.valueOf(t));
			}
		}

		return true;
	}

	private static boolean isOperator(char t) {
		return (t == '+' || t == '-' || t == '/' || t == '*');
	}
}
