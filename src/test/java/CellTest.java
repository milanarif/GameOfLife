import game.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {

    @Test
    void isAlive_True_cellIsAlive() {
        Cell cell = new Cell(true);
        assertTrue(cell.isCellAlive());
    }

    @Test
    void isAlive_False_cellIsDead() {
        Cell cell = new Cell(false);
        assertFalse(cell.isCellAlive());
    }


}
