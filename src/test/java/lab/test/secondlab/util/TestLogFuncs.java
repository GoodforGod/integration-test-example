package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 13.04.2017.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 */
public class TestLogFuncs {

    private final static double DELTA = 0.0005;

    private final static double FROM = 3;
    private final static double TO = 160;

    private final static double BASE_FROM = 2;
    private final static double BASE_TO = 10;

    @Test
    public void randomValueLnTest() {
        double value = Computer.randomBetween(FROM, TO);
        Assert.assertEquals(MathFuncs.ln(value), Math.log(value), DELTA);
    }

    @Test
    public void randomValueLogTest() {
        double value = Computer.randomBetween(FROM, TO);
        int base = (int)Computer.randomBetween(BASE_FROM, BASE_TO);
        Assert.assertEquals(MathFuncs.log(value, base), Math.log(value) / Math.log(base), DELTA);
    }
}
