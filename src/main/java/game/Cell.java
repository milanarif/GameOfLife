package game;

public enum Cell {
    DEAD,
    ALIVE;

    @Override
    public String toString() {
        if (this.equals(DEAD)) {
            return ("O");
        }
        else {
            return "X";
        }
    }
}
