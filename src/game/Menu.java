package game;

import java.awt.*;

/**
 * Spawns on the right side of the screen and contains the menu tower objects as well as displays the score, lives
 * and credits.
 */
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
        g.drawImage(ResourceLoader.getLoader().getImage("menu.png"), 600, 0, null);
        g.drawString("Score: " + state.getScore(), 700, 300);
        g.drawString("Credits: " + state.getCredits(), 700, 200);
        g.drawString("Lives: " + state.getLives(), 700, 400);

    }
}
