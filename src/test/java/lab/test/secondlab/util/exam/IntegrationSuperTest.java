package lab.test.secondlab.util.exam;

import lab.test.secondlab.exam.LowFunc;
import lab.test.secondlab.exam.SuperFunc;
import org.junit.*;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class IntegrationSuperTest extends Assert {

    @Before
    public void setStubs() {
        SuperFunc.isStubbed = true;
        LowFunc.isStubbed = true;
    }

    @Test
    public void stubSuperTest() {
        assertEquals(SuperFunc.STUBBED_VALUE, SuperFunc.calc(2, 2));
    }

    @Test
    public void realSuperTest() {
        SuperFunc.isStubbed = false;
        assertEquals(-2, SuperFunc.calc(4, 2));
    }
}
