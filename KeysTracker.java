import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeysTracker implements KeyListener {


    private Snake snake;



    public KeysTracker(Snake snake) {
        this.snake = snake;
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (snake.getDirY() != -1) {
                snake.setDirY(1);
                snake.setDirX(0);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (snake.getDirY() != 1) {
                snake.setDirY(-1);
                snake.setDirX(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (snake.getDirX() != -1) {
                snake.setDirX(1);
                snake.setDirY(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (snake.getDirX() != 1) {
                snake.setDirX(-1);
                snake.setDirY(0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
