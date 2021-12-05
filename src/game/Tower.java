package game;

import java.awt.*;

public abstract class Tower implements Animatable {
    GameState state;
    int x, y;
    public Tower (GameState state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public Point getPos() {
        return new Point((int)x, (int)y);
    }

}
