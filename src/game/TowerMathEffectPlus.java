package game;

import java.awt.*;

/**
 * The division sign projectile for the Math tower.
 */
public class TowerMathEffectPlus extends Effect {
    private double position;

    public TowerMathEffectPlus(Point a, Enemy e, GameState state) {
        super(a, e, state);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("plus.png"), current.x-20, current.y-32, null);
    }
}
