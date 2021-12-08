package game;

import java.awt.*;

/**
 * The minus sign projectile for the Math tower.
 */
public class TowerMathEffectMinus extends Effect {
    private double position;

    public TowerMathEffectMinus(Point a, Enemy e, GameState state) {
        super(a, e, state);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("minus.png"), current.x-20, current.y-32, null);
    }
}
