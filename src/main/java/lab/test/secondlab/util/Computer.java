package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 13.04.2017.
 */

import java.util.Random;

/**
 * Common functions, like random double, and factorial and etc
 */
public class Computer {

    public static final double DELTA = 0.0005;

    public static double randomBetween(double from, double to) {
        return from + (to - from) * new Random().nextDouble();
    }

    public static long factorial(long value) {
        long result = 1;

        for(long i = 1; i <= value; i++)
            result *= i;

        return result;
    }
}
