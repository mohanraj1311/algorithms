package edu.osu.cse;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

	public static String infixToPostfix(String expr) {
		if (expr == null || expr.isEmpty() == true || expr.length() == 1) {
			return expr;
		}

		Stack<String> stack = new Stack<String>();
		char[] tokens = expr.toCharArray();
		for (int i = 0; i < tokens.length; i++) {
			char c = tokens[i];
			if (c == ')') {
				List<String> strings = new ArrayList<String>();
				String val = "";
				String operator = "";
				try {
					while (!(val = stack.pop()).equals("(")) {
						if (isOperatorStr(val)) {
							operator = val;
						} else {
							strings.add(val);
						}
					}
				} catch (EmptyStackException e) {
					return null;
				}

				// join in reverse order since we popped from stack
				String joined = "";
				for (int j = strings.size(); j > 0; j--) {
					joined += strings.get(j - 1);
				}

				String cstr = "(" + joined + operator + ")";
				stack.push(cstr);
			} else {
				stack.push("" + c);
			}
		}

		return stack.pop();
	}

	private static boolean isOperatorStr(String val) {
		return val.equals("+") || val.equals("-") || val.equals("*")
				|| val.equals("/");
	}

	// every alternate characters should be operator
	public static boolean evaluateInfixExpression(String expr) {
		if (expr == null)
			return false;
		if (expr == "")
			return true;

		char[] tokens = expr.toCharArray();
		for (int i = 0; i < tokens.length; i++) {
			if (i % 2 == 0) {
				// variable
				if (isOperator(tokens[i]) == true) {
					return false;
				}
			} else {
				// operator
				if (isOperator(tokens[i]) == false) {
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
		if (expr == null)
			return null;
		if (expr.isEmpty())
			return "";
		if (expr.length() == 1)
			return expr;

		String first = expr.substring(0, 1);
		String last = expr.substring(expr.length() - 1);
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
				if (stack.size() < 2) {
					return false;
				}
				String val1 = stack.pop();
				String val2 = stack.pop();
				if (t == '+') {
					stack.push(val1 + "+" + val2);
				} else if (t == '-') {
					stack.push(val1 + "-" + val2);
				} else if (t == '*') {
					stack.push(val1 + "*" + val2);
				} else {
					stack.push(val1 + "/" + val2);
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
