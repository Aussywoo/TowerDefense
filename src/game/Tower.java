package game;

public abstract class Tower implements Animatable {
    GameState state;
    int x, y;
    public Tower (GameState state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

}
