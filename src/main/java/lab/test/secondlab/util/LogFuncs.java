package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class LogFuncs {

    public static final int STEP = 5;

    public static double log(int base, double x) {
        return log(x)/log(base);
    }

    public static double log(double x) {
        double result = 0;

        for(int i = 1; i <= STEP * 4; i += 2)
            result += (-Math.pow(-1, i) * Math.pow(-1 + x, i)) / i;

        return -result;
    }
}
