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
    public void testTreesInitialization() {
        List<Tree> trees = board.trees();
        assertEquals(4, trees.size());

        // Check if each tree has the correct associated fruit
        assertEquals(Fruit.CHERRY, trees.get(0).getAssociatedFruit());
        assertEquals(Fruit.PEAR, trees.get(1).getAssociatedFruit());
        assertEquals(Fruit.PLUM, trees.get(2).getAssociatedFruit());
        assertEquals(Fruit.APPLE, trees.get(3).getAssociatedFruit());
    }

    @Test
    public void testGetTree() {
        Tree tree = board.getTree(Fruit.PLUM);
        assertNotNull(tree);
        assertEquals(Fruit.PLUM, tree.getAssociatedFruit());
    }

    @Test
    public void testGetTree_InvalidFruit() {
        Tree tree = board.getTree(Fruit.CHERRY);
        assertNotNull(tree);
        assertNotEquals(Fruit.PEAR, tree.getAssociatedFruit());
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
        // Set all trees to be empty
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