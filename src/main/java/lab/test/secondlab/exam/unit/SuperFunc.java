package lab.test.secondlab.exam.unit;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class SuperFunc {

    public static boolean isStubbed = false;
    public static final int STUBBED_VALUE = 4;

    public static int calc(int x, int y) {
        return (isStubbed)
                ? STUBBED_VALUE
                : LowFunc.minus(LowFunc.sum(LowFunc.sum(x, y), x), y);
    }
}
