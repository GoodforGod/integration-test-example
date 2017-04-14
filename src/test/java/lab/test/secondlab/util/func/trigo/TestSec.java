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
public class TestSec {

    private final static double DELTA = 0.0005;

    private final static double MIN = 0;
    private final static double MAX = 1;

    @Test
    public void randomValueSecTest() {
        double value = Computer.randomDouble(MIN, MAX);
        Assert.assertEquals(1.0/ Math.cos(value), MathFuncs.sec(value), DELTA);
    }
}
