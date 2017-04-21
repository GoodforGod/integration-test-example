package lab.test.secondlab;

import lab.test.secondlab.formula.SuperFuncs;

/**
 * Compute!
 */
public class App {
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

//        double x = PIType.PI_AND_HALF_NEG.getValue();
//
//        double t1 = Math.abs(x % PIType.HALF_PI_AND_HALF_NEG.getValue());
//        double t2 = Math.abs(x % PIType.PI_NEG.getValue());
//        double t3 = Math.abs(x % PIType.PI_AND_HALF_NEG.getValue());
//
//        System.out.println(t1 + " | " + t2 + " | " + t3);
    }
}
