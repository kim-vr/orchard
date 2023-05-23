package orchard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import orchard.model.Board;
import orchard.model.Fruit;
import orchard.model.Tree;

public class TreeTest {
	
	private Board board;
	
	@BeforeEach
    public void setUp() {
        board = new Board();
    }
	
	@Test
    public void testTreesInitialization() {
        List<Tree> trees = board.trees();
        assertEquals(4, trees.size());
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
}
