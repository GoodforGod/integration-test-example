package lab.test.secondlab.util.exam.domain;

import lab.test.secondlab.exam.domain.Man;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 18.06.2017
 */
public class ManTest extends Assert {

    private Man man;

    @Before
    public void initializeMan() {
        this.man = new Man();
    }

    @Test
    public void testManInChair() {
        man.sitOnChairInsideRoom();
        assertTrue(man.isLyingInArmchair());
    }

    @Test
    public void testManNotInChair() {
        assertFalse(man.isLyingInArmchair());
    }

    @Test
    public void testManLagsOnTableWhenInChair() {
        man.sitOnChairInsideRoom();
        assertTrue(man.isLagsOnTheTable());
    }

    @Test
    public void testManLagsNotOnTableWhenNotInChair() {
        assertFalse(man.isLagsOnTheTable());
    }
}
