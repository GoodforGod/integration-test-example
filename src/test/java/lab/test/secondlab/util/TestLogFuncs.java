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

    private final static double FROM = 1;
    private final static double TO = 22;

    @Test
    public void randomValueCscTest() {
        double value = Computer.randomBetween(FROM, TO);
        int base = (int)Computer.randomBetween(2, 8);
        Assert.assertEquals(LogFuncs.log(base, value), Math.log(value) / Math.log(base), DELTA);
    }
}
