package lab.test.secondlab.util.exam.domain;

import lab.test.secondlab.exam.domain.Arthur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 18.06.2017
 */
public class ArthurTest extends Assert {

    private Arthur arthur;

    @Before
    public void initArthur() {
        this.arthur = new Arthur();
    }

    @Test
    public void nervousInRoom() {
        arthur.goInsideRoom();
        assertTrue(arthur.isNervous());
    }

    @Test
    public void notNervousOutsideRoom() {
        assertFalse(arthur.isNervous());
    }

    @Test
    public void stunnedInRoom() {
        arthur.goInsideRoom();
        assertTrue(arthur.isStunned());
    }

    @Test
    public void notStunnedOutsideRoom() {
        assertFalse(arthur.isStunned());
    }

    @Test
    public void seeManInRoom() {
        arthur.goInsideRoom();
        assertNotNull(arthur.getManOnChair());
    }

    @Test
    public void noManOutsideRoom() {
        assertNull(arthur.getManOnChair());
    }
}
