package game;

import java.awt.*;

public class TowerMathEffectDivide extends Effect {
    private double position;

    public TowerMathEffectDivide(Point a, Enemy e, GameState state) {
        super(a, e, state);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("divide.png"), current.x-20, current.y-32, null);
    }
}
