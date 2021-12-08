package game;

import java.awt.Graphics;

/**
 * An interface containing the methods necessary for the GameControl class to call updateAll and drawAll for the
 * relevant objects.
 */
public interface Animatable
{
    /**
     * Updates for position, state (i.e Health of an enemy), etc
     * @param timeElapsed Time Elapsed since the start of the game
     */
    public void update(double timeElapsed);

    /**
     * Draws the object based off of the position.
     * @param g
     */
    public void draw(Graphics g);
}