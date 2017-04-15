package lab.test.secondlab.util.func.trigo;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.func.MathFuncs;
import lab.test.secondlab.util.Computer;
import lab.test.secondlab.util.PIType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

/**
 * Default Comment
 */
public class TestCos {

    private final static double DELTA = 0.005;

    private final static double MIN = 0;
    private final static double MAX = 1;

    private final static HashMap<PIType, Double> SOURCE = new HashMap<>();

    @Test
    public void randomValueCosTest() {
        double x = Computer.randomDouble(MIN, MAX);
        Assert.assertEquals(MathFuncs.cosStandard(x), MathFuncs.cos(x), DELTA);
    }

    // Generate & Set up
    @BeforeClass
    public static void generateValues() {
        SOURCE.put(PIType.ZERO,         Computer.randomDouble(DELTA));
        SOURCE.put(PIType.HALF_PI,      Computer.randomDouble(DELTA));
        SOURCE.put(PIType.PI,           Computer.randomDouble(DELTA));
        SOURCE.put(PIType.PI_AND_HALF,  Computer.randomDouble(DELTA));
        SOURCE.put(PIType.DOUBLE_PI,    Computer.randomDouble(DELTA));
    }

    //<editor-fold desc="0">
    @Test
    public void testZeroPoint() {
        PIType type = PIType.ZERO;
        double x = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testZeroPointAndDeltaPos() {
        PIType type = PIType.ZERO;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testZeroPointAndDeltaNeg() {
        PIType type = PIType.ZERO;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="PI / 2">
    @Test
    public void testHalfPiPoint() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testHalfPiPointAndDeltaPos() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testHalfPiPointAndDeltaNeg() {
        PIType type = PIType.HALF_PI;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="PI">
    @Test
    public void testPiPoint() {
        PIType type = PIType.PI;
        double x = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testPiPointAndDeltaPos() {
        PIType type = PIType.PI;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testPiPointAndDeltaNeg() {
        PIType type = PIType.PI;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="3PI / 2">
    @Test
    public void testPiAndAHalfPoint() {
        PIType type = PIType.PI_AND_HALF;
        double x = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testPiAndAHalfPointAndDeltaPos() {
        PIType type = PIType.PI_AND_HALF;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testPiAndAHalfPointAndDeltaNeg() {
        PIType type = PIType.PI_AND_HALF;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="2PI">
    @Test
    public void testTwoPiPoint() {
        PIType type = PIType.DOUBLE_PI;
        double x = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testTwoPiPointAndDeltaPos() {
        PIType type = PIType.DOUBLE_PI;
        double x = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }

    @Test
    public void testTwoPiPointAndDeltaNeg() {
        PIType type = PIType.DOUBLE_PI;
        double x = type.getValue() - SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(x),
                MathFuncs.cos(x),
                DELTA);
    }
    //</editor-fold>
}
