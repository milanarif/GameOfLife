import game.Cell;
import game.Grid;
import game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    public static final Cell O = Cell.DEAD;
    public static final Cell X = Cell.ALIVE;

    @Test
    void should_killCellDueToUnderpopulation_when_onlyOneCell() {
        Cell[][] initialState = new Cell[][] {
                {O, O, O, O},
                {O, O, O, O},
                {O, X, O, O},
                {O, O, O, O}
        };
        Grid grid = new Grid(initialState);
        Game game = new Game(grid);
        game.setGrid(game.step(grid));

        Cell[][] finalState = new Cell[][] {
                {O, O, O, O},
                {O, O, O, O},
                {O, O, O, O},
                {O, O, O, O}
        };

        Assertions.assertFalse(game.getGrid().cellAlive(2,1));
    }


}
