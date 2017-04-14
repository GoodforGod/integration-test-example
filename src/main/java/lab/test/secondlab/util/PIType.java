package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public enum PIType {

    ZERO(0),
    HALF_PI(Math.PI / 2),
    PI(Math.PI),
    PI_AND_HALF(Math.PI + Math.PI / 2),
    DOUBLE_PI(Math.PI * 2);

    private double value;

    PIType(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
