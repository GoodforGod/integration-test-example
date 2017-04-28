package lab.test.secondlab.util.formula;

/*
 * Created by @GoodforGod on 28.04.2017.
 */

import lab.test.secondlab.formula.SuperFuncs;
import lab.test.secondlab.util.FirstStubSource;
import lab.test.secondlab.util.FormulaValue;
import lab.test.secondlab.util.PIType;
import lab.test.secondlab.util.ReportManager;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * Default Comment
 */
@RunWith(Parameterized.class)
public class TestIncrementalFirstFormula {

    private final static double DELTA = 3E-1;

    private static final FirstStubSource stubSource = new FirstStubSource();

    private PIType type;
    private FormulaValue formulaValue;
    private double expectedReported = 0;
    private double actualReported   = 0;
    private String testNameReported = "";

    public TestIncrementalFirstFormula(PIType type, FormulaValue value) {
        this.type = type;
        this.expectedReported = value.getResult();
        this.formulaValue = value;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { PIType.PI_AND_HALF_NEG,     new FormulaValue(-3.518583768, 0.69023) },
                { PIType.PI_NEG,              new FormulaValue(-2.41660973077, -1.78215869455722) },
                { PIType.HALF_PI_AND_HALF_NEG, new FormulaValue(-1.88495559, -2.84902) },
                { PIType.HALF_PI_NEG,         new FormulaValue(-1.04719755, 2.17543) },
                { PIType.ZERO,                new FormulaValue(0.95199777272 - Math.PI * 2, -2.2560182862465) }
        });
    }

    @BeforeClass
    public static void setup() {
        ReportManager.init("firstFormulaIncremental");
    }

    @Test
    public void formulaPiAndHalfToPiNeg() {
        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported, actualReported = SuperFuncs.calc(formulaValue.getX()), DELTA);
    }

    @Test
    public void boundaryPiAndHalfNeg() {
        testNameReported = Thread.currentThread().getStackTrace()[1].getMethodName();
        Assert.assertEquals(expectedReported, actualReported = SuperFuncs.calc(formulaValue.getX()), DELTA);
    }

//    // -P
//    @Test
//    public void boundaryPiNegDeltaPos() {
//        PIType type = PIType.PI_NEG;
//        double x = type.getValue() + SOURCE_BOUNDARY.get(type).getDelta();
//    }
//
//    @Test
//    public void boundaryPiNegDeltaNeg() {
//        PIType type = PIType.PI_NEG;
//        double x = type.getValue() - SOURCE_BOUNDARY.get(type).getDelta();
//    }
//
}
