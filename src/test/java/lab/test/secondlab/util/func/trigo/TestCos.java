package lab.test.secondlab.util.func.trigo;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.func.MathFuncs;
import lab.test.secondlab.util.Computer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 */
public class TestCos {

    private final static double DELTA = 0.0005;

    private final static double MIN = 0;
    private final static double MAX = 1;

    @Test
    public void randomValueCosTest() {
        double value = Computer.randomDouble(MIN, MAX);
        Assert.assertEquals(Math.cos(value), MathFuncs.cos(value), DELTA);
    }

    // Generate & Set up
    public void generateValues() {

    }

    // 0


//    @Test
//    public void testZeroPoint() {
//        double value = 0;
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testZeroPointAndDeltaPos() {
//        double value = 0 + ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testZeroPointAndDeltaNeg() {
//        double value = 0 - ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    // PI/2
//
//    @Test
//    public void testHalfPiPoint() {
//        double value = Math.PI / 2;
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testHalfPiPointAndDeltaPos() {
//        double value = Math.PI / 2 + ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testHalfPiPointAndDeltaNeg() {
//        double value = Math.PI / 2 - ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    // PI
//
//    @Test
//    public void testPiPoint() {
//        double value = Math.PI;
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testPiPointAndDeltaPos() {
//        double value = Math.PI + ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testPiPointAndDeltaNeg() {
//        double value = Math.PI - ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    // 3PI/2
//
//    @Test
//    public void testPiAndAHalfPoint() {
//        double value = Math.PI + Math.PI / 2;
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testPiAndAHalfPointAndDeltaPos() {
//        double value = Math.PI + Math.PI / 2 + ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testPiAndAHalfPointAndDeltaNeg() {
//        double value = Math.PI + Math.PI / 2 - ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    // 2PI
//
//    @Test
//    public void testTwoPiPoint() {
//        double value = 2 * Math.PI;
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testTwoPiPointAndDeltaPos() {
//        double value = 2 * Math.PI + ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }
//
//    @Test
//    public void testTwoPiPointAndDeltaNeg() {
//        double value = 2 * Math.PI - ThreadLocalRandom.current().nextDouble(DELTA_BOUNDARY);
//
//        double result = AppCompute.computeCos(value);
//        double real = Math.cos(value);
//
//        assertEquals(result, real, DELTA_RESULT);
//    }

}
