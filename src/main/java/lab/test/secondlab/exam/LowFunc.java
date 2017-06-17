package lab.test.secondlab.exam;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class LowFunc {

    public static boolean isStubbed = false;
    public static final int STUBBED_SUM_VALUE = 2;
    public static final int STUBBED_MINUS_VALUE = -2;

    public static int sum(int x, int y) {
        return (isStubbed)
                ? 2
                : x + y;
    }

    public static int minus(int x, int y) {
        return (isStubbed)
                ? -2
                : x - y;
    }
}
