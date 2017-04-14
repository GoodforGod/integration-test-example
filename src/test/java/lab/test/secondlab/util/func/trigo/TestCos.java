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
        double value = Computer.randomDouble(MIN, MAX);
        Assert.assertEquals(MathFuncs.cosStandard(value), MathFuncs.cos(value), DELTA);
    }

    // Generate & Set up
    @BeforeClass
    public static void generateValues() {
        SOURCE.put(PIType.ZERO,         Computer.randomDouble());
        SOURCE.put(PIType.HALF_PI,      Computer.randomDouble());
        SOURCE.put(PIType.PI,           Computer.randomDouble());
        SOURCE.put(PIType.PI_AND_HALF,  Computer.randomDouble());
        SOURCE.put(PIType.DOUBLE_PI,    Computer.randomDouble());
    }

    //<editor-fold desc="0">
    @Test
    public void testZeroPoint() {
        PIType type = PIType.ZERO;
        double value = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testZeroPointAndDeltaPos() {
        PIType type = PIType.ZERO;
        double value = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testZeroPointAndDeltaNeg() {
        PIType type = PIType.ZERO;
        double value = -(type.getValue() + SOURCE.get(type));
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="PI / 2">
    @Test
    public void testHalfPiPoint() {
        PIType type = PIType.HALF_PI;
        double value = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testHalfPiPointAndDeltaPos() {
        PIType type = PIType.HALF_PI;
        double value = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testHalfPiPointAndDeltaNeg() {
        PIType type = PIType.HALF_PI;
        double value = -(type.getValue() + SOURCE.get(type));
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="PI">
    @Test
    public void testPiPoint() {
        PIType type = PIType.PI;
        double value = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testPiPointAndDeltaPos() {
        PIType type = PIType.PI;
        double value = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testPiPointAndDeltaNeg() {
        PIType type = PIType.PI;
        double value = -(type.getValue() + SOURCE.get(type));
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="3PI / 2">
    @Test
    public void testPiAndAHalfPoint() {
        PIType type = PIType.PI_AND_HALF;
        double value = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testPiAndAHalfPointAndDeltaPos() {
        PIType type = PIType.PI_AND_HALF;
        double value = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testPiAndAHalfPointAndDeltaNeg() {
        PIType type = PIType.PI_AND_HALF;
        double value = -(type.getValue() + SOURCE.get(type));
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }
    //</editor-fold>

    //<editor-fold desc="2PI">
    @Test
    public void testTwoPiPoint() {
        PIType type = PIType.DOUBLE_PI;
        double value = type.getValue();
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testTwoPiPointAndDeltaPos() {
        PIType type = PIType.DOUBLE_PI;
        double value = type.getValue() + SOURCE.get(type);
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }

    @Test
    public void testTwoPiPointAndDeltaNeg() {
        PIType type = PIType.DOUBLE_PI;
        double value = -(type.getValue() + SOURCE.get(type));
        Assert.assertEquals(MathFuncs.cosStandard(value),
                MathFuncs.cos(value),
                DELTA);
    }
    //</editor-fold>
}
