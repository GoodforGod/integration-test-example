package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public class TrigoFuncs {

    private final static int STEP = 5;

    public static double sin(double x) {
        double result = 0;
        int mark = -1;

        for(int i = 1; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = mark == 1 ? -1 : 1);

        return result;
    }

    public static double cos(double x) {
        double result = 0;
        int mark = -1;

        for(int i = 0; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = mark == 1 ? -1 : 1);

        return result;
    }

    public static double ces(double x) {
        return 1/cos(x);
    }

    public static double tan(double x) {
        return sin(x)/cos(x);
    }

    public static double csc(double x) {
        return 1/sin(x);
    }
}
