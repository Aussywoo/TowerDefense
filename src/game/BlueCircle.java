package game;

import java.awt.*;

public class BlueCircle implements Animatable {

    private double position;
    private Point p;
    private GameState state;

    public BlueCircle (double p, GameState state){
        this.state = state;
        position = p;
    }

    @Override
    public void update(double timeElapsed) {
        position = position + 0.002;
        if(position > 1){
            position = 0.0;
        }
    }

    @Override
    public void draw(Graphics g) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);

        g.setColor(Color.BLUE);
        g.fillOval(p.x-15, p.y-15, 30, 30);
    }
}
