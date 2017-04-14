package lab.test.secondlab.formula;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import static lab.test.secondlab.func.MathFuncs.*;

/**
 * Our implementation
 *
 * FORMULA  x > 0 : (((((log_5(x) - log_10(x)) - log_2(x)) ^ 3) - log_5(x)) / log_5(x))
 */
public class SecondFormula implements IFormula{

    private final double MIN = 0;

    @Override
    public double calc(double x) {
        return (x > MIN) ? numerator(x) / denominator(x) : Double.NaN;
    }

    // firstAndSecondNumerator() - thirdNumerator(x) - log5(x)
    private double numerator(double x) {
        return firstAndSecondNumerator(x) - thirdNumerator(x) - log(x, 5);
    }

    // (log5(x)−log10(x)
    private double firstAndSecondNumerator(double x) {
        return log(x, 5) - log(x, 10);
    }

    // log2(x))3
    private double thirdNumerator(double x) {
        return pow(log(x, 2), 3);
    }

    // log5(x)
    private double denominator(double x) {
        return log(x, 5);
    }
}
