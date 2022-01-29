package game;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Cell {
    private boolean cellAlive;

    public int countLivingNeighbors() {
        return 0;
    }
}
