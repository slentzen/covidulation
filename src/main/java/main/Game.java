package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen;
    private BufferedImage img;

    private double timePerFrame;
    private long lastFrame;



    public Game() {

        timePerFrame = 1000000000.0 / 60.0;
        importImg();

        setSize(640, 640); // each sprite is 32 pixels wide and 32 pixels tall with space for 20 tiles

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gameScreen = new GameScreen(img);
        add(gameScreen);
        setVisible(true); // must be last in constructor

    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loopGame() {
        while (true) {
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint(); // updates the screen
            } else {
                // we do nothing
            }
        }
    }


    public static void main(String[] args) {
        // TODO code application logic here

        Game game = new Game();
        game.loopGame();
    }
}
