package game;

import java.awt.*;

public class Enemy1 extends Enemy {



    public Enemy1 (double p, GameState state){
        super(p, state, 0.01);
    }

    @Override
    public void draw(Graphics g) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
        g.drawImage(ResourceLoader.getLoader().getImage("Aus.jpg"), p.x-20, p.y-32, null);
    }
}
