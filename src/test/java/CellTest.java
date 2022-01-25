import game.Cell;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {

    @Test
    void isAlive_True_cellIsAlive() {
        Cell cell = new Cell(true);
        assertTrue(cell.isCellAlive());
    }
}
