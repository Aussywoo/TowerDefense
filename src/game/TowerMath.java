package game;

import java.awt.*;

/**
 * One of the two unique tower types. Shoots faster but has shorter range.
 */
public class TowerMath extends Tower {
    GameState state;
    int x, y;
    int count = 0;
    Enemy nearest;
    Point pos;

    /**
     * Places a math tower at a given position and removes 35 credits.
     * @param state
     * @param x
     * @param y
     */
    public TowerMath(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
        pos = new Point(x, y);
        state.removeCredits(35);
    }

    @Override
    public void update(double timeElapsed) {
        count++;
        nearest = state.findNearestEnemy(pos);
        if (count >= 5 && nearest != null && nearest.getPos().distance(this.getPos()) < 200) {
            double rand = Math.random();
            if(rand < 0.33) {
                state.addGameObjectToAdd(new TowerMathEffectMinus(pos, nearest, state));
            }
            else if(rand > 0.33 && rand < 0.66) {
                state.addGameObjectToAdd(new TowerMathEffectPlus(pos, nearest, state));
            }
            else {
                state.addGameObjectToAdd(new TowerMathEffectDivide(pos, nearest, state));
            }
            count = 0;
        }


    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ResourceLoader.getLoader().getImage("math.jpeg"), x, y, null);

        //Draw line to nearest enemy
//        if(state.findNearestEnemy(getPos()) != null) {
//            g.drawLine(x, y, (int)state.findNearestEnemy(getPos()).getPos().getX(), (int)state.findNearestEnemy(getPos()).getPos().getY());
//        }
    }
}
