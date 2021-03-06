package lab.test.secondlab.util.exam.unit;

import lab.test.secondlab.exam.unit.LowFunc;
import lab.test.secondlab.exam.unit.SuperFunc;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
@RunWith(Parameterized.class)
public class SumParamTest {

    private int x;
    private int y;
    private int result;

    public SumParamTest(int x, int y, int result) {
        this.x = x;
        this.y = y;
        this.result = result;
    }

    @BeforeClass
    public static void setNoStub() {
        SuperFunc.isStubbed = false;
        LowFunc.isStubbed = false;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100, 250, 350},
                {1, 2, 3},
                {0, 0, 0},
                {-1, -1, -2},
                {-300, -150, -450}
        });
    }

    @Test
    public void sumTest() {
        assertEquals(result, LowFunc.sum(x, y));
    }
}
