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
    public static boolean isStubBasic = false;

    private final int STEP = 5;

    public double sin(double x) {
        if (isStubBasic) return x == -0.5 ? -0.479426 : 0;

        double result = 0;
        int mark = -1;

        for(int i = 1; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = mark == 1 ? -1 : 1);

        return result;
    }

    public double cos(double x) {
        if (isStubBasic) return x == -0.5 ? 0.8775826 : 0;

        double result = 0;
        int mark = -1;

        for(int i = 0; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = (mark == 1) ? -1 : 1);

        return result;
    }

    public double sec(double x) {
        if (isStub) return x == -0.5 ? 1.139493877841 : 0;

        return 1/cos(x);
    }

    public double tan(double x) {
        if (isStub) return x == -0.5 ? -0.5463029918779155 : 0;

        return sin(x)/cos(x);
    }

    public double csc(double x) {
        if (isStub) return x == -0.5 ? -2.085827635547509 : 0;

        return 1/sin(x);
    }
}
