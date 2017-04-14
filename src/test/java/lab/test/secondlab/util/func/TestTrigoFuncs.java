package lab.test.secondlab.util.func;

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
public class TestTrigoFuncs {

    private final static double DELTA = 0.0005;

    private final static double MIN = 0;
    private final static double MAX = 1;

    @Test
    public void randomValueCosTest() {
        double value = Computer.randomBetween(MIN, MAX);
        Assert.assertEquals(MathFuncs.cos(value), Math.cos(value), DELTA);
    }

    @Test
    public void randomValueSinTest() {
        double value = Computer.randomBetween(MIN, MAX);
        Assert.assertEquals(MathFuncs.sin(value), Math.sin(value), DELTA);
    }

    @Test
    public void randomValueTanTest() {
        double value = Computer.randomBetween(MIN, MAX);
        Assert.assertEquals(MathFuncs.tan(value), Math.tan(value), DELTA);
    }


    @Test
    public void randomValueSecTest() {
        double value = Computer.randomBetween(MIN, MAX);
        Assert.assertEquals(MathFuncs.sec(value), 1.0/ Math.cos(value), DELTA);
    }

    @Test
    public void randomValueCscTest() {
        double value = Computer.randomBetween(MIN, MAX);
        Assert.assertEquals(MathFuncs.csc(value), 1.0 / Math.sin(value), DELTA);
    }
}
