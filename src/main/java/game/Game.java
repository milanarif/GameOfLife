package game;

public record Game(Grid grid) {
    private static final int[][] NEIGHBORS = {
            {-1, -1}, {-1, 0}, {-1, +1},
            {0, -1}, {0, +1},
            {+1, -1}, {+1, 0}, {+1, +1}
    };

    static boolean validPosition(int[] offset, int[] gridDimensions, int row, int col) {
        if (offset[0] + row >= 0 && offset[1] + col >= 0) {
            return offset[0] + row < gridDimensions[0] && offset[1] + col < gridDimensions[1];
        }
        return false;
    }

    public static Game step(Game game) {
        Cell[][] newCellGrid = new Cell[Grid.getRows(game.grid())][Grid.getColumns(game.grid())];
        for (int row = 0; row < game.grid().cells().length; row++) {
            for (int col = 0; col < game.grid().cells()[row].length; col++) {
                newCellGrid[row][col] = determineCellFuture(game, row, col);
            }
        }
        return new Game(new Grid(newCellGrid));
    }

    public static Cell determineCellFuture(Game game, int row, int col) {
        int neighborCount = countNeighbors(game, row, col);
        Cell currentStatus = game.grid().cells()[row][col];

        if (neighborCount >= 2 && neighborCount < 4) {
            if (neighborCount == 3) {
                return Cell.ALIVE;
            } else return currentStatus;

        } else return Cell.DEAD;
    }

    public static int countNeighbors(Game game, int row, int col) {
        int neighbors = 0;

        int[] gridDimensions = new int[]{Grid.getRows(game.grid()), Grid.getColumns(game.grid())};

        for (int[] offset : NEIGHBORS) {
            if (validPosition(offset, gridDimensions, row, col) && Grid.cellAlive(game.grid(), row + offset[0], col + offset[1])) {
                neighbors++;
            }
        }
        return neighbors;
    }
}
