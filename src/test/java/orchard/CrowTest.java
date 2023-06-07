package orchard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import orchard.model.Crow;
import orchard.model.Piece;
import java.util.List;

public class CrowTest {
    private Crow crow;

    @BeforeEach
    public void setUp() {
        crow = new Crow();
    }

    @Test
    public void testGetPuzzlePileList() {
        List<Piece> puzzlePileList = crow.getPuzzlePileList();
        Assertions.assertNotNull(puzzlePileList);
        Assertions.assertEquals(9, puzzlePileList.size());
    }

    @Test
    public void testGetPuzzleCrowList() {
        List<Piece> puzzleCrowList = crow.getPuzzleCrowList();
        Assertions.assertNotNull(puzzleCrowList);
        Assertions.assertEquals(0, puzzleCrowList.size());
    }

    @Test
    public void testAddAPiece() {
        Piece piece = new Piece(1, 2);
        crow.addAPiece(piece);

        List<Piece> puzzlePileList = crow.getPuzzlePileList();
        Assertions.assertFalse(puzzlePileList.contains(piece));

        List<Piece> puzzleCrowList = crow.getPuzzleCrowList();
        Assertions.assertFalse(puzzleCrowList.contains(piece));
    }

    @Test
    public void testInstanciatePuzzlePile() {
        crow.instanciatePuzzlePile();
        List<Piece> puzzlePileList = crow.getPuzzlePileList();
        Assertions.assertEquals(18, puzzlePileList.size());
    }

    @Test
    public void testPileIsEmpty() {
        Assertions.assertFalse(crow.pileIsEmpty());

        crow.getPuzzlePileList().clear();
        Assertions.assertTrue(crow.pileIsEmpty());
    }
}