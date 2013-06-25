package edu.osu.cse;

public class Power {

	public static double pow(double a, double b) {
		boolean negPow = false;
		if (b < 0d) {
			negPow = true;
			b = -b;
		}
		double result = powImpl(a, b);

		if (negPow) {
			result = 1d / result;
		}

		return result;
	}

	private static double powImpl(double a, double b) {
		if (a == 0d) {
			return 0d;
		}

		if (a == 1d) {
			return 1d;
		}

		if( b == 0d) {
			return 1d;
		}
		
		if (b == 1d) {
			return a;
		}

		double temp = powImpl(a, Math.floor(b / 2d));
		if (b % 2d == 0d) {
			return temp * temp;
		} else {
			return a * temp * temp;
		}
	}
}
