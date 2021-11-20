package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState
{
    //Fields
    List<Animatable> gameObjects;
    boolean gameOver;
    int credits, score, lives;
    int mouseX, mouseY;

    public GameState()
    {
        gameObjects = new ArrayList<Animatable>();
    }

    public void addGameObject (Animatable a)
    {
        gameObjects.add(a);
    }

    public void removeGameObject (Animatable a) {
        gameObjects.remove(a);
    }

    public void updateAll()
    {
        for(Animatable a : gameObjects)
            a.update(0);
    }

    public void drawAll(Graphics g) {
        for(Animatable a : gameObjects)
            a.draw(g);
    }


}