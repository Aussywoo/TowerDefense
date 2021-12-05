package game;

import java.awt.*;

public class TowerEffect extends Effect {
    private double position;

    public TowerEffect(Point a, Enemy e, GameState state) {
        super(a, e, state);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Aus.jpg"), current.x-20, current.y-32, null);
    }
}
