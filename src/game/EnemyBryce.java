package game;

import java.awt.*;

/**
 * An Enemy object that uses "Bryce.jpg" with 3 health and faster speed.
 */
public class EnemyBryce extends Enemy {

    public EnemyBryce(double p, GameState state){
        super(p, state, 0.02, 3);
    }

    @Override
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
            state.addGameObjectToAdd(new EnemyBryceMinions(position -0.05, state));
            state.addGameObjectToAdd(new EnemyBryceMinions(position -0.1, state));
        }
        if(state.getLives() == 0)
            state.endGame();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Bryce.jpg"), p.x-20, p.y-26, null);
    }
}
