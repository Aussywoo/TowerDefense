package game;

import java.awt.*;

public class Menu implements Animatable{

    private Point p;
    private GameState state;

    public Menu (GameState state) {
        this.state = state;
    }

    @Override
    public void update(double timeElapsed) {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Menu.png"), 600, 0, null);

    }
}
