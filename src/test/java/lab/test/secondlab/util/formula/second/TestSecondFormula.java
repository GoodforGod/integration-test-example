package lab.test.secondlab.util.formula.second;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.SecondFormula;
import org.junit.Assert;
import org.junit.Test;

import java.lang.Double;

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

    @Test
    public void firstBorderPointTest() {
        double x = 0.75;
        Assert.assertEquals(-1.26370, new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void secondBorderPointTest() {
        double x = 1;
        double result = new SecondFormula().calc(x);
        Assert.assertEquals(Double.NaN, result, DELTA);
    }

    @Test
    public void thirdBorderPointTest() {
        double x = 1.5;
        double result = new SecondFormula().calc(x);
        Assert.assertEquals(-1.52383, result, DELTA);
    }
}
