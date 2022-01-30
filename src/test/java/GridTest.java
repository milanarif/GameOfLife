import game.Cell;
import game.Game;
import game.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridTest {

    public static final Cell O = Cell.DEAD;
    public static final Cell X = Cell.ALIVE;

    @Test
    void should_equalInitialState_when_initiated() {
        Cell[][] initialState = new Cell[][] {
                {O, O, O, O},
                {O, X, X, O},
                {O, X, X, O},
                {O, O, O, O}
        };
        Grid grid = new Grid(initialState);
        Assertions.assertEquals(initialState, grid.cells());
    }

    @Test
    void should_countThreeNeighbors_when_inCornerOfFullGrid() {
        Cell[][] initialState = new Cell[][] {
                {X, X, X, X},
                {X, X, X, X},
                {X, X, X, X},
                {X, X, X, X}
        };
        Grid grid = new Grid(initialState);
        Game game = new Game(grid);
        int neighbors = Game.countNeighbors(game, 0, 0);
        Assertions.assertEquals(3, neighbors);
    }

    @Test
    void should_beAlive_when_Alive() {
    Cell[][] initialState = new Cell[][] {
            {O, O, O, O},
            {O, O, O, O},
            {O, X, O, O},
            {O, O, O, O}
    };
    Grid grid = new Grid(initialState);
    Assertions.assertTrue(Grid.cellAlive(grid,2,1));
    }
}
