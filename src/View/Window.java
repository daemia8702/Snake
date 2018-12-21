package View;

import Controller.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    public Window ()
    {
        super ("Snake");
    }

    GamePanel game = new GamePanel();

    public void createWindow ()
    {
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        this.setMinimumSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        this.setMaximumSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(game);

        game.start();
    }
}
