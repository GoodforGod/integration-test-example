package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 28.04.2017.
 */

import java.util.HashMap;

/**
 * Default Comment
 */
public class FirstStubSource {
    private final static double DELTA = 3E-5;

    public final HashMap<PIType, FormulaValue> SOURCE_BOUNDARY = new HashMap<>();
    public final HashMap<PIType, FormulaValue> SOURCE_INTERVAL = new HashMap<>();

    public FirstStubSource() {
        setupInterval();
        setupBoundary();
    }

    private void setupInterval() {
        SOURCE_INTERVAL.put(PIType.PI_AND_HALF_NEG,     new FormulaValue(-3.518583768, 0.69023));
        SOURCE_INTERVAL.put(PIType.PI_NEG,              new FormulaValue(-2.41660973077, -1.78215869455722));
        SOURCE_INTERVAL.put(PIType.HALF_PI_AND_HALF_NEG, new FormulaValue(-1.88495559, -2.84902));
        SOURCE_INTERVAL.put(PIType.HALF_PI_NEG,         new FormulaValue(-1.04719755, 2.17543));
        SOURCE_INTERVAL.put(PIType.ZERO,                new FormulaValue(0.95199777272 - Math.PI * 2, -2.2560182862465));
    }

    private void setupBoundary() {
        SOURCE_BOUNDARY.put(PIType.PI_AND_HALF_NEG,     new FormulaValue(PIType.PI_AND_HALF_NEG.getValue(), 0., DELTA));
        SOURCE_BOUNDARY.put(PIType.PI_NEG,              new FormulaValue(PIType.PI_NEG.getValue(), 0., DELTA));
        SOURCE_BOUNDARY.put(PIType.HALF_PI_AND_HALF_NEG, new FormulaValue(PIType.HALF_PI_AND_HALF_NEG.getValue(), 0., DELTA));
        SOURCE_BOUNDARY.put(PIType.HALF_PI_NEG,         new FormulaValue(PIType.HALF_PI_NEG.getValue(), 0., DELTA));
        SOURCE_BOUNDARY.put(PIType.ZERO,                new FormulaValue(PIType.ZERO.getValue(), 0., DELTA));
        SOURCE_BOUNDARY.put(PIType.HALF_PI,             new FormulaValue(PIType.HALF_PI.getValue(), 0., DELTA));
    }
}
