package game;

import java.awt.*;

public class TowerScience extends Tower {
    GameState state;
    int x, y;

    public TowerScience(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void update(double timeElapsed) {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Science.jpg"), x, y, null);
    }
}
