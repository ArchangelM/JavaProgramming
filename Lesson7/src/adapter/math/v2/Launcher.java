package adapter.math.v2;

import java.util.Random;

import adapter.math.AdapterArifmClass;
import adapter.math.v2.calc.Calculator;
import adapter.math.v2.calc.DefaultCalculator;

public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new DefaultCalculator();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}

		Calculator calc1 = new DefaultCalculator();
		AdapterArifmClass adapter = new AdapterArifmClass();

		Operations o1 = new Operations();
		o.setCalc(adapter);

		for (int i = 0; i < 5; i++) {
			System.out.println(adapter.summa(r.nextInt(100), r.nextInt(100)));
		}
	}
}
