package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String FILEPATH = "C://Github/GameOfLife/initialState.txt";


    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> lines = Files.readAllLines(Paths.get(FILEPATH));
        Game game = textToGameConverter(lines);

        while(true) {
            printGame(game);
            game = Game.step(game);
            Thread.sleep(3000);
        }
    }

    public static Game textToGameConverter(List<String> lines) {
        Cell[][] cells = new Cell[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '.') {
                    cells[i][j] = Cell.DEAD;
                }
                else if(chars[j] == '*'){
                    cells[i][j] = Cell.ALIVE;
                }
            }
        }
        return new Game(new Grid(cells));
    }

    private static void printGame(Game game) {

        for (Cell[] row : game.grid().cells()) {
            for (Cell cell : row){
                System.out.print(cell);
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

}
