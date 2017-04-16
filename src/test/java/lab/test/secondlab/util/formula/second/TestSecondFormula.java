package lab.test.secondlab.util.formula.second;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.SecondFormula;
import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 */
public class TestSecondFormula {

    private static final double DELTA = 0.001;

    @Test
    public void secondFormulaFirstSectionTest() {
        double x = 0.5;
        Assert.assertEquals(-2.53, new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void secondFormulaSecondSectionTest() {
        double x = 0.85;
        Assert.assertEquals(-1.08416, new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void secondFormulaThirdSectionTest() {
        double x = 1.85;
        Assert.assertEquals(-2.20586, new SecondFormula().calc(x), DELTA);
    }
}
