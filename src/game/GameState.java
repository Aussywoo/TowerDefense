package game;

import java.util.ArrayList;
import java.util.List;

public class GameState
{

    List<Animatable> gameObjects;



    public GameState()
    {
        gameObjects = new ArrayList<Animatable>();
    }

    public void addGameObject (Animatable a)
    {
        gameObjects.add(a);
    }

    public void updateAll()
    {
        for(Animatable a : gameObjects)
            a.update(0);
    }


}