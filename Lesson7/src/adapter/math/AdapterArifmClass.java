package adapter.math;

import adapter.math.v2.calc.Calculator;
import adapter.math.v2.calc.DefaultCalculator;

public class AdapterArifmClass extends Arifmetika implements Calculator{

    public int summa(int a, int b) {
        return super.summa(new int [] {a, b});
    }

    public int multiply(int a, int b) {
        return super.multiply(a, b);
    }
}
