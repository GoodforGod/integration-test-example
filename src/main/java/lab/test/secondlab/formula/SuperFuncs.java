package lab.test.secondlab.formula;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class SuperFuncs {

    private static final IFormula firstFormula = new FirstFormula();
    private static final IFormula secondFormula = new SecondFormula();

    public static double firstFormula(double x) {
        return firstFormula.calc(x);
    }

    public static double secondFormula(double x) {
        return secondFormula.calc(x);
    }
}
