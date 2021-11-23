package game;

import java.awt.*;

public abstract class Enemy implements Animatable {
    protected double position;
    protected Point p;
    protected GameState state;
    protected double speed;

    public Enemy(double p, GameState state, double speed) {
        this.state = state;
        position = p;
        this.speed = speed;
    }

    public void update(double timeElapsed) {
        position = position + speed;
        if(position > 1){
            position = 1;
            state.removeGameObject(this);
            state.setLives(state.getLives() - 1);
        }
        if(state.getLives() == 0)
            state.endGame();
    }
}
