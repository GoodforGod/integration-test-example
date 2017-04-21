package lab.test.secondlab.util.formula.first;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.FirstFormula;
import lab.test.secondlab.formula.IFormula;
import lab.test.secondlab.formula.standard.FirstFormulaStandard;
import lab.test.secondlab.util.Computer;
import lab.test.secondlab.util.PIType;
import lab.test.secondlab.util.ReportManager;
import org.junit.*;

import java.util.HashMap;

/**
 * Default Comment
 *
 *
 */
public class TestFirstFormula {

    private final static double DELTA_RANDOM_SMALL  = 5E-6;
    private final static double DELTA_RANDOM_MEDIUM = 5E-4;
    private final static double DELTA_RANDOM_HIGH   = 5E-2;

    private final static double DELTA_SMALL     = 5E-5;
    private final static double DELTA_MEDIUM    = 2E-2;
    private final static double DELTA_HIGN      = 9E-1;
    private final static double DELTA_HUGE      = 3;

    private final IFormula formula          = new FirstFormula();
    private final IFormula formulaStandard  = new FirstFormulaStandard();

    private final static double MIN = -10;
    private final static double MAX = 0;

    private final static HashMap<PIType, Double> SOURCE = new HashMap<>();

    // Generate & Set up
    @BeforeClass
    public static void setup() {
        ReportManager.init("firstFormula");

        SOURCE.put(PIType.PI_AND_HALF_NEG,      Computer.randomDouble(DELTA_RANDOM_SMALL));
        SOURCE.put(PIType.PI_NEG,               Computer.randomDouble(DELTA_RANDOM_SMALL));
        SOURCE.put(PIType.HALF_PI_AND_HALF_NEG, Computer.randomDouble(DELTA_RANDOM_MEDIUM));
        SOURCE.put(PIType.HALF_PI_NEG,          Computer.randomDouble(DELTA_RANDOM_MEDIUM));
        SOURCE.put(PIType.ZERO,                 Computer.randomDouble(DELTA_RANDOM_MEDIUM));
        SOURCE.put(PIType.HALF_PI,              Computer.randomDouble(DELTA_RANDOM_MEDIUM));
    }

    public double expected = 0;
    public double actual = 0;
    public String testName = "";

    @AfterClass
    public static void generateReport() {
        ReportManager.flush();
    }

    @After
    public void reportResults() {
        ReportManager.report(expected, actual, testName);
        ReportManager.write();
    }

    // useless
    @Test
    public void formulaRandomValueCompareStandard() {
        double x = Computer.randomDouble(MIN / 10, MAX);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_HUGE * 10);
    }

    //<editor-fold desc="Wolfram Specific">

    // In -3PI/2 to -PI
    @Test
    public void wolfFormulaPiAndHalfToPiNeg() {
        double x = -3.518583768;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = 0.69023, actual = formula.calc(x), DELTA_HIGN);
    }

    // In -PI tp -3PI/4
    @Test
    public void wolfFormulaPiToPiAndHalfAndHalfNeg() {
        double x = -2.41660973077;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = -1.78215869455722, actual = formula.calc(x), DELTA_HIGN);
    }

    // In -3PI/4 to -PI/2
    @Test
    public void wolfFormulaPiAndHalfAndHalfToHalfPiNeg() {
        double x = -1.88495559;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = -2.84902, actual = formula.calc(x), DELTA_HIGN);
    }

    // In -PI/2 to 0
    @Test
    public void wolfFormulaHalfPiToZeroNeg() {
        double x = -1.04719755;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = 2.17543, actual = formula.calc(x), DELTA_HIGN);
    }

    // In 0 to PI/2
    @Test
    public void wolfFormulaZeroToHalfPi() {
        double x = 0.95199777272 - Math.PI * 2;
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = -2.2560182862465, actual = formula.calc(x), DELTA_HIGN);
    }
    //</editor-fold>

    //<editor-fold desc="Intervals">

    // In -3PI/2 to -PI
    @Test
    public void formulaPiAndHalfToPiNeg() {
        double x = Computer.randomDouble(PIType.PI_AND_HALF_NEG.getValue(), PIType.PI_NEG.getValue());
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x), actual = formula.calc(x), DELTA_MEDIUM);
    }

    // In -PI tp -3PI/4
    @Test
    public void formulaPiToPiAndHalfAndHalfNeg() {
        double x = Computer.randomDouble(PIType.PI_NEG.getValue(), PIType.HALF_PI_AND_HALF_NEG.getValue());
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x), actual = formula.calc(x), DELTA_SMALL);
    }

    // In -3PI/4 to -PI/2
    @Test
    public void formulaPiAndHalfAndHalfToHalfPiNeg() {
        double x = Computer.randomDouble(PIType.HALF_PI_AND_HALF_NEG.getValue(), PIType.HALF_PI_NEG.getValue());
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x), actual = formula.calc(x), DELTA_SMALL);
    }

    // In -PI/2 to 0
    @Test
    public void formulaHalfPiToZeroNeg() {
        double x = Computer.randomDouble(PIType.HALF_PI_NEG.getValue(), PIType.ZERO.getValue());
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x), actual = formula.calc(x), DELTA_SMALL);
    }

    // In 0 to PI/2
    @Test
    public void formulaZeroToHalfPi() {
        double x = Computer.randomDouble(PIType.ZERO.getValue(), PIType.HALF_PI.getValue());
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x), actual = formula.calc(x), DELTA_SMALL);
    }
    //</editor-fold>

    //<editor-fold desc="Boundary">

    //<editor-fold desc="-3PI/2">

    @Test
    public void boundaryPiAndHalfNeg() {
        PIType type = PIType.PI_AND_HALF_NEG;
        double x = type.getValue();
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_HUGE * 10);
    }

//    @Test
//    public void boundaryPiAndHalfNegDeltaPos() {
//        PIType type = PIType.PI_AND_HALF_NEG;
//        Double x = type.getValue() + SOURCE.get(type);
//        Assert.assertEquals(formulaStandard.calc(x),
//                formula.calc(x),
//                DELTA_HUGE);
//    }

    @Test
    public void boundaryPiAndHalfNegDeltaNeg() {
        PIType type = PIType.PI_AND_HALF_NEG;
        double x = type.getValue() - SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_HUGE);
    }
    //</editor-fold>

    //<editor-fold desc="-PI">

    @Test
    public void boundaryPiNeg() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue();
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_MEDIUM);
    }

    @Test
    public void boundaryPiNegDeltaPos() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue() + SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_HUGE * 100000);
    }

    @Test
    public void boundaryPiNegDeltaNeg() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue() - SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_HUGE * 1000);
    }
    //</editor-fold>

    //<editor-fold desc="-3PI/4">

    @Test
    public void boundaryPiAndHalfAndHalfNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue();
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryPiAndHalfAndHalfNegDeltaPos() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue() + SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryPiAndHalfAndHalfNegDeltaNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue() + SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }
    //</editor-fold>

    //<editor-fold desc="-PI/2">

    @Test
    public void boundaryHalfPiNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue();
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryHalfPiNegDeltaPos() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue() + SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_MEDIUM);
    }

    @Test
    public void boundaryHalfPiNegDeltaNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue() - SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_HIGN);
    }
    //</editor-fold>

    //<editor-fold desc="0">

    @Test
    public void boundaryZero() {
        PIType type = PIType.ZERO;
        double x = type.getValue();
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryZeroDeltaPos() {
        PIType type = PIType.ZERO;
        double x = type.getValue() + SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryZeroDeltaNeg() {
        PIType type = PIType.ZERO;
        double x = type.getValue() - SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }
    //</editor-fold>

    //<editor-fold desc="PI/2">

    @Test
    public void boundaryHalfPiPos() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue();
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryHalfPiPosDeltaPos() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() + SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }

    @Test
    public void boundaryHalfPiPosDeltaNeg() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() - SOURCE.get(type);
        testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expected = formulaStandard.calc(x),
                actual = formula.calc(x),
                DELTA_SMALL);
    }
    //</editor-fold>

    //</editor-fold>
}
