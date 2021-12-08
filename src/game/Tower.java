package game;

import java.awt.*;

/**
 * Represents an object that will defend against enemies. Daughter classes will have unique features.
 */
public abstract class Tower implements Animatable {
    GameState state;
    int x, y;
    boolean isOnPath;
    public Tower (GameState state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    /**
     * Returns current position.
     * @return
     */
    public Point getPos() {
        return new Point((int)x, (int)y);
    }

    /**
     * Checks to see if the position of the object is on the path.
     * @return
     */
    public boolean isOnPath() {
        isOnPath = false;
        double count = 0;
        Point p;
        while (count <= 1) {
            p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(count);
            count += 0.05;
            if(p.distance(new Point((int)state.getMouseX(), (int)state.getMouseY())) < 40) {
                isOnPath = true;
            }
        }
        return isOnPath;
    }

}
