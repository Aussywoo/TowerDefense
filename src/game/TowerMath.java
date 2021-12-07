package game;

import java.awt.*;

public class TowerMath extends Tower {
    GameState state;
    int x, y;
    int count = 0;
    Enemy nearest;
    Point pos;

    public TowerMath(GameState state, int x, int y) {
        super(state, x, y);
        this.state = state;
        this.x = x;
        this.y = y;
        pos = new Point(x, y);
        state.removeCredits(35);
    }

    public void update(double timeElapsed) {
        count++;
        if (count >= 5 && state.findNearestEnemy(pos) != null) {
            nearest = state.findNearestEnemy(pos);
            double rand = Math.random();
            if(rand < 0.33) {
                state.addGameObjectToAdd(new TowerMathEffect(pos, nearest, state));
            }
            else if(rand > 0.33 && rand < 0.66) {
                state.addGameObjectToAdd(new TowerMathEffect2(pos, nearest, state));
            }
            else {
                state.addGameObjectToAdd(new TowerMathEffect3(pos, nearest, state));
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
