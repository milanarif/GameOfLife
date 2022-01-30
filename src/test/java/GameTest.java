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
        Game newGame = Game.step(game);

        Assertions.assertFalse(Grid.cellAlive(newGame.grid(), 2,1));
    }

    @Test
    void should_createCellAndKeepPrevious_when_threeNeighborsInL() {
        Cell[][] initialState = new Cell[][] {
                {O, O, O, O},
                {O, X, X, O},
                {O, X, O, O},
                {O, O, O, O}
        };
        Grid grid = new Grid(initialState);
        Game game = new Game(grid);
        Game newGame = Game.step(game);

        Cell[][] newStateExpected = new Cell[][] {
                {O, O, O, O},
                {O, X, X, O},
                {O, X, X, O},
                {O, O, O, O}
        };
        Cell[][] newStateActual = newGame.grid().cells();

        Assertions.assertArrayEquals(newStateExpected, newStateActual);
    }


}
