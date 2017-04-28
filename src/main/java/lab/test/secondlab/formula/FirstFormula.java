package lab.test.secondlab.formula;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.standard.FirstFormulaStandard;
import lab.test.secondlab.util.FirstStubSource;
import lab.test.secondlab.util.PIType;

import static lab.test.secondlab.func.MathFuncs.*;

/**
 * Our implementation
 *
 * FORMULA  x <= 0 : (((((csc(x) - tan(x)) - cos(x)) * tan(x)) - tan(x)) + (csc(x) + (tan(x) - (tan(x) * sec(x)))))
 */
public class FirstFormula implements IFormula {

    public static boolean isStub = false;

    private FirstStubSource stubSource = new FirstStubSource();

    private final double MIN = 0;

    @Override
    public double calc(double x) {
        if (isStub)
        {
            if(x == -0.5)
                return -0.142848;

            // PI BOUNDARY
            if(x == stubSource.SOURCE_BOUNDARY.get(PIType.PI_AND_HALF_NEG).getX())
                return stubSource.SOURCE_BOUNDARY.get(PIType.PI).getResult();
            if(x == stubSource.SOURCE_BOUNDARY.get(PIType.PI_NEG).getX())
                return stubSource.SOURCE_BOUNDARY.get(PIType.PI_NEG).getResult();
            if(x == stubSource.SOURCE_BOUNDARY.get(PIType.HALF_PI_AND_HALF_NEG).getX())
                return stubSource.SOURCE_BOUNDARY.get(PIType.HALF_PI_AND_HALF_NEG).getResult();
            if(x == stubSource.SOURCE_BOUNDARY.get(PIType.HALF_PI_NEG).getX())
                return stubSource.SOURCE_BOUNDARY.get(PIType.HALF_PI_NEG).getResult();
            if(x == stubSource.SOURCE_BOUNDARY.get(PIType.ZERO).getX())
                return stubSource.SOURCE_BOUNDARY.get(PIType.ZERO).getResult();
            if(x == stubSource.SOURCE_BOUNDARY.get(PIType.HALF_PI).getX())
                return stubSource.SOURCE_BOUNDARY.get(PIType.HALF_PI).getResult();

            // PI INTERVAL
            if(x == stubSource.SOURCE_INTERVAL.get(PIType.PI_AND_HALF_NEG).getX())
                return stubSource.SOURCE_INTERVAL.get(PIType.PI).getResult();
            if(x == stubSource.SOURCE_INTERVAL.get(PIType.PI_NEG).getX())
                return stubSource.SOURCE_INTERVAL.get(PIType.PI_NEG).getResult();
            if(x == stubSource.SOURCE_INTERVAL.get(PIType.HALF_PI_AND_HALF_NEG).getX())
                return stubSource.SOURCE_INTERVAL.get(PIType.HALF_PI_AND_HALF_NEG).getResult();
            if(x == stubSource.SOURCE_INTERVAL.get(PIType.HALF_PI_NEG).getX())
                return stubSource.SOURCE_INTERVAL.get(PIType.HALF_PI_NEG).getResult();
            if(x == stubSource.SOURCE_INTERVAL.get(PIType.ZERO).getX())
                return stubSource.SOURCE_INTERVAL.get(PIType.ZERO).getResult();
        }

        if(FirstFormulaStandard.exсeptionalConditionCheck(x))
            return Double.NaN;

        return (x <= MIN) ? firstPart(x) + secondPart(x) : Double.NaN;
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
