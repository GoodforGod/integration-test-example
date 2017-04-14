package lab.test.secondlab.formula.standard;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.IFormula;
import lab.test.secondlab.func.MathFuncs;

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
        return firstAndSecondNumerator(x) - thirdNumerator(x) - MathFuncs.logStandard(x, 5);
    }

    // (log5(x)−log10(x)
    public double firstAndSecondNumerator(double x) {
        return MathFuncs.logStandard(x, 5) - MathFuncs.logStandard(x, 10);
    }

    // log2(x))3
    public double thirdNumerator(double x) {
        return MathFuncs.powStandard(MathFuncs.logStandard(x, 2), 3);
    }

    // log5(x)
    public double denumerator(double x) {
        return MathFuncs.logStandard(x, 5);
    }
}
