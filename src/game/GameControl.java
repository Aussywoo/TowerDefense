/**
 * You will eventually need to add header comments to this file.
 */
package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControl implements Runnable, ActionListener {

    //Fields
    GameView view;
    GameState state;
    private double percentTraveled;

    public GameControl() {
        // I moved all the code into a function named 'run' below.
    }


    public void run() {

        // Build the game state.

        state = new GameState();
        state.addGameObject(new Backdrop());
        state.addGameObject(new BlueCircle(0, state));
        state.addGameObject(new BlueCircle(0.5, state));

        // Build a view.  Note that the view builds it's own frame, etc.  All the work is there.
        view = new GameView(state);

        // Start the animation loop.
        Timer timer = new Timer(16, this);
        timer.start();

    }

    /**
     * Called whenever an action event happens,
     * and we are listening to that event.
     * The timer automatically sets 'this' up as the listener above.
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //Animation 'loop' -- not an actual loop,
        //but we recognize that this function is called
        //Update the game objects

        state.updateAll();

        //Draw the game objects

        view.repaint();
    }
}
