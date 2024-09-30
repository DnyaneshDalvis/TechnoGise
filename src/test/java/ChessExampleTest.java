import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ChessExampleTest {
    final String pawn = "Pawn";
    final String queen = "Queen";
    final String king = "King";

    final String position = "E4";
    int rowNum = 8 - Character.getNumericValue(position.charAt(1));
    int columnNum = position.charAt(0) - 'A';

    @Test
    void testCheckValidPosition() {
        assertTrue(ChessExample.checkPosition(rowNum, columnNum));
    }

    @Test
    void testCheckInValidRowPosition() {
        assertFalse(ChessExample.checkPosition(9, columnNum));
    }

    @Test
    void testCheckInValidColumnPosition() {
        assertFalse(ChessExample.checkPosition(rowNum, 9));
    }

    @Test
    void testGetPosition() {
        assertEquals("E4", ChessExample.getPosition(rowNum, columnNum));
    }

    @Test
    void getPossibleMovesOfPawn() {
        List<String> expected = List.of("E5");
        List<String> actual = ChessExample.getPossibleMoves(pawn, rowNum, columnNum);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void getPossibleMovesOfKing() {
        List<String> expected = List.of("D5", "E5", "F5", "D4", "F4", "D3", "E3", "F3");
        List<String> actual = ChessExample.getPossibleMoves(king, rowNum, columnNum);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void getPossibleMovesOfQueen() {
        List<String> expected = List.of("A4", "E8", "B4", "E7", "C4", "E6", "D4", "E5", "F4", "E3", "G4", "E2",
                "H4", "E1", "F3", "F5", "D3", "D5", "G2", "G6", "C2", "C6", "H1", "H7", "B1", "B7", "A8");
        List<String> actual = ChessExample.getPossibleMoves(queen, rowNum, columnNum);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }
}