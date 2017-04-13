package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 13.04.2017.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 */
public class TestTrigoFuncs {

    private final static double DELTA = 0.0005;

    private final static double FROM = 0;
    private final static double TO = 1;

    @Test
    public void randomValueCosTest() {
        double value = Computer.randomBetween(FROM, TO);
        Assert.assertEquals(TrigoFuncs.cos(value), Math.cos(value), DELTA);
    }

    @Test
    public void randomValueSinTest() {
        double value = Computer.randomBetween(FROM, TO);
        Assert.assertEquals(TrigoFuncs.sin(value), Math.sin(value), DELTA);
    }

    @Test
    public void randomValueTanTest() {
        double value = Computer.randomBetween(FROM, TO);
        Assert.assertEquals(TrigoFuncs.tan(value), Math.tan(value), DELTA);
    }


    @Test
    public void randomValueSecTest() {
        double value = Computer.randomBetween(FROM, TO);
        Assert.assertEquals(TrigoFuncs.sec(value), 1.0/ Math.cos(value), DELTA);
    }

    @Test
    public void randomValueCscTest() {
        double value = Computer.randomBetween(FROM, TO);
        Assert.assertEquals(TrigoFuncs.csc(value), 1.0 / Math.sin(value), DELTA);
    }
}
