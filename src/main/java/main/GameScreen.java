package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;

public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage img;
    private long lastTime;
    private int frames;



    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();

    public GameScreen(BufferedImage img) {

        this.img = img;
        loadSprites();
        random = new Random();



    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }



        callFPS();
    }

    private void callFPS() {
        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000) {
            System.out.println("FPS: " + frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }
    }

    private Color getRndColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private int getRndInt() {
        return random.nextInt(100);
    }

    private void loadSprites() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }


}
