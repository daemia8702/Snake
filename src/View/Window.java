package View;

import Controller.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * The class for creating the window frame, and adding the canvas to it
 */

public class Window extends JFrame
{
    GamePanel game = new GamePanel();

    public Window ()

    {
        super ("Snake");
    }

    /**
     * The method for creating the window, and adding the required elements for the game
     */

    public void createWindow ()
    {
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(game.getWIDTH(), game.getHEIGHT()));
        this.setMinimumSize(new Dimension(game.getWIDTH(), game.getHEIGHT()));
        this.setMaximumSize(new Dimension(game.getWIDTH(), game.getHEIGHT()));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(game);

        //Starting the GamePanel thread!
        game.start();
    }
}
