/**
 * You will eventually need to add header comments to this file.
 */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControl implements Runnable, ActionListener {

    //Fields
    GameView view;
    static GameState state;
    private int count = 1;
    private double count2 = 1;
    private static Timer timer;
    boolean t = true;

    public GameControl() {
        // I moved all the code into a function named 'run' below.
    }


    public void run() {

        // Build the game state.

        state = new GameState();
        state.addGameObject(new Backdrop());

        //Add a Menu

        state.addGameObject(new Menu(state));

        // Build a view.  Note that the view builds it's own frame, etc.  All the work is there.
        view = new GameView(state);
        timer = new Timer(16, this);
        timer.start();
    }

    public void start() {
        // Start the animation loop after click.
        timer.start();
    }

    /**
     * Called whenever an action event happens,
     * and we are listening to that event.
     * The timer automatically sets 'this' up as the listener above.
     * @param e
     */
    public void actionPerformed(ActionEvent e) {

        //Add enemies
        if(state.firstClick) {
            count++;
        }

        if(count2 < 29) {
            count2+=0.05;
        }
        if (count == 30-((int)Math.floor(count2)) || count == 60-((int)Math.floor(count2)))
        {
            state.addGameObject(new Enemy1(0, state));
        }
        if (count == 90-((int)Math.floor(count2))) {
            state.addGameObject(new Enemy2(0, state));
            count = 0;
        }

        //For testing purposes, add only one enemy
//        if(t) {
//            state.addGameObject(new Enemy1(0, state));
//            t = false;
//        }



        //Update the game objects
        if(state.firstClick)
            state.updateAll();

        //Draw the game objects
        view.repaint();

        //Consume Mouse Click
        state.consumeMouseClick();
    }

    public static void endGame(Graphics g) {
        g.setColor(Color.GREEN);
        timer.stop();
        g.drawString("Game Over", 100, 100);
    }
}
