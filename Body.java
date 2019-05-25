import java.awt.*;

public class Body extends Rectangle {

    private Color col;
    private int width, height;
    public int x, y;

    public Body(Color c, int width, int height, int x, int y) {
        col = c;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getXs() {
        return x;
    }

    public int getYs() {
        return y;
    }

    public int getWidths() {
        return width;
    }

    public int getHeights() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCol() {
        return col;
    }
}
