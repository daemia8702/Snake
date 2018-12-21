package Controller;

import Model.Apple;
import Model.Entity;
import View.DrawApple;
import View.Drawing;

import java.awt.*;
import java.util.Random;


public class AppleController implements GameController
{
    private Entity apple;
    private Drawing drawing;
    private int posX;
    private int posY;
    private Random rand;

    public AppleController ()
    {
        rand = new Random();
        randomCoordinate();
        apple = new Apple(posX, posY , GamePanel.DIMENSION);
    }

    private void randomCoordinate ()
    {
        posX = rand.nextInt(GamePanel.DIMENSION + 1 - 5) + 5;
        posY = rand.nextInt(GamePanel.DIMENSION + 1 - 5) + 5;

        posX *= GamePanel.DIMENSION;
        posY *= GamePanel.DIMENSION;
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
