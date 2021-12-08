package game;

import java.awt.*;

/**
 * The menu object for the science towers. Will create a moving object when clicked on if there are enough credits.
 */
public class TowerScienceMenu extends Tower {
    GameState state;
    int x, y;

    public TowerScienceMenu(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(double timeElapsed) {
        if (state.getMouseX() >= x && state.getMouseX() < x + 100 &&
                state.getMouseY() >= y && state.getMouseY() < y + 67 &&
                state.isMouseClicked() && !state.movingTowerExists() && state.getCredits() >= 15)
        {
            state.addGameObjectToAdd(new TowerScienceMoving(state, state.getMouseX(), state.getMouseY()));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Science.jpg"), x, y, null);
    }
}
