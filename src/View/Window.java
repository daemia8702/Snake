package View;

import Controller.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    GamePanel game = new GamePanel();

    public Window ()
    {
        super ("Snake");
    }

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

        game.start();
    }
}
