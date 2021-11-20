package game;

import java.awt.*;

public abstract class Effect implements Animatable {
    Point p;
    public Point getLocation() {

        return p;
    }
}
