package reflection;

import java.awt.*;

@Service
public class PrivateTest {
    private Integer tInt;
    private double[] testArray;
    private Double testDouble;
    private Color color;

    public PrivateTest() {
    }

    public PrivateTest(int tInt) {
        this.tInt = tInt;
    }

    public PrivateTest(int tInt, double[] testArray, Color color) {
        this.tInt = tInt;
        this.testArray = testArray;
        this.color = color;
    }

    public PrivateTest(Integer tInt, Double testDouble, Color color) {
        this.tInt = tInt;
        this.testDouble = testDouble;
        this.color = color;
    }

    public int gettInt() {
        return tInt;
    }

    public void settInt(int tInt) {
        this.tInt = tInt;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double[] getTestArray() {
        return testArray;
    }

    public void setTestArray(double[] testArray) {
        this.testArray = testArray;
    }

    public Double getTestDouble() {
        return testDouble;
    }

    public void setTestDouble(Double testDouble) {
        this.testDouble = testDouble;
    }
}
