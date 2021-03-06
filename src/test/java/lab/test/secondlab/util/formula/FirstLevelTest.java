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

public class FirstLevelTest {
    private double expected, actual;

    public static void restoreStubs() {
        LogFuncs.isSecondStub = false;
        LogFuncs.isFirstStub = false;
        TrigoFuncs.isStub = false;
        SecondFormula.isStub = false;
        FirstFormula.isStub = false;
    }

    @After
    public void restoreAfterEach() {
        restoreStubs();
    }

    @AfterClass
    public static void restoreFull() {
        restoreStubs();
    }

    @Test
    public void testSecondFormulaStub() {
        SecondFormula.isStub = true;
        double x = 0.5;
        Assert.assertEquals(expected = -2.53, actual = SuperFuncs.calc(x), DELTA);
    }

    @Test
    public void testFirstFormulaStub() {
        FirstFormula.isStub = true;
        double x = -0.5;
        Assert.assertEquals(expected = -0.142848, actual = SuperFuncs.calc(x), DELTA);
    }

}
