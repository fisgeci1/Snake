import javax.swing.*;

public class Frame {
    private static JFrame f = null;

    public static void main(String[] args) {
        if (f == null) {
            JFrame frame = new JFrame("Snake");
            f = frame;
            Snake snake = new Snake(10);
            Painter panel = new Painter(500, 500, snake);
            frame.setSize(515, 540);
            frame.getContentPane().add(panel);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.addKeyListener(new KeysTracker(snake));
            frame.setVisible(true);
        } else {
            f.dispose();
            JFrame frame = new JFrame("Snake");
            Snake snake = new Snake(10);
            Painter panel = new Painter(500, 500, snake);
            frame.setSize(515, 540);
            frame.getContentPane().add(panel);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.addKeyListener(new KeysTracker(snake));
            frame.setVisible(true);

        }
    }
}
