package orchard;

import orchard.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
	
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testAddARound() {
        int initialNumberOfRounds = board.numberOfRounds();
        board.addARound();
        assertEquals(initialNumberOfRounds + 1, board.numberOfRounds());
    }

    @Test
    public void testSetDie() {
        DieFace face = DieFace.BLUE;
        board.setDie(face);
        assertEquals(face, board.die().currentFace());
    }

    @Test
    public void testAllTreesEmpty_WithEmptyTrees() {
        for (Tree tree : board.trees()) {
        	while (tree.getNumberOfFruits() != 0) {
        		tree.pickAFruit();
        	}
        }
        assertTrue(board.allTreesEmpty());
    }

    @Test
    public void testAllTreesEmpty_WithNonEmptyTrees() {
        assertFalse(board.allTreesEmpty());
    }
}