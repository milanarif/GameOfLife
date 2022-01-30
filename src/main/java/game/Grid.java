package game;

public record Grid(Cell[][] cells) {

    public static boolean cellAlive(Grid grid, int row, int col) {
        return grid.cells()[row][col] == Cell.ALIVE;
    }

    public static int getRows(Grid grid) {
        return grid.cells().length;
    }

    public static int getColumns(Grid grid) {
        return grid.cells()[0].length;
    }

}
