package orchard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import orchard.model.Die;
import orchard.model.DieFace;

public class DieTest {

	@Test
    public void testInitialCurrentFace() {
        Die die = new Die();
        assertEquals(DieFace.RED, die.currentFace());
    }

    @Test
    public void testSetCurrentFace() {
        Die die = new Die();
        die.setCurrentFace(DieFace.BLUE);
        assertEquals(DieFace.BLUE, die.currentFace());
    }

    @Test
    public void testRollDie() {
        Die die = new Die();
        die.rollDie();
        DieFace rolledFace = die.currentFace();
        assertTrue(die.faces().contains(rolledFace));
    }
}
