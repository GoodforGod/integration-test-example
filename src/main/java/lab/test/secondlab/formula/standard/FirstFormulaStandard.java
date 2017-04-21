package lab.test.secondlab.formula.standard;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.IFormula;
import lab.test.secondlab.util.PIType;

import java.util.Map;

import static lab.test.secondlab.func.MathFuncs.*;

/**
 * Formula calculated with Java Math package, is the ideal to pursue
 *
 * FORMULA x <= 0 : (((((csc(x) - tan(x)) - cos(x)) * tan(x)) - tan(x)) + (csc(x) + (tan(x) - (tan(x) * sec(x)))))
 */
public class FirstFormulaStandard implements IFormula {

    private final double MIN = 0;
    private static final double DELTA = 0.0001;

    @Override
    public double calc(double x) {
        if(exсeptionalConditionCheck(x))
            return Double.NaN;

        return (x <= MIN) ? firstPart(x) + secondPart(x) : Double.NaN;
    }

    // Test special conditions like infinity & undefined
    public static boolean exсeptionalConditionCheck(double x) {
        return Math.abs(x % PIType.HALF_PI_AND_HALF_NEG.getValue()) <= DELTA
                || Math.abs(x % PIType.PI_NEG.getValue()) <= DELTA
                || Math.abs(x % PIType.PI_AND_HALF_NEG.getValue()) <= DELTA;
    }

    // firstTerm(x) − tan(x)
    public double firstPart(double x){
        return firstTerm(x) - tanStandard(x);
    }

    // firstTermFirstPart(x) * tan(x)
    public double firstTerm(double x) {
        return firstTermFirstPart(x) * tanStandard(x);
    }

    // ((csc(x)−tan(x))−cos(x)
    public double firstTermFirstPart(double x) {
        return cscStandard(x) - tanStandard(x) - cosStandard(x);
    }

    // csc(x)+(tan(x)− secondTermsPart(x)
    public double secondPart(double x) {
        return cscStandard(x) + (tanStandard(x) - secondTermsPart(x));
    }

    // tan(x)⋅sec(x)
    public double secondTermsPart(double x) {
        return tanStandard(x) * secStandard(x);
    }
}
