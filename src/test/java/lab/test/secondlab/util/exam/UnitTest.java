package lab.test.secondlab.util.exam;

import lab.test.secondlab.func.TrigoFuncs;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class UnitTest extends Assert {

    private final double delta = 0.005;

    @Test
    public void sinPosTest() {
        double result = Math.cos(0.5);
        assertEquals(0.87758256189, result, delta);
    }

    @Test
    public void sinNegTest() {
        double result = Math.cos(-0.5);
        assertEquals(-0.87758256189, result, delta);
    }

    @Test
    public void sinBoundaryTest() {
        double result = Math.cos(0);
        assertEquals(1, result, delta);
    }
}
