package game;

import java.awt.*;

/**
 * The menu object for the math towers. Will create a moving object when clicked on if there are enough credits.
 */
public class TowerMathMenu extends Tower {
    GameState state;
    int x, y;

    public TowerMathMenu(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(double timeElapsed) {
        if (state.getMouseX() >= x && state.getMouseX() < x + 100 &&
                state.getMouseY() >= y && state.getMouseY() < y + 67 &&
                state.isMouseClicked() && !state.movingTowerExists() && state.getCredits() >= 35)
        {
            state.addGameObjectToAdd(new TowerMathMoving(state, state.getMouseX(), state.getMouseY()));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("math.jpeg"), x, y, null);
    }
}
