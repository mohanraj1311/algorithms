package edu.osu.cse;

public class Sqrt {

	public static double sqrt(double n) {

		if (n < 0) {
			throw new RuntimeException("Unsupported");
		}
		if (n == 0 || n == 1) {
			return n;
		}

		return computeIterative(n, 0d, n + 1, 0.000001);
	}

	private static double computeIterative(double n, double low, double high,
			double epsilon) {
		double mid = 0d;

		while ((high - low) > epsilon) {
			mid = low + (high - low) / 2.0;
			if (mid * mid > n) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

	public static double sqrt2(double n) {

		if (n < 0) {
			throw new RuntimeException("Unsupported");
		}
		if (n == 0 || n == 1) {
			return n;
		}

		return computeRecursive(n, 0d, n + 1, 0.000001);
	}

	private static double computeRecursive(double n, double low, double high,
			double epsilon) {
		if ((high - low) < epsilon) {
			return low;
		}

		double mid = low + (high - low) / 2.0;
		if (mid * mid > n) {
			return computeRecursive(n, low, mid, epsilon);
		} else {
			return computeRecursive(n, mid, high, epsilon);
		}
	}
}
