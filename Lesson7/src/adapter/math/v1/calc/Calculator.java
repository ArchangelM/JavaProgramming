package adapter.math.v1.calc;

import adapter.math.Arifmetika;

public class Calculator {

	public int summa(int a, int b) {
		return Arifmetika.summa(new int [] {a, b});
	}

	public int multiply(int a, int b) {
		int result = 1;

		for(int i= 0; i < a;i++) {
			result = result * Arifmetika.summa(new int [] {a, b});
		}

		return result;
	}

	/*

		public int summa(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
	*/

}
