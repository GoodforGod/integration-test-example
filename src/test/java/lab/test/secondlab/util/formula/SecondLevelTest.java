package lab.test.secondlab.util.formula;

import lab.test.secondlab.formula.FirstFormula;
import lab.test.secondlab.formula.SecondFormula;
import lab.test.secondlab.formula.SuperFuncs;
import lab.test.secondlab.func.LogFuncs;
import lab.test.secondlab.func.TrigoFuncs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static lab.test.secondlab.util.Computer.DELTA;

/**
 * Created by whobscr on 28.04.17.
 */
public class SecondLevelTest {

    private double expected, actual;

    @After
    public void restoreStubs() {
        LogFuncs.isStub = false;
        TrigoFuncs.isStub = false;
        SecondFormula.isStub = false;
        FirstFormula.isStub = false;
    }

    @Test
    public void testLogFunctionsStubs() {
        LogFuncs.isStub = true;
        double x = 0.5;
        Assert.assertEquals(expected = -2.53, actual = SuperFuncs.calc(x), DELTA);
    }
    @Test
    public void testTrigFunctionsStubs() {
        TrigoFuncs.isStub = true;
        double x = -0.5;
        Assert.assertEquals(expected = -0.142848, actual = SuperFuncs.calc(x), DELTA);
    }
}
