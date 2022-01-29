package game;

import lombok.*;

@Getter
@Setter
public class Grid {
    private Cell[][] cells;


    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean cellAlive(int row, int col) {
        return cells[row][col] == Cell.ALIVE;
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

}



