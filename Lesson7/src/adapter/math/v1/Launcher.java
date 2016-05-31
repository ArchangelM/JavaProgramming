package adapter.math.v1;

import java.util.Random;

import adapter.math.AdapterArifmClass;
import adapter.math.AdapterArifmObject;
import adapter.math.v1.calc.Calculator;

public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}

		AdapterArifmObject adapter = new AdapterArifmObject();


		for (int i = 0; i < 5; i++) {
			System.out.println(adapter.summa(r.nextInt(100), r.nextInt(100)));
		}


	}
}
