package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 28.04.2017.
 */

/**
 * Default Comment
 */
public class FormulaValue {

    private double result;
    private double x;
    private double delta;

    public FormulaValue() { }

    public FormulaValue(double x, double result) {
        this.x = x;
        this.result = result;
    }

    public FormulaValue(double x, double result, double delta) {
        this.x = x;
        this.result = result;
        this.delta = delta;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}
