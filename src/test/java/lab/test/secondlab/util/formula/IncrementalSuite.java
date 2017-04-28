package lab.test.secondlab.util.formula;

import lab.test.secondlab.util.formula.first.TestFirstFormula;
import lab.test.secondlab.util.formula.second.TestSecondFormula;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by whobscr on 28.04.17.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FirstLevelTest.class,
        SecondLevelTest.class,
        TestFirstFormula.class,
        TestSecondFormula.class,
})
public class IncrementalSuite {
}
