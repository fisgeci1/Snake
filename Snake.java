import java.awt.*;
import java.util.ArrayList;

public class Snake {

    private ArrayList<Body> snake;
    private int dirX = 1;
    private int dirY = 0;

    //creates Snake of given length
    public Snake(int length) {

        snake = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            snake.add(new Body(Color.green, 10, 10, 150 - (i * 5), 10));
        }
    }

    public int getDirX() {
        return dirX;
    }

    public int getDirY() {
        return dirY;
    }

    public void setDirX(int dirX) {
        this.dirX = dirX;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }

    public ArrayList<Body> getSnake() {
        return snake;
    }
}
