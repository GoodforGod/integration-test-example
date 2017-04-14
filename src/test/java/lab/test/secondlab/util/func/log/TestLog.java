package lab.test.secondlab.util.func.log;

/*
 * Created by @GoodforGod on 13.04.2017.
 */

import lab.test.secondlab.func.MathFuncs;
import lab.test.secondlab.util.Computer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 */
public class TestLog {

    private final static double DELTA = 0.0005;

    private final static double MIN = 0.00001;
    private final static double MAX = 160;

    private final static double BASE_MIN = 2;
    private final static double BASE_MAX = 10;

    @Test
    public void randomValueLnTest() {
        double value = Computer.randomBetween(MIN, MAX);
        Assert.assertEquals(MathFuncs.ln(value), Math.log(value), DELTA);
    }

    @Test
    public void randomValueLogTest() {
        double value = Computer.randomBetween(MIN, MAX);
        int base = (int)Computer.randomBetween(BASE_MIN, BASE_MAX);
        Assert.assertEquals(MathFuncs.log(value, base), Math.log(value) / Math.log(base), DELTA);
    }
}
