package game;

import java.awt.*;

public abstract class Enemy implements Animatable {
    protected double position;
    protected Point p;
    protected GameState state;

    public Enemy(double p, GameState state) {
        this.state = state;
        position = p;
    }

    public void update(double timeElapsed) {
        position = position + 0.01;
        if(position > 1){
            position = 1;
            state.removeGameObject(this);
            state.setLives(state.getLives() - 1);
        }
        if(state.getLives() == 0)
            state.endGame();
    }
}
