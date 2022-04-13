package main;

import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen;

    public Game() {

        setSize(640, 640); // each sprite is 32 pixels wide and 32 pixels tall with space for 20 tiles
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gameScreen = new GameScreen();
        add(gameScreen);

    }


    public static void main(String[] args) {
        // TODO code application logic here

        Game game = new Game();
    }
}
