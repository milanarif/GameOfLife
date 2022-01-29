package game;

import lombok.*;

@Getter
@Setter
public class Grid {
    private Cell[][] cells;

    private static final int[][] NEIGHBORS = {
            {-1, -1}, {-1, 0}, {-1, +1},
            { 0, -1},          { 0, +1},
            {+1, -1}, {+1, 0}, {+1, +1}
    };

    boolean validPosition(int[] offset, int[] gridDimensions, int row, int col) {
        if (offset[0] + row >= 0 && offset[1] + col >= 0) {
            return offset[0]+row < gridDimensions[0] && offset[1]+col < gridDimensions[1];
        }
        return false;
    }

    public boolean cellAlive(int row, int col) {
        return cells[row][col] == Cell.ALIVE;
    }

    public int countNeighbors(int row, int col) {
        int neighbors = 0;
        int [] gridDimensions = new int[] {cells.length, cells[row].length};
        for (int[] offset : NEIGHBORS) {
            if (validPosition(offset, gridDimensions, row, col) && cellAlive(row+offset[0], col+offset[1])) {
                neighbors++;
            }
        }
        return neighbors;
    }

}



