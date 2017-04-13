package lab.test.secondlab.util.trigo;

/*
 * Created by @GoodforGod on 13.04.2017.
 */

import lab.test.secondlab.util.Computer;

/**
 * Default Comment
 */
public class CosFunc implements IFunc {

    public double calc(double x) {
        double result = 0;
        int mark = -1;

        for(int i = 0; i <= STEP * 4; i += 2)
            result += Math.pow(x, i) / Computer.factorial(i) * (mark = mark == 1 ? -1 : 1);

        return result;
    }
}
