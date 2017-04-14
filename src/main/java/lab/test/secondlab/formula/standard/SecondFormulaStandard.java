package lab.test.secondlab.formula.standard;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.IFormula;

/**
 * Formula calculated with Java Math package, is the ideal to pursue
 *
 * FORMULA  x > 0 : (((((log_5(x) - log_10(x)) - log_2(x)) ^ 3) - log_5(x)) / log_5(x))
 */
public class SecondFormulaStandard implements IFormula {

    private final double MIN = 0;

    @Override
    public double calc(double x) {
        return (x > MIN) ? numerator(x) / denumerator(x) : Double.NaN;
    }

    // firstAndSecondNumerator() - thirdNumerator(x) - log5(x)
    public double numerator(double x) {
        return firstAndSecondNumerator(x) - thirdNumerator(x) - Math.log(x) / Math.log(5);
    }

    // (log5(x)−log10(x)
    public double firstAndSecondNumerator(double x) {
        return Math.log(x) / Math.log(5) - Math.log(x) / Math.log(10);
    }

    // log2(x))3
    public double thirdNumerator(double x) {
        return Math.pow(Math.log(x) / Math.log(2), 3);
    }

    // log5(x)
    public double denumerator(double x) {
        return Math.log(x) / Math.log(5);
    }
}
