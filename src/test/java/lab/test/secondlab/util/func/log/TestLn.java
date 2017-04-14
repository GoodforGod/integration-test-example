package lab.test.secondlab.util.func.log;

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
public class TestLn {
    private final static double DELTA = 0.0005;

    private final static double MIN = 0.00001;
    private final static double MAX = 160;

    @Test
    public void randomValueLnTest() {
        double x = Computer.randomDouble(MIN, MAX);
        Assert.assertEquals(MathFuncs.lnStandard(x), MathFuncs.ln(x), DELTA);
    }
}
