package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState
{
    //Fields
    List<Animatable> gameObjects;
    List<Animatable> objectsToRemove;
    List<Animatable> objectsToAdd;
    private boolean gameOver, mouseClicked, movingTowerExists;
    private int credits, score, lives;
    private int mouseX, mouseY;

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

    public void addGameObject (Animatable a)
    {
        gameObjects.add(a);
    }

    public List<Animatable> getGameObjects() {
        return gameObjects;
    }

    public void addGameObjectToAdd(Animatable a) {
        objectsToAdd.add(a);
    }

    public void removeGameObject(Animatable a) {
        objectsToRemove.add(a);
    }

    public void setMouseLocation (int x, int y)
    {
        mouseX = x;
        mouseY = y;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY () {
        return mouseY;
    }

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public void consumeMouseClick() {
        mouseClicked = false;
    }

    public void setMouseClicked() {
        mouseClicked = true;
    }

    public void addScore(int num) {
        score += num;
    }

    public int getScore() {
        return score;
    }

    public void addCredits(int num) {
        credits += num;
    }

    public void removeCredits(int num) {
        credits -= num;
    }

    public int getCredits() {
        return credits;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void endGame() {
        gameOver = true;
    }

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

    public boolean movingTowerExists() {
        return movingTowerExists;
    }

    public void setMovingTowerExists(boolean a) {
        movingTowerExists = a;
    }

    public boolean isGameOver() {
        return gameOver;
    }

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