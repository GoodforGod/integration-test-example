package lab.test.secondlab.func;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class LogFuncs {

    private final double ACCURACY;
    private final int MAX_STEPS = 300;
    public static boolean isStub = false;

    public LogFuncs(double accuracy) {
        ACCURACY = accuracy;
    }

    public double log(double x, int base) {
        if (isStub) {
            double ln = ln(x), lnb = Math.log(base);
            return ln / lnb;
        }

        return ln(x) / ln(base);
    }

    public double ln(double x) {
        if (isStub) {
            return  x == 0.5 ?
                    -0.693147 :
                    0;
        }

        double y = 0;
        double d = 1;
        double term = 0;

        int c = 0;
        if (x > 0) {
            for (int n = 0 ; d > ACCURACY && c < MAX_STEPS; n++) {
                d = y;

                term = 2.0 / (2.0 * n + 1) * Math.pow(((x - 1.0) / (x + 1.0)), 2 * n + 1);
                y += term;
                d = Math.abs(y - d);
                ++c;
            }
            return y;
        } else
            return Double.NaN;
    }
}
