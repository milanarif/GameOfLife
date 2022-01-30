import game.Cell;
import game.Game;
import game.Grid;
import game.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MainTest {

    public static final Cell O = Cell.DEAD;
    public static final Cell X = Cell.ALIVE;

    @Test
    void should_matchInputStringBoard_when_convertedToGame() {
        List<String> input = Arrays.asList("......","...*..","...*..","...*..","......");
        Game game = Main.textToGameConverter(input);

        Cell[][] expectedState = new Cell[][] {
                {O, O, O, O, O, O},
                {O, O, O, X, O, O},
                {O, O, O, X, O, O},
                {O, O, O, X, O, O},
                {O, O, O, O, O, O}
        };

        Assertions.assertArrayEquals(expectedState, game.grid().cells());
    }
}
