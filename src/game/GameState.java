package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of all values relevant to the game. This includes player health, credits, score -- as well as mouse
 * actions and mouse positions.
 */
public class GameState
{
    //Fields
    List<Animatable> gameObjects;
    List<Animatable> objectsToRemove;
    List<Animatable> objectsToAdd;
    private boolean gameOver, mouseClicked, movingTowerExists;
    public boolean firstClick;
    private int credits, score, lives;
    private int mouseX, mouseY;

    /**
     * Contains all the initial values for the game to function. This includes lives, credits, and score.
     */
    public GameState()
    {
        //Give values to fields
        gameObjects = new ArrayList<Animatable>();
        objectsToRemove = new ArrayList<Animatable>();
        objectsToAdd = new ArrayList<Animatable>();

        gameOver = false;
        credits = 100;
        score = 0;
        lives = 10;
        mouseClicked = false;
        mouseX = mouseY = 0;
    }

    /**
     * Adds an Animatable object into the gameObjects list.
     * @param a The Animatable object to add.
     */
    public void addGameObject (Animatable a)
    {
        gameObjects.add(a);
    }

    /**
     * Returns the list containing all the game objects.
     * @return gameObjects list.
     */
    public List<Animatable> getGameObjects() {
        return gameObjects;
    }

    /**
     * Similar to addGameObject. However, avoids concurrent modification by adding the object after a full timer tick.
     * @param a The object to add.
     */
    public void addGameObjectToAdd(Animatable a) {
        objectsToAdd.add(a);
    }

    /**
     * Removes a given game object. Avoids concurrent modification by removing the object after a full timer tick.
     * @param a The object to remove.
     */
    public void removeGameObject(Animatable a) {
        objectsToRemove.add(a);
    }

    /**
     * Sets the value of the mouse location.
     * @param x the desired x position.
     * @param y the desired y position.
     */
    public void setMouseLocation (int x, int y)
    {
        mouseX = x;
        mouseY = y;
    }

    /**
     * Returns the x coordinate of the mouse position.
     * @return mouse position x coordinate.
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * Returns the y coordinate of the mouse position.
     * @return mouse position y coordinate.
     */
    public int getMouseY () {
        return mouseY;
    }

    /**
     * Returns whether the mouse is clicked or not.
     * @return
     */
    public boolean isMouseClicked() {

        return mouseClicked;
    }

    /**
     * Manually sets isMouseClicked to false. Useful for when a click and drag action is needed.
     */
    public void consumeMouseClick() {
        mouseClicked = false;
    }

    /**
     * Sets mouse clicked to true. Does a one time change on firstClick at the beginning to start the game.
     */
    public void setMouseClicked() {
        if(!firstClick) {
            firstClick = true;
        }
        mouseClicked = true;
    }

    /**
     * Adds a given integer to the current score value.
     * @param num The score to be added.
     */
    public void addScore(int num) {
        score += num;
    }

    /**
     * Returns the current value of the score.
     * @return Score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds a given integer to the current credits value.
     * @param num The credits to be added.
     */
    public void addCredits(int num) {
        credits += num;
    }

    /**
     * Removes a given integer to the current credits value.
     * @param num The credits to be removed.
     */
    public void removeCredits(int num) {
        credits -= num;
    }

    /**
     * Returns the current number of credits.
     * @return
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Returns the current number of lives.
     * @return
     */
    public int getLives() {
        return lives;
    }

    /**
     * Sets the number of lives.
     * @param lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Ends the game.
     */
    public void endGame() {
        gameOver = true;
    }

    /**
     * Given a point, this method will locate the nearest enemy by iterating through the gameObjects list, checking
     * if it's an enemy, and calculating distance.
     * @param p The point to find the nearest enemy to.
     * @return Enemy with shortest distance from the given point.
     */
    public Enemy findNearestEnemy(Point p) {
        Enemy closest = null;
        for(Animatable a : gameObjects) {
            if (a instanceof Enemy) {
                Enemy e = (Enemy) a;

                if (closest == null) {
                    closest = e;
                }
                else {
                    double currentDist = e.getPos().distance(p);
                    double currentClosest = closest.getPos().distance(p);

                    if(currentDist < currentClosest) {
                        closest = e;
                    }
                }
            }
        }
        return closest;
    }

    /**
     * Returns true of a moving tower exists.
     * @return
     */
    public boolean movingTowerExists() {
        return movingTowerExists;
    }

    /**
     * Is called after a moving tower is spawned (when a tower is clicked in the menu).
     * @param a
     */
    public void setMovingTowerExists(boolean a) {
        movingTowerExists = a;
    }

    /**
     * Returns true if the game is over.
     * @return
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Updates all objects in gameObjects unless game is over.
     */
    public void updateAll()
    {
        if(!isGameOver())
        {
            for(Animatable a : gameObjects)
                a.update(0);
        }
        //if game ends, put up "Game Over" and stop program
        else {
            //GameControl.endGame();
        }
    }

    /**
     * Adds and removes objects before drawing gameObjects.
     * @param g
     */
    public void drawAll(Graphics g) {
        for(Animatable a : objectsToRemove)
            gameObjects.remove(a);
        for(Animatable a : objectsToAdd)
        {
            gameObjects.add(a);
        }
        for(Animatable a : gameObjects)
            a.draw(g);
        objectsToAdd.clear();
        objectsToRemove.clear();
        if(isGameOver())
            GameControl.endGame(g);
    }


}