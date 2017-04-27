package lab.test.secondlab.util.formula;

/**
 * Created by whobscr on 27.04.17.
 */

import lab.test.secondlab.formula.FirstFormula;
import lab.test.secondlab.formula.SecondFormula;
import lab.test.secondlab.formula.SuperFuncs;
import lab.test.secondlab.func.LogFuncs;
import lab.test.secondlab.func.TrigoFuncs;
import lab.test.secondlab.util.ReportManager;
import org.junit.*;

import static lab.test.secondlab.util.Computer.DELTA;

public class Incremental {
    private double expected, actual;

    @AfterClass
    public static void restoreStubs() {
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
        LogFuncs.isStub = false;
    }

    @Test
    public void testSecondFormulaStub() {
        SecondFormula.isStub = true;
        double x = 0.5;
        Assert.assertEquals(expected = -2.53, actual = SuperFuncs.calc(x), DELTA);
        SecondFormula.isStub = false;
    }

    @Test
    public void testTrigFunctionsStubs() {
        TrigoFuncs.isStub = true;
        double x = -0.5;
        Assert.assertEquals(expected = -0.142848, actual = SuperFuncs.calc(x), DELTA);
        TrigoFuncs.isStub = false;
    }

    @Test
    public void testFirstFormulaStub() {
        FirstFormula.isStub = true;
        double x = -0.5;
        Assert.assertEquals(expected = -0.142848, actual = SuperFuncs.calc(x), DELTA);
        FirstFormula.isStub = false;
    }
}
