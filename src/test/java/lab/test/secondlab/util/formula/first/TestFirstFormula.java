package lab.test.secondlab.util.formula.first;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.formula.FirstFormula;
import lab.test.secondlab.formula.IFormula;
import lab.test.secondlab.formula.standard.FirstFormulaStandard;
import lab.test.secondlab.util.Computer;
import lab.test.secondlab.util.PIType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

/**
 * Default Comment
 *
 *
 */
public class TestFirstFormula {

    private final static double DELTA           = 5E-5;
    private final static double DELTA_MEDIUM    = 2E-2;
    private final static double DELTA_HIGN      = 9E-1;
    private final static double DELTA_HUGE      = 2;

    private final IFormula formula          = new FirstFormula();
    private final IFormula formulaStandard  = new FirstFormulaStandard();

    private final static double MIN = -10;
    private final static double MAX = 0;

    private final static HashMap<PIType, Double> SOURCE = new HashMap<>();

    // Generate & Set up
    @BeforeClass
    public static void generateValues() {
        SOURCE.put(PIType.PI_AND_HALF_NEG,      Computer.randomDouble(DELTA));
        SOURCE.put(PIType.PI_NEG,               Computer.randomDouble(DELTA));
        SOURCE.put(PIType.HALF_PI_AND_HALF_NEG, Computer.randomDouble(DELTA));
        SOURCE.put(PIType.HALF_PI_NEG,          Computer.randomDouble(DELTA));
        SOURCE.put(PIType.ZERO,                 Computer.randomDouble(DELTA));
        SOURCE.put(PIType.HALF_PI,              Computer.randomDouble(DELTA));
    }

    @Test
    public void formulaRandomValueCompareStandard() {
        double x = Computer.randomDouble(MIN, MAX);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA_HIGN);
    }

    //<editor-fold desc="Intervals">

    // In -3PI/2 to -PI
    @Test
    public void formulaPiAndHalfToPiNeg() {
        double x = Computer.randomDouble(PIType.PI_AND_HALF_NEG.getValue(), PIType.PI_NEG.getValue());
        Assert.assertEquals(formulaStandard.calc(x), formula.calc(x), DELTA_MEDIUM);
    }

    // In -PI tp -3PI/4
    @Test
    public void formulaPiToPiAndHalfAndHalfNeg() {
        double x = Computer.randomDouble(PIType.PI_NEG.getValue(), PIType.HALF_PI_AND_HALF_NEG.getValue());
        Assert.assertEquals(formulaStandard.calc(x), formula.calc(x), DELTA);
    }

    // In -3PI/4 to -PI/2
    @Test
    public void formulaPiAndHalfAndHalfToHalfPiNeg() {
        double x = Computer.randomDouble(PIType.HALF_PI_AND_HALF_NEG.getValue(), PIType.HALF_PI_NEG.getValue());
        Assert.assertEquals(formulaStandard.calc(x), formula.calc(x), DELTA);
    }

    // In -PI/2 to 0
    @Test
    public void formulaHalfPiToZeroNeg() {
        double x = Computer.randomDouble(PIType.HALF_PI_NEG.getValue(), PIType.ZERO.getValue());
        Assert.assertEquals(formulaStandard.calc(x), formula.calc(x), DELTA);
    }

    // In 0 to PI/2
    @Test
    public void formulaZeroToHalfPi() {
        double x = Computer.randomDouble(PIType.ZERO.getValue(), PIType.HALF_PI.getValue());
        Assert.assertEquals(formulaStandard.calc(x), formula.calc(x), DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="Boundary">

    //<editor-fold desc="-3PI/2">

//    @Test
//    public void boundaryPiAndHalfNeg() {
//        PIType type = PIType.PI_AND_HALF_NEG;
//        double x = type.getValue();
//        Assert.assertEquals(formulaStandard.calc(x),
//                formula.calc(x),
//                DELTA_HUGE);
//    }
//
//    @Test
//    public void boundaryPiAndHalfNegDeltaPos() {
//        PIType type = PIType.PI_AND_HALF_NEG;
//        Double x = type.getValue() + SOURCE.get(type);
//        Assert.assertEquals(formulaStandard.calc(x),
//                formula.calc(x),
//                DELTA_HIGN);
//    }
//
//    @Test
//    public void boundaryPiAndHalfNegDeltaNeg() {
//        PIType type = PIType.PI_AND_HALF_NEG;
//        double x = type.getValue() - SOURCE.get(type);
//        Assert.assertEquals(formulaStandard.calc(x),
//                formula.calc(x),
//                DELTA_HIGN);
//    }
    //</editor-fold>

    //<editor-fold desc="-PI">

//    @Test
//    public void boundaryPiNeg() {
//        PIType type = PIType.PI_NEG;
//        double x = type.getValue();
//        Assert.assertEquals(formulaStandard.calc(x),
//                formula.calc(x),
//                DELTA_MEDIUM);
//    }

    @Test
    public void boundaryPiNegDeltaPos() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA_HUGE * 10);
    }

    @Test
    public void boundaryPiNegDeltaNeg() {
        PIType type = PIType.PI_NEG;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA_HUGE * 10);
    }
    //</editor-fold>

    //<editor-fold desc="-3PI/4">

    @Test
    public void boundaryPiAndHalfAndHalfNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue();
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryPiAndHalfAndHalfNegDeltaPos() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryPiAndHalfAndHalfNegDeltaNeg() {
        PIType type = PIType.HALF_PI_AND_HALF_NEG;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="-PI/2">

    @Test
    public void boundaryHalfPiNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue();
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryHalfPiNegDeltaPos() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryHalfPiNegDeltaNeg() {
        PIType type = PIType.HALF_PI_NEG;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="0">

    @Test
    public void boundaryZero() {
        PIType type = PIType.ZERO;
        double x = type.getValue();
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryZeroDeltaPos() {
        PIType type = PIType.ZERO;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryZeroDeltaNeg() {
        PIType type = PIType.ZERO;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="PI/2">

    @Test
    public void boundaryHalfPiPos() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue();
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryHalfPiPosDeltaPos() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }

    @Test
    public void boundaryHalfPiPosDeltaNeg() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(formulaStandard.calc(x),
                formula.calc(x),
                DELTA);
    }
    //</editor-fold>

    //</editor-fold>
}
