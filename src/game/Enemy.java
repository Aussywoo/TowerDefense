package game;

import java.awt.*;

/**
 * Represents an object that will travel on the path. Contains lives, score, credits and will be removed when it has
 * been hit by a projectile a sufficient number of times.
 */
public abstract class Enemy implements Animatable {
    protected double position;
    protected Point p;
    protected GameState state;
    protected double speed;
    protected int currentHealth, health;

    /**
     * Creates an Enemy object at a given position, with a given speed and health.
     * @param position
     * @param state
     * @param speed
     * @param health
     */
    public Enemy(double position, GameState state, double speed, int health) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
        this.state = state;
        this.position = position;
        this.speed = speed;
        this.health = health;
        this.currentHealth = health;
    }

    public void removeHealth(int num) {
        currentHealth -= num;
    }

    public double getSpeed() {
        return speed;
    }

    public void update(double timeElapsed) {
        p = ResourceLoader.getLoader().getPath("path.txt").getPathPosition(position);
        position = position + speed;
        if(position > 1){
            position = 1;
            state.removeGameObject(this);
            state.setLives(state.getLives() - 1);
        }
        else if (currentHealth <= 0) {
            state.removeGameObject(this);
            state.addCredits(health);
            state.addScore(health);
        }
        if(state.getLives() == 0)
            state.endGame();
    }

    public Point getPos() {
        return p;
    }

    public double getPercentage() {
        return position;
    }

    @Override
    public String toString() {
        return "" + getPos();
    }
}
