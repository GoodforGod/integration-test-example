package lab.test.secondlab.util.formula.second;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.SecondFormula;
import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 *
 *
 */
public class TestSecondFormula {

    @Test
    public void secondFormulaFirstSectionTest() {
        double x = 0.5;
        Assert.assertEquals(new SecondFormula().calc(x), -2.53, 0.001);
    }
}
