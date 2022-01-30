package game;


public class Main {

    public static final Cell O = Cell.DEAD;
    public static final Cell X = Cell.ALIVE;

    public static void main(String[] args) throws InterruptedException {
        Cell[][] initialState = new Cell[][] {
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, O, X, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, X, X, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O},
                {O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O}
        };

        Game game = new Game(new Grid(initialState));
        System.out.println(Grid.getColumns(game.grid()));
        System.out.println(Grid.getRows(game.grid()));

        while(true) {
            printGame(game);
            game = new Game(Game.step(game).grid());
            Thread.sleep(3000);

        }
    }

    private static void printGame(Game game) {
        System.out.println("\n\n\n");
        for (Cell[] row : game.grid().cells()) {
            for (Cell cell : row){
                System.out.print(cell + "\t");
            }
            System.out.println("\n");
        }
    }


}
