package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 14.04.2017.
 */

/**
 * Default Comment
 */
public enum PIType {

    DOUBLE_PI_NEG(-2 * Math.PI),
    PI_AND_HALF_NEG(-Math.PI - Math.PI / 2),
    PI_NEG(-Math.PI),
    HALF_PI_AND_HALF_NEG(-4 * Math.PI / 3),
    HALF_PI_NEG(-Math.PI / 2),
    ZERO(0),
    HALF_PI(Math.PI / 2),
    PI(Math.PI),
    PI_AND_HALF(Math.PI + Math.PI / 2),
    DOUBLE_PI(2 * Math.PI);

    private double value;

    PIType(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
