package game;

import java.awt.*;

/**
 * An Enemy object that uses "Aus.jpg" with 5 health and slower speed.
 */
public class EnemyAus extends Enemy {

    public EnemyAus(double p, GameState state){
        super(p, state, 0.005, 5);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Aus.jpg"), p.x-20, p.y-32, null);
    }
}
