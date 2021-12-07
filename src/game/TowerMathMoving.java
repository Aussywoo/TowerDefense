package game;

import java.awt.*;
import java.util.List;

public class TowerMathMoving extends Tower {
    GameState state;
    int x, y;
    List<Animatable> gameObjects;

    public TowerMathMoving(GameState state, int x, int y) {
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
            state.addGameObjectToAdd(new TowerMath(state, state.getMouseX(), state.getMouseY()));
            state.removeGameObject(this);
            state.setMovingTowerExists(false);
        }
        else if (state.isMouseClicked()) {
            state.removeGameObject(this);
            state.setMovingTowerExists(false);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("math.jpeg"), state.getMouseX(), state.getMouseY(), null);
    }
}
