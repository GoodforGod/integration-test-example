package lab.test.secondlab.util.formula.second;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.SecondFormula;
import lab.test.secondlab.util.ReportManager;
import org.junit.*;

import java.lang.Double;

/**
 * Default Comment
 */
public class TestSecondFormula {

    private static final double DELTA = 0.001;

    public double expected = 0;
    public double actual = 0;
    public String testName = "";

    @BeforeClass
    public static void setup() {
        ReportManager.init("secondFormula");
    }

    @AfterClass
    public static void generateReport() {
        ReportManager.flush();
    }

    @After
    public void reportResults() {
        ReportManager.report(expected, actual, testName);
        ReportManager.write();
    }

    @Test
    public void secondFormulaFirstSectionTest() {
        double x = 0.5;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = -2.53, actual = new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void secondFormulaSecondSectionTest() {
        double x = 0.85;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = -1.08416, actual = new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void secondFormulaThirdSectionTest() {
        double x = 1.85;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(actual = -2.20586, actual = new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void firstBorderPointTest() {
        double x = 0.75;
        Assert.assertEquals(expected = -1.26370, actual = new SecondFormula().calc(x), DELTA);
    }

    @Test
    public void secondBorderPointTest() {
        double x = 1;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        double result = new SecondFormula().calc(x);
        Assert.assertEquals(expected = Double.NaN, actual = result, DELTA);
    }

    @Test
    public void thirdBorderPointTest() {
        double x = 1.5;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        double result = new SecondFormula().calc(x);
        Assert.assertEquals(expected = -1.52383, actual = result, DELTA);
    }
}
