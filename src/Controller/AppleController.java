package Controller;

import Model.Apple;
import Model.Entity;
import View.DrawApple;
import View.Drawing;

import java.awt.*;


public class AppleController implements GameController
{
    private Entity apple;
    private Drawing drawing;
    private int posX;
    private int posY;

    public AppleController ()
    {
        apple = new Apple(10 * GamePanel.DIMENSION, 10 * GamePanel.DIMENSION, GamePanel.DIMENSION);
    }

    private void randomCoordinate ()
    {
        posX = (int) (Math.random() * ((GamePanel.WIDTH - GamePanel.DIMENSION) / GamePanel.DIMENSION));
        posY = (int) (Math.random() * ((GamePanel.HEIGHT - GamePanel.DIMENSION) /GamePanel.DIMENSION));
    }

    @Override
    public void draw (Graphics g)
    {
        drawing = new DrawApple(apple.getPosX(), apple.getPosY(), GamePanel.DIMENSION);
        drawing.draw(g);
    }

    @Override
    public void update ()
    {
        randomCoordinate();
        apple.setPosY(this.posY);
        apple.setPosX(this.posX);
        apple.setDimension(GamePanel.DIMENSION);
    }

    public Entity getApple ()
    {
        return this.apple;
    }
}
