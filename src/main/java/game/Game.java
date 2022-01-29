package game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Grid grid;

    private static final int[][] NEIGHBORS = {
            {-1, -1}, {-1, 0}, {-1, +1},
            { 0, -1},          { 0, +1},
            {+1, -1}, {+1, 0}, {+1, +1}
    };

    public Game(Grid grid) {
        this.grid = grid;
    }

    boolean validPosition(int[] offset, int[] gridDimensions, int row, int col) {
        if (offset[0] + row >= 0 && offset[1] + col >= 0) {
            return offset[0]+row < gridDimensions[0] && offset[1]+col < gridDimensions[1];
        }
        return false;
    }

    public Grid step(Grid grid) {
        Cell[][] newCellGrid = new Cell[grid.getWidth()][grid.getHeight()];

        for (int row = 0; row < grid.getCells().length; row++) {
            for (int col = 0; col < grid.getCells()[row].length; col++) {
                newCellGrid[row][col] = determineCellFuture(grid, row, col);
            }
        }
        return new Grid(newCellGrid);
    }

    private Cell determineCellFuture(Grid grid, int row, int col) {
        int neighborCount = countNeighbors(grid, row, col);
        if (neighborCount >= 2 && neighborCount < 4) {
            return Cell.ALIVE;
        }
        else return Cell.DEAD;
    }

    public int countNeighbors(Grid grid, int row, int col) {
        int neighbors = 0;
        int [] gridDimensions = new int[] {grid.getWidth(), grid.getHeight()};
        for (int[] offset : NEIGHBORS) {
            if (validPosition(offset, gridDimensions, row, col) && grid.cellAlive(row+offset[0], col+offset[1])) {
                neighbors++;
            }
        }
        return neighbors;
    }
}
