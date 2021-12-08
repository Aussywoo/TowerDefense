package game;

import java.awt.*;

/**
 * One of the two unique tower types. Shoots faster but has shorter range.
 */
public class TowerScience extends Tower {
    GameState state;
    int x, y;
    int count = 0;
    Enemy nearest;
    Point pos;

    /**
     * Places a math tower at a given position and removes 15 credits.
     * @param state
     * @param x
     * @param y
     */
    public TowerScience(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
        pos = new Point(x, y);
        state.removeCredits(15);
    }

    public void update(double timeElapsed) {
        count++;
        nearest = state.findNearestEnemy(pos);
        if (count >= 5 && nearest != null && nearest.getPos().distance(this.getPos()) < 400) {
            nearest = state.findNearestEnemy(pos);
            state.addGameObjectToAdd(new TowerScienceEffect(pos, nearest, state));
            count = 0;
        }


    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("Science.jpg"), x, y, null);

        //Draw line to nearest enemy
//        if(state.findNearestEnemy(getPos()) != null) {
//            g.drawLine(x, y, (int)state.findNearestEnemy(getPos()).getPos().getX(), (int)state.findNearestEnemy(getPos()).getPos().getY());
//        }
    }
}
