package lab.test.secondlab;

import lab.test.secondlab.formula.FirstFormula;
import lab.test.secondlab.formula.SecondFormula;
import lab.test.secondlab.formula.SuperFuncs;
import lab.test.secondlab.util.ReportManager;

/**
 * Compute!
 */
public class App {
    private static final double N = -1.5;
    private static final double M = 1.5;
    private static final double STEP = 0.3;

    public static void main( String[] args ) {

        if(args.length != 1)
            System.out.println( "Enter argument!" );
        else {
            double x;
            try {
                x = Double.valueOf(args[0]);
                System.out.println(SuperFuncs.calc(x));
            }
            catch (NumberFormatException e) {
                System.out.println("Not a double!");
            }
        }
        ReportManager.init("firstFormula");
        FirstFormula ff = new FirstFormula();
        SecondFormula sf = new SecondFormula();
        for (double i = N; i < 0; i += STEP)
            ReportManager.report(i, ff.calc(i));
        ReportManager.flush();

        ReportManager.init("secondFormula");
        for (double i = STEP; i < M; i += STEP)
            ReportManager.report(i, sf.calc(i));
        ReportManager.flush();

//        double x = PIType.PI_AND_HALF_NEG.getValue();
//
//        double t1 = Math.abs(x % PIType.HALF_PI_AND_HALF_NEG.getValue());
//        double t2 = Math.abs(x % PIType.PI_NEG.getValue());
//        double t3 = Math.abs(x % PIType.PI_AND_HALF_NEG.getValue());
//
//        System.out.println(t1 + " | " + t2 + " | " + t3);
    }
}
