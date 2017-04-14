package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class LogFuncs {

    public final int STEP = 15;

    public double log(double x, int base) {
        return ln(x) / ln(base);
    }

    public double ln(double x) {
        double result = 0;

        for(int i = 1; i <= STEP; i += 1)
            result += Math.pow(-1, i) * Math.pow(x - 1, i) / i;

        return -result;
    }
}
