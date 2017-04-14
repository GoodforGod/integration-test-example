package lab.test.secondlab.formula;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import static lab.test.secondlab.func.MathFuncs.*;

/**
 * Default Comment
 */
// x <= 0 : (((((csc(x) - tan(x)) - cos(x)) * tan(x)) - tan(x)) + (csc(x) + (tan(x) - (tan(x) * sec(x)))))
public class FirstFormula implements IFormula {

    private final double MIN = 0;

    @Override
    public double calc(double x) {
        return (x <= 0) ? firstPart(x) + secondPart(x) : Double.NaN;
    }

    // firstTerm(x) − tan(x)
    public double firstPart(double x) {
        return firstTerm(x) - tan(x);
    }

    // firstTermFirstPart(x) * tan(x)
    public double firstTerm(double x) {
        return firstTermFirstPart(x) * tan(x);
    }

    // ((csc(x)−tan(x))−cos(x)
    public double firstTermFirstPart(double x) {
        return csc(x) - tan(x) - cos(x);
    }

    // csc(x)+(tan(x)− secondTermsPart(x)
    public double secondPart(double x) {
        return csc(x) + (tan(x) - secondTermsPart(x));
    }

    // tan(x)⋅sec(x)
    public double secondTermsPart(double x) {
        return tan(x) * sec(x);
    }
}
