package lab.test.secondlab.util.exam.unit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class UnitTest extends Assert {

    private final double delta = 0.005;

    @Test
    public void cosPosTest() {
        assertEquals(1, Math.cos(0), delta);
    }

    @Test
    public void cosNegTest() {
        assertEquals(-1, Math.cos(Math.PI), delta);
    }

    @Test
    public void cosBoundaryTest() {
        assertEquals(0, Math.cos(Math.PI / 2), delta);
    }
}
