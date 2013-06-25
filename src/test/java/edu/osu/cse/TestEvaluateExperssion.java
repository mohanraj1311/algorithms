package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEvaluateExperssion {
	@Test
	public void testInFixExpr() {
		assertEquals(true, EvaluateExpression.evaluateInfixExpression("a+b"));
		assertEquals(true, EvaluateExpression.evaluateInfixExpression("a+b*c-d"));
		assertEquals(true, EvaluateExpression.evaluateInfixExpression("a+b+a+b"));
		assertEquals(false, EvaluateExpression.evaluateInfixExpression("ab+-cd-*"));
		assertEquals(false, EvaluateExpression.evaluateInfixExpression("ab+-"));
		assertEquals(true, EvaluateExpression.evaluateInfixExpression("a+b+c+d"));
		assertEquals(true, EvaluateExpression.evaluateInfixExpression(""));
		assertEquals(false, EvaluateExpression.evaluateInfixExpression(null));
	}
	
	@Test
	public void testPreFixExpr() {
		assertEquals(true, EvaluateExpression.evaluatePrefixExpression("+ab"));
		assertEquals(true, EvaluateExpression.evaluatePrefixExpression("-*ab+cd"));
		assertEquals(true, EvaluateExpression.evaluatePrefixExpression("++ab+ab"));
		assertEquals(false, EvaluateExpression.evaluatePrefixExpression("-*ab+-cd"));
		assertEquals(false, EvaluateExpression.evaluatePrefixExpression("-+ab"));
		assertEquals(false, EvaluateExpression.evaluatePrefixExpression("a+b+c+d"));
		assertEquals(true, EvaluateExpression.evaluatePrefixExpression(""));
		assertEquals(false, EvaluateExpression.evaluatePrefixExpression(null));
	}
	
	@Test
	public void testPostFixExpr() {
		assertEquals(true, EvaluateExpression.evaluatePostfixExpression("ab+"));
		assertEquals(true, EvaluateExpression.evaluatePostfixExpression("ab+cd-*"));
		assertEquals(true, EvaluateExpression.evaluatePostfixExpression("ab+ab++"));
		assertEquals(false, EvaluateExpression.evaluatePostfixExpression("ab+-cd-*"));
		assertEquals(false, EvaluateExpression.evaluatePostfixExpression("ab+-"));
		assertEquals(false, EvaluateExpression.evaluatePostfixExpression("a+b+c+d"));
		assertEquals(true, EvaluateExpression.evaluatePostfixExpression(""));
		assertEquals(false, EvaluateExpression.evaluatePostfixExpression(null));
	}
	
	@Test
	public void testExprConversion() {
		assertEquals("(ab+)", EvaluateExpression.infixToPostfix("(a+b)"));
		assertEquals("(((cd+)a-)b+)", EvaluateExpression.infixToPostfix("(((c+d)-a)+b)"));
		assertEquals("((cd+)(ab+)-)", EvaluateExpression.infixToPostfix("((c+d)-(a+b))"));
		assertEquals(null, EvaluateExpression.infixToPostfix("(c+d)-(a+b))"));
	}
}
