package lab.test.secondlab.func;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class MathFuncs {

    private static final LogFuncs logFuncs = new LogFuncs();

    private static final TrigoFuncs trigoFuncs = new TrigoFuncs();

    public static double sin(double x) {
        return trigoFuncs.sin(x);
    }

    public static double cos(double x) {
        return trigoFuncs.cos(x);
    }

    public static double tan(double x) {
        return trigoFuncs.tan(x);
    }

    public static double sec(double x) {
        return trigoFuncs.sec(x);
    }

    public static double csc(double x) {
        return trigoFuncs.csc(x);
    }

    public static double log(double x, int base) {
        return logFuncs.log(x, base);
    }

    public static double ln(double x) {
        return logFuncs.ln(x);
    }

    public static double pow(double x, double power) {
        return Math.pow(x, power);
    }

}