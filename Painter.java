import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Painter extends JPanel {

    private Snake snake;
    private ArrayList<Body> snakeLi;
    private int width, height, foodW, bodyW;
    private Body food;
    private int speed = 20;
    private boolean lost;

    public Painter(int width, int height, Snake snake) {

        this.setSize(width, height);
        this.width = width;
        this.height = height;
        this.snake = snake;

        snakeLi = snake.getSnake();
        food = new Body(Color.red, 10, 10, (int) (Math.random() * width), (int) (Math.random() * height));
        foodW = food.getWidths();
        bodyW = snake.getSnake().get(0).getWidths();

        addKeyListener(new KeysTracker(snake));
    }

    public void paintComponent(Graphics g) {

        if (!lost) {
            g.clearRect(0, 0, width, height);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);

            g.setColor(snakeLi.get(0).getCol());


            moveSnake();
            drawSnake(g);
            g.setColor(food.getCol());
            g.fillRect(food.getXs(), food.getYs(), foodW, foodW);


            sleep(speed);
            repaint();
        } else {
            snake = new Snake(10);
            snakeLi = snake.getSnake();
            lost = false;
            Frame.main(new String[]{});
        }
    }

    private void moveSnake() {
        ArrayList<Body> copy = new ArrayList<>();

        for (int i = 0; i < snakeLi.size(); i++) {
            copy.add(i, snakeLi.get(i));
        }
        snake.getSnake().set(0, new Body(Color.green, bodyW, bodyW, snakeLi.get(0).getXs() + snake.getDirX() * bodyW, snakeLi.get(0).getYs() + snake.getDirY() * bodyW));
        for (int i = 1; i < snake.getSnake().size(); i++) {
            snake.getSnake().set(i, new Body(Color.green, bodyW, bodyW, copy.get(i - 1).getXs(), copy.get(i - 1).getYs()));
        }

        checkFood();
        Body head = snake.getSnake().get(0);

        checkIfLost(head);

        if (head.getXs() < 0) {
            head.setX(width - 6);
        } else if (head.getXs() > width - 5) {
            head.setX(0);
        }
        if (head.getYs() < 0) {
            head.setY(height - 4);
        } else if (head.getYs() > height - 5) {
            head.setY(0);
        }
    }

    private void drawSnake(Graphics g) {
        for (Body bodyParts : snakeLi) {
            g.setColor(bodyParts.getCol());
            g.fillRect(bodyParts.x, bodyParts.y, bodyW, bodyW);
            g.setColor(Color.BLACK);
            g.drawRect(bodyParts.x, bodyParts.y, bodyW, bodyW);
        }
    }

    private void checkIfLost(Body head) {

        Rectangle h = new Rectangle(head.x, head.y, bodyW, bodyW);
        for (int i = 1; i < snakeLi.size(); i++) {
            Rectangle body = new Rectangle(snakeLi.get(i).x, snakeLi.get(i).y, bodyW, bodyW);
            if (h.intersects(body)) {
                System.out.println("Lost");
                lost = true;
            }
        }
    }

    private void checkFood() {
        Rectangle head = new Rectangle(snake.getSnake().get(0).x, snake.getSnake().get(0).y, bodyW, bodyW);
        Rectangle f = new Rectangle(food.x, food.y, foodW, foodW);

        if (head.intersects(f)) {
            food.x = (int) (Math.random() * width);
            Body end = snake.getSnake().get(snake.getSnake().size() - 1);
            snake.getSnake().add(new Body(Color.green, bodyW, bodyW, end.x + bodyW * snake.getDirX(), end.y + bodyW * snake.getDirY()));
            food.x = (int) (Math.random() * width);
            food.y = (int) (Math.random() * height);
        } else {
        }
    }

    private void sleep(int delay) {
        try {
            new Thread().sleep(delay);
        } catch (Exception e) {

        }
    }
}
