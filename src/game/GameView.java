/**
 * You will eventually need to add header comments to this file.
 */
package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created the jFrame panel for the game to exist in. Keeps track of mouse actions.
 */
public class GameView extends JPanel implements MouseListener, MouseMotionListener
{


    // This constant is needed to get rid of a warning.  It won't matter to us.

    private static final long serialVersionUID = 1L;

    ResourceLoader loader;
    GameState state;

    /**
     * Our GameView constructor.  The 'view' is the GUI (Graphical User Interface) and
     * this constructor builds a JFrame (window) so the user can see our 'drawing'.
     */
    public GameView (GameState state)
    {
        this.state = state;

        // Build the frame.  The frame object represents the application 'window'.

        JFrame frame = new JFrame ("Tower Defense 2021");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a drawing area to the frame (a panel).  Note that 'this' object IS the
        // panel that we need, so we add it.

        JPanel p = this;
        frame.setContentPane(p);

        // Set the size of 'this' panel to match the size of the backdrop.

        Dimension d = new Dimension(946, 600);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);

        // Allow the JFrame to layout the window (by 'packing' it) and make it visible.

        frame.pack();
        frame.setVisible(true);

        // This panel can send mouse events to any object that wants to 'listen' to those
        // events.  I've removed the lines of code for the mouse listener and timer,
        // feel free to re-add them as needed.

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /**
     * Draws our game.  This function will be called automatically when Java needs to
     * repaint our window.  Use the repaint() function call (on this object) to cause
     * this function to be executed.
     *
     * @param g  the Graphics object to use for drawing
     */
    public void paint (Graphics g)
    {
        state.drawAll(g);
        if(!state.firstClick)
            g.drawString("Click to Start", 468, 300);
    }

    /* The following methods are required for mouse events.  I've collapsed some of them to
     * make it easier to see which one you need.  Also note:  You'll need to register
     * 'this' object as a listener to its own events.  See the missing code in the
     * constructor.
     */

    /**
     * Tells the state object that the mouse has been clicked.
     * @param e
     */
    public void mousePressed(MouseEvent e)
    {
        state.setMouseClicked();
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {
        state.setMouseLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        state.setMouseLocation(e.getX(), e.getY());
    }
}
