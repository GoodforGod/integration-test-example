package lab.test.secondlab.util.formula;

/*
 * Created by @GoodforGod on 28.04.2017.
 */

import lab.test.secondlab.formula.SuperFuncs;
import lab.test.secondlab.util.FormulaValue;
import lab.test.secondlab.util.PIType;
import lab.test.secondlab.util.ReportManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

/**
 * Default Comment
 */
public class TestIncrementalFirstFormula {

    private final static double DELTA = 3E-5;

    private final static HashMap<PIType, FormulaValue> SOURCE_BOUNDARY = new HashMap<>();
    private final static HashMap<PIType, FormulaValue> SOURCE_INTERVAL = new HashMap<>();

    private double expectedReported = 0;
    private double actualReported = 0;
    private String testNameReported = "";

    @BeforeClass
    public static void setupInterval() {
        SOURCE_INTERVAL.put(PIType.PI_AND_HALF_NEG,     new FormulaValue(-3.518583768, 0.69023));
        SOURCE_INTERVAL.put(PIType.PI_NEG,              new FormulaValue(-2.41660973077, -1.78215869455722));
        SOURCE_INTERVAL.put(PIType.HALF_PI_AND_HALF_NEG, new FormulaValue(-1.88495559, -2.84902));
        SOURCE_INTERVAL.put(PIType.HALF_PI_NEG,         new FormulaValue(-1.04719755, 2.17543));
        SOURCE_INTERVAL.put(PIType.ZERO,                new FormulaValue(0.95199777272 - Math.PI * 2, -2.2560182862465));
    }

    @BeforeClass
    public static void setupBoundary() {
        SOURCE_BOUNDARY.put(PIType.PI_AND_HALF_NEG,     new FormulaValue(PIType.PI_AND_HALF_NEG.getValue(), 0.));
        SOURCE_BOUNDARY.put(PIType.PI_NEG,              new FormulaValue(PIType.PI_NEG.getValue(), 0.));
        SOURCE_BOUNDARY.put(PIType.HALF_PI_AND_HALF_NEG, new FormulaValue(PIType.HALF_PI_AND_HALF_NEG.getValue(), 0.));
        SOURCE_BOUNDARY.put(PIType.HALF_PI_NEG,         new FormulaValue(PIType.HALF_PI_NEG.getValue(), 0.));
        SOURCE_BOUNDARY.put(PIType.ZERO,                new FormulaValue(PIType.ZERO.getValue(), 0.));
        SOURCE_BOUNDARY.put(PIType.HALF_PI,             new FormulaValue(PIType.HALF_PI.getValue(), 0.));
    }

    @BeforeClass
    public static void setup() {
        ReportManager.init("firstFormulaIncremental");
    }

    //<editor-fold desc="Intervals">

    // In -3PI/2 to -PI
    @Test
    public void formulaPiAndHalfToPiNeg() {
        PIType type = PIType.PI_AND_HALF_NEG;
        double x = SOURCE_INTERVAL.get(type).getX();
        double result = SOURCE_INTERVAL.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    // In -PI tp -3PI/4
    @Test
    public void formulaPiToPiAndHalfAndHalfNeg() {
        PIType type = PIType.PI_NEG;
        double x = SOURCE_INTERVAL.get(type).getX();
        double result = SOURCE_INTERVAL.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    // In -3PI/4 to -PI/2
    @Test
    public void formulaPiAndHalfAndHalfToHalfPiNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = SOURCE_INTERVAL.get(type).getX();
        double result = SOURCE_INTERVAL.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    // In -PI/2 to 0
    @Test
    public void formulaHalfPiToZeroNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = SOURCE_INTERVAL.get(type).getX();
        double result = SOURCE_INTERVAL.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    // In 0 to PI/2
    @Test
    public void formulaZeroToHalfPi() {
        PIType type = PIType.ZERO;
        double x = SOURCE_INTERVAL.get(type).getX();
        double result = SOURCE_INTERVAL.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="Boundary">

    @Test
    public void boundaryPiAndHalfNeg() {
        PIType type = PIType.PI_AND_HALF_NEG;
        double x = SOURCE_BOUNDARY.get(type).getX();
        double result = SOURCE_BOUNDARY.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    @Test
    public void boundaryPiNeg() {
        PIType type = PIType.PI_NEG;
        double x = SOURCE_BOUNDARY.get(type).getX();
        double result = SOURCE_BOUNDARY.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    @Test
    public void boundaryHalfPiAndHalfNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = SOURCE_BOUNDARY.get(type).getX();
        double result = SOURCE_BOUNDARY.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    @Test
    public void boundaryHalfPiNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = SOURCE_BOUNDARY.get(type).getX();
        double result = SOURCE_BOUNDARY.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    @Test
    public void boundaryZero() {
        PIType type = PIType.ZERO;
        double x = SOURCE_BOUNDARY.get(type).getX();
        double result = SOURCE_BOUNDARY.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    @Test
    public void boundaryHalfPiPos() {
        PIType type = PIType.PI;
        double x = SOURCE_BOUNDARY.get(type).getX();
        double result = SOURCE_BOUNDARY.get(type).getResult();

        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported = result, actualReported = SuperFuncs.calc(x), DELTA);
    }

    //</editor-fold>

    //<editor-fold desc="BoundaryWithDelta">

    // -3P/2
    @Test
    public void boundaryPiAndHalfNegDeltaPos() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue();
    }

    @Test
    public void boundaryPiAndHalfNegDeltaNeg() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue();
    }



    // -P
    @Test
    public void boundaryPiNegDeltaPos() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();
    }

    @Test
    public void boundaryPiNegDeltaNeg() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue() - SOURCE_BOUNDARY.get(type).getDelta();
    }



    // -3P/4
    @Test
    public void boundaryHalfPiAndHalfNegDeltaPos() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();
    }

    @Test
    public void boundaryHalfPiAndHalfNegDeltaNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();

    }



    // -P/2
    @Test
    public void boundaryHalfPiNegDeltaPos() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();
    }

    @Test
    public void boundaryHalfPiNegDeltaNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue() - SOURCE_BOUNDARY.get(type).getDelta();
    }



    // 0
    @Test
    public void boundaryZeroDeltaPos() {
        PIType type = PIType.ZERO;
        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();
    }

    @Test
    public void boundaryZeroDeltaNeg() {
        PIType type = PIType.ZERO;
        double x = type.getValue() - SOURCE_BOUNDARY.get(type).getDelta();
    }



    // P/2
    @Test
    public void boundaryHalfPiPosDeltaPos() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();
    }

    @Test
    public void boundaryHalfPiPosDeltaNeg() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() - SOURCE_BOUNDARY.get(type).getDelta();
    }
    //</editor-fold>
}
