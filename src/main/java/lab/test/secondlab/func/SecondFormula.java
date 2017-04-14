package lab.test.secondlab.func;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.util.MathFuncs;

/**
 * Default Comment
 */
public class SecondFormula implements IFormula{

    private final double MIN = 0;

    @Override
    public double calc(double x) {
        return (x > MIN) ? numerator(x) / denumerator(x) : Double.NaN;
    }

    // firstAndSecondNumerator() - thirdNumerator(x) - log5(x)
    public double numerator(double x) {
        return firstAndSecondNumerator(x) - thirdNumerator(x) - MathFuncs.log(x, 5);
    }

    // (log5(x)−log10(x)
    public double firstAndSecondNumerator(double x) {
        return MathFuncs.log(x, 5) - MathFuncs.log(x, 10);
    }

    // log2(x))3
    public double thirdNumerator(double x) {
        return Math.pow(MathFuncs.log(x, 2), 3);
    }

    // log5(x)
    public double denumerator(double x) {
        return MathFuncs.log(x, 5);
    }
}
