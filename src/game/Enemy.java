package game;

public abstract class Enemy implements Animatable {
    protected double position;
    public Enemy() {

    }

    public void update(double timeElapsed) {
        position = position + 0.002;
        if(position > 1){
            position = 0.0;
        }
    }
}
