package lab.test.secondlab.func;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class LogFuncs {

    public final double ACCURACY = 0.001;
    private static boolean isStub = false;

    public double log(double x, int base) {
        if (isStub) { return logStub(x); }

        return ln(x) / ln(base);
    }

    public double ln(double x) {
        if (isStub) { return lnStub(x); }

        double y = 0;
        double d = 1;
        double term = 0;

        if (x > 0) {
            for (int n = 0 ; d > ACCURACY ; n++) {
                d = y;

                term = 2.0 / (2.0 * n + 1) * Math.pow(((x - 1.0) / (x + 1.0)), 2 * n + 1);
                y += term;
                d = Math.abs(y - d);
            }
            return y;
        } else
            return Double.NaN;
    }

    private double logStub(double x) {
        return 1;
    }

    private double lnStub(double x) {
        return 1;
    }
}
