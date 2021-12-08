package game;

import java.awt.*;

/**
 * Created after the menu science tower is clicked on. Will create a science tower if placed in a valid spot. Otherwise,
 * clicking while this object exists will simply remove it.
 */
public class TowerScienceMoving extends Tower {
    GameState state;
    int x, y;

    public TowerScienceMoving(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
        state.consumeMouseClick();
        state.setMovingTowerExists(true);
    }

    public void update(double timeElapsed) {
        if (state.getMouseX() >= 0 && state.getMouseX() < 600 &&
                state.getMouseY() >= 0 && state.getMouseY() < 600 &&
                state.isMouseClicked() && !isOnPath())
        {
            System.out.println(isOnPath());
            state.addGameObjectToAdd(new TowerScience(state, state.getMouseX(), state.getMouseY()));
            state.removeGameObject(this);
            state.setMovingTowerExists(false);
        }
        else if (state.isMouseClicked()){
            state.removeGameObject(this);
            state.setMovingTowerExists(false);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Science.jpg"), state.getMouseX(), state.getMouseY(), null);
    }
}
