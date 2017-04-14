package lab.test.secondlab.formula.standard;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.IFormula;

/**
 * Formula calculated with Java Math package, is the ideal to pursue
 *
 * FORMULA x <= 0 : (((((csc(x) - tan(x)) - cos(x)) * tan(x)) - tan(x)) + (csc(x) + (tan(x) - (tan(x) * sec(x)))))
 */
public class FirstFormulaStandard implements IFormula {

    private final double MIN = 0;

    @Override
    public double calc(double x) {
        return (x <= MIN) ? firstPart(x) + secondPart(x) : Double.NaN;
    }

    // firstTerm(x) − tan(x)
    public double firstPart(double x) {
        return firstTerm(x) - Math.tan(x);
    }

    // firstTermFirstPart(x) * tan(x)
    public double firstTerm(double x) {
        return firstTermFirstPart(x) * Math.tan(x);
    }

    // ((csc(x)−tan(x))−cos(x)
    public double firstTermFirstPart(double x) {
        return 1.0 / Math.sin(x) - Math.tan(x) - Math.cos(x);
    }

    // csc(x)+(tan(x)− secondTermsPart(x)
    public double secondPart(double x) {
        return 1.0 / Math.sin(x) + (Math.tan(x) - secondTermsPart(x));
    }

    // tan(x)⋅sec(x)
    public double secondTermsPart(double x) {
        return Math.tan(x) * 1.0/ Math.cos(x);
    }
}
