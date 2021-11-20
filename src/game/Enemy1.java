package game;

import java.awt.*;

public class Enemy1 extends Enemy {

    private Point p;
    private GameState state;

    public Enemy1 (double p, GameState state){
        this.state = state;
        position = p;
    }

    @Override
    public void draw(Graphics g) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
        ResourceLoader.getLoader().getPath("path.txt").drawPath(g);
        g.drawImage(ResourceLoader.getLoader().getImage("Aus.jpg"), p.x-20, p.y-32, null);
    }
}
