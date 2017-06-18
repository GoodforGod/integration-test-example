package lab.test.secondlab.exam.algorithm;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 18.06.2017
 */
public class BubbleSort {

    public static void sort(final int[] array) {
        final int n = array.length;

        for (int i = 0; i < n; i++)
            for (int j = 1; j < (n - i); j++)
                if (array[j - 1] > array[j])
                    swap(array, j - 1, j);
    }

    private static void swap(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
