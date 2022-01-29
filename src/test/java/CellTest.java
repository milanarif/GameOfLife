import game.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {

    @Test
    void should_beAlive_when_instantiatedAlive() {
        Cell cell = new Cell(true);
        assertTrue(cell.isCellAlive());
    }

    @Test
    void should_beDead_when_instantiatedDead() {
        Cell cell = new Cell(false);
        assertFalse(cell.isCellAlive());
    }

    @Test
    void should_haveZeroNeighbors_when_onlyOneCellCreated() {
        Cell cell = new Cell(true);
        assertEquals(0, cell.countLivingNeighbors());
    }
}
