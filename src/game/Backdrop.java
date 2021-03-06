package game;

import java.awt.*;

/**
 * Uses the resource loader to obtain the backdrop (image of the path). Draws the path.
 */
public class Backdrop implements Animatable{

    private Point p;

    @Override
    public void update(double timeElapsed) {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("path_1.png"), 0, 0, null);

    }
}
