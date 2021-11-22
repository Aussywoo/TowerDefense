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
    private boolean gameOver, mouseClicked;
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

    public int getScore() {
        return score;
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
    }


}