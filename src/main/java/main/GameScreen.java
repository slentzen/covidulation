package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GameScreen extends JPanel {

    private Random random;

    public GameScreen() {
        random = new Random();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        g.setColor(Color.red);

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                g.setColor(getRndColor());
                g.fillRect(x * 32, y * 32, 32, 32);
            }
        }
    }

    private Color getRndColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
