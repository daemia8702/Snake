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
        /*
            Random szám generálás 0 és (szélesség-dimenzió)/dimenzió között
         */

        posX = rand.nextInt((GamePanel.WIDTH - GamePanel.DIMENSION + 1 - GamePanel.DIMENSION) + GamePanel.DIMENSION) / GamePanel.DIMENSION;
        posY = rand.nextInt((GamePanel.HEIGHT- GamePanel.DIMENSION + 1 - GamePanel.DIMENSION) + GamePanel.DIMENSION) / GamePanel.DIMENSION;

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
