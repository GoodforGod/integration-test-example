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
    public void randomValueLogTest() {
        double value = Computer.randomDouble(MIN, MAX);
        int base = (int)Computer.randomDouble(BASE_MIN, BASE_MAX);
        Assert.assertEquals(MathFuncs.logStandard(value, base), MathFuncs.log(value, base), DELTA);
    }
}
