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

    //<editor-fold desc="Custom Math">

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
    //</editor-fold>


    //<editor-fold desc="Standard">

    public static double sinStandard(double x) {
        return Math.sin(x);
    }

    public static double cosStandard(double x) {
        return Math.cos(x);
    }

    public static double tanStandard(double x) {
        return Math.tan(x);
    }

    public static double secStandard(double x) {
        return 1.0/ Math.cos(x);
    }

    public static double cscStandard(double x) {
        return 1.0 / Math.sin(x);
    }

    public static double logStandard(double x, int base) {
        return Math.log(x) / Math.log(base); //logFuncs.log(x, base);
    }

    public static double lnStandard(double x) {
        return Math.log(x);
    }

    public static double powStandard(double x, double power) {
        return Math.pow(x, power);
    }
    //</editor-fold>
}
