package game;

import java.awt.*;

/**
 * Represents the projectile a tower outputs. Uses the timer to update and draw the position of the projectile.
 */
public abstract class Effect implements Animatable {
    protected Point start, end, current;
    protected Enemy e;
    double percentage, length;
    GameState state;
    protected int x1, y1, x2, y2;

    /**
     * Uses the getPathPosition method in ResourceLoader to create a path for the image of the effect to travel on.
     * @param a The starting position of the effect.
     * @param e The enemy targeted by the effect.
     * @param state The GameState
     */
    public Effect(Point a, Enemy e, GameState state){
        if(!(e.getPercentage() + e.getSpeed()*10 >= 1)) {
            this.state = state;
            percentage = 0;
            start = a;
            this.e = e;
            end = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(e.getPercentage() + e.getSpeed()*10);
            current = a;
            length = getSegLength(start, end);
        }
        else {
            this.state = state;
            percentage = 0;
            start = a;
            this.e = e;
            end = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(1);
            current = a;
            length = getSegLength(start, end);
        }
    }

    /**
     * Returns the length between two points. In this case, two points represents a segment.
     * @param a Starting point of the segment.
     * @param b Ending point of the segment.
     * @return a double value of the distance between the two given points.
     */
    public static double getSegLength(Point a, Point b) {
        double x1, y1, x2, y2;
        double length = 0;{

            x1 = a.getX();
            y1 = a.getY();
            x2 = b.getX();
            y2 = b.getY();

            length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        return length;
    }

    /**
     * Gives the correct coordinate point based off of a percentage traveled on the given path.
     * @param percentage The percentage value of the position on the path.
     * @return a Point that corresponds to the percentage position.
     */
    public Point getPathPosition(double percentage) {
        x1 = (int)start.getX();
        y1 = (int)start.getY();
        x2 = (int)end.getX();
        y2 = (int)end.getY();
        int finalX = (int)Math.round(x1 + (x2-x1)*percentage);
        int finalY = (int)Math.round(y1 + (y2-y1)*percentage);
        return new Point(finalX, finalY);
    }

    @Override
    public void update(double timeElapsed) {
        percentage = percentage + 0.1;
        current = getPathPosition(percentage);
        if(percentage > 1){
            percentage = 1;
            state.removeGameObject(this);
            e.removeHealth(1);
        }

    }
}
