package game;

import java.awt.*;

public class TowerScienceEffect extends Effect {
    private double position;

    public TowerScienceEffect(Point a, Enemy e, GameState state) {
        super(a, e, state);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("flask.png"), current.x-20, current.y-32, null);
    }
}
