package game;

import java.awt.*;

public class Enemy2 extends Enemy {

    public Enemy2 (double p, GameState state){
        super(p, state);
    }

    @Override
    public void draw(Graphics g) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
        g.drawImage(ResourceLoader.getLoader().getImage("Bryce.jpg"), p.x-20, p.y-26, null);
    }
}
