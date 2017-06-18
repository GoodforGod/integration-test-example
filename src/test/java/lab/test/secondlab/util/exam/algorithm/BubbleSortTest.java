package lab.test.secondlab.util.exam.algorithm;

import lab.test.secondlab.exam.algorithm.BubbleSort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 18.06.2017
 */
@RunWith(Parameterized.class)
public class BubbleSortTest extends Assert {

    private int[] array;
    private int max;
    private int min;

    public BubbleSortTest(int[] array, int max, int min) {
        this.array = array;
        this.max = max;
        this.min = min;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{100, 10, 1},     100, 1},
                {new int[]{250, 1, 1, 249},      250, 1},
                {new int[]{1, 1, 1, 1, 1, 2, 1, 1},        2, 1},
                {new int[]{100, -10, 0, 10, 10},    100, -10},
                {new int[]{-100, -10, -1},  -1, -100}
        });
    }

    @Test
    public void testMax() {
        BubbleSort.sort(array);
        assertEquals(array[array.length - 1], max);
    }

    @Test
    public void testMin() {
        BubbleSort.sort(array);
        assertEquals(array[0], min);
    }
}
