package lab.test.secondlab.formula;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.standard.FirstFormulaStandard;
import lab.test.secondlab.formula.standard.SecondFormulaStandard;

/**
 * Calc & incapsulates formulas
 */
public class SuperFuncs {

    // Our Implementation
    private static final IFormula firstFormula = new FirstFormula();
    private static final IFormula secondFormula = new SecondFormula();

    public static double firstFormula(double x) {
        return firstFormula.calc(x);
    }

    public static double secondFormula(double x) {
        return secondFormula.calc(x);
    }


    // Standard
    private static final IFormula firstFormulaStandard = new FirstFormulaStandard();
    private static final IFormula secondFormulaStandard = new SecondFormulaStandard();

    public static double firstFormulaStandard(double x) {
        return firstFormulaStandard.calc(x);
    }

    public static double secondFormulaStandard(double x) {
        return secondFormulaStandard.calc(x);
    }
}
