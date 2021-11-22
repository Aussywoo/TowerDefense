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
    private int count = 1;

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

        //Add enemies
        count++;
        if (count == 30 || count == 60)
        {
            state.addGameObject(new Enemy1(0, state));
        }
        if (count == 90) {
            state.addGameObject(new Enemy2(0, state));
            count = 0;
        }

        //Update the game objects
        state.updateAll();

        //Draw the game objects
        view.repaint();

        //Consume Mouse Click
        state.consumeMouseClick();
    }
}
