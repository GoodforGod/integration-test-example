package lab.test.secondlab.util.exam.algorithm;

import lab.test.secondlab.exam.algorithm.BubbleSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 18.06.2017
 */
public class BubbleAlgorithmTest extends Assert {

    private int[] array;

    @Before
    public void initArray() {
        this.array = new int[] {3, 2, 1, 2, 3};
    }

    @Test
    public void testPosCondition() {
        BubbleSort.condition(array, 2);
        assertEquals(1, array[1]);
    }

    @Test
    public void testNegCondition() {
        int expected = array[3];
        BubbleSort.condition(array, 4);
        assertEquals(expected, array[3]);
    }
    @Test
    public void testSwap() {
        BubbleSort.swap(array, 1, 2);
        assertEquals(1, array[1]);
    }
}
