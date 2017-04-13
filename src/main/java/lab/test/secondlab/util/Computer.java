package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 13.04.2017.
 */

import java.util.Random;

/**
 * Default Comment
 */
public class ComputeResolver {

    public static double getRandomBetween(double from, double to) {
        return from + (to - from) * new Random().nextDouble();
    }

    public static long computeFactorial(long value) {
        long result = 1;

        for(long i = 1; i <= value; i++)
            result *= i;

        return result;
    }
}
