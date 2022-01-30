package game;

public record Grid(Cell[][] cells) {

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



