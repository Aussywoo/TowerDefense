package game;

import java.awt.*;

public class Enemy2 extends Enemy {

    private Point p;
    private GameState state;

    public Enemy2 (double p, GameState state){
        this.state = state;
        position = p;
    }

    @Override
    public void draw(Graphics g) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
        g.drawImage(ResourceLoader.getLoader().getImage("Bryce.jpg"), p.x-20, p.y-26, null);
    }
}
