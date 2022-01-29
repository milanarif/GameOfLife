package game;

import lombok.*;

@Getter
@Setter
public class Grid {
    private Cell[][] cells;

    public void setCellAtPosition(int row, int col, Cell cell) {
        this.cells[row][col] = cell;
    }

    public Cell getCellAtPosition(int row, int col) {
        return cells[row][col];
    }
}

