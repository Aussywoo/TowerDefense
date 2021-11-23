package game;

import java.awt.*;

public class TowerMovingScience extends Tower {
    GameState state;
    int x, y;

    public TowerMovingScience(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void update(double timeElapsed) {
        if (state.getMouseX() >= 0 && state.getMouseX() < 600 &&
                state.getMouseY() >= 0 && state.getMouseY() < 600 &&
                state.isMouseClicked())
        {
            state.addGameObjectToAdd(new TowerScience(state, state.getMouseX(), state.getMouseY()));
            state.removeGameObject(this);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Science.jpg"), state.getMouseX(), state.getMouseY(), null);
    }
}
