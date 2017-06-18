package lab.test.secondlab.util.exam.unit;

import lab.test.secondlab.exam.unit.LowFunc;
import lab.test.secondlab.exam.unit.SuperFunc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class IntegrationLowTest extends Assert {

    @Before
    public void setStub() {
        LowFunc.isStubbed = true;
    }

    @Test
    public void sumStubTest() {
        assertEquals(LowFunc.STUBBED_SUM_VALUE, LowFunc.sum(1, 1));
    }

    @Test
    public void sumRealTest() {
        LowFunc.isStubbed = false;
        assertEquals(4, LowFunc.sum(2, 2));
    }

    @Test
    public void minusStubTest() {
        assertEquals(LowFunc.STUBBED_MINUS_VALUE, LowFunc.minus(2, 4));
    }

    @Test
    public void minusRealTest() {
        LowFunc.isStubbed = false;
        assertEquals(-4, LowFunc.minus(4, 8));
    }

    @Test
    public void stubLowTest() {
        SuperFunc.isStubbed = false;
        LowFunc.isStubbed = false;
        assertEquals(8, SuperFunc.calc(4, 2));
    }
}
