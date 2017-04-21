package lab.test.secondlab.func;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

import lab.test.secondlab.util.Computer;

/**
 * Default Comment
 */
public class TrigoFuncs {

    public static boolean isStub = false;

    private final int STEP = 5;

    public double sin(double x) {
        if (isStub) return 0.34;
        double result = 0;
        int mark = -1;

        for(int i = 1; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = mark == 1 ? -1 : 1);

        return result;
    }

    public double cos(double x) {
        if (isStub) return 0.47;
        double result = 0;
        int mark = -1;

        for(int i = 0; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = mark == 1 ? -1 : 1);

        return result;
    }

    public double sec(double x) {
        return 1/cos(x);
    }

    public double tan(double x) {
        return sin(x)/cos(x);
    }

    public double csc(double x) {
        return 1/sin(x);
    }
}
