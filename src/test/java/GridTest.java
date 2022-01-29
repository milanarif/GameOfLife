import game.Cell;
import game.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridTest {

    public static final boolean O = false;
    public static final boolean X = false;

    @Test
    void should_equalInitialState_when_initiated() {
        Grid grid = new Grid();

        boolean[][] initialState = new boolean[][] {
                {O, O, O, O},
                {O, X, X, O},
                {O, X, X, O},
                {O, O, O, O}
        };
        for(int row = 0; row < initialState.length; row++) {
            for(int col = 0; col < initialState[row].length; col++) {
                grid.setCellAtPosition(row, col, new Cell(initialState[row][col]));
            }
        }
        boolean[][] gridStatus = new boolean[initialState.length][initialState[0].length];
        for(int row = 0; row < initialState.length; row++) {
            for(int col = 0; col < initialState[row].length; col++) {
                gridStatus[row][col] = grid.getCellAtPosition(row, col).isCellAlive();
            }
        }
        Assertions.assertEquals(initialState, gridStatus);


    }
}
