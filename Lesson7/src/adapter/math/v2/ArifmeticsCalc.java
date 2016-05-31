package adapter.math.v2;

import adapter.math.Arifmetika;
import adapter.math.v2.calc.Calculator;


public class ArifmeticsCalc implements Calculator {

    @Override
    public int summa(int a, int b) {
        return Arifmetika.summa(new int[] {a, b});
    }

    @Override
    public int multiply(int a, int b) {
        int result = 1;

        for(int i= 0; i < a;i++) {
            result = result * Arifmetika.summa(new int [] {a, b});
        }

        return result;
    }
}
