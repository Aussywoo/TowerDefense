package game;

import java.awt.*;

public class Menu implements Animatable{

    private Point p;
    private GameState state;
    private boolean objectsAdded;

    public Menu (GameState state) {
        this.state = state;
        this.objectsAdded = false;
    }

    @Override
    public void update(double timeElapsed) {
        if(!objectsAdded) {
            state.addGameObjectToAdd(new TowerMathMenu(state, 700, 450));
            state.addGameObjectToAdd(new TowerScienceMenu(state, 800, 450));
            objectsAdded = true;
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Menu.png"), 600, 0, null);
        g.drawString("" + state.getScore(), 700, 300);
        g.drawString("" + state.getCredits(), 700, 200);
        g.drawString("" + state.getLives(), 700, 400);

    }
}
