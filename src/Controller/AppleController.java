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
    private int entityDimension;
    private int gamePanelWidth;
    private int gamePanelHeight;

    public AppleController (int gamePanelWidth, int gamePanelHeight, int entityDimension)
    {
        this.gamePanelWidth = gamePanelWidth;
        this.gamePanelHeight = gamePanelHeight;
        this.entityDimension = entityDimension;
        rand = new Random();
        randomCoordinate();
        apple = new Apple(posX, posY , entityDimension);
    }

    private void randomCoordinate ()
    {
        /*
            Random szám generálás 0 és (szélesség-dimenzió)/dimenzió között
         */

        posX = rand.nextInt((gamePanelWidth - entityDimension + 1 - entityDimension) + entityDimension) / entityDimension;
        posY = rand.nextInt((gamePanelHeight- entityDimension + 1 - entityDimension) + entityDimension) / entityDimension;

        posX *= entityDimension;
        posY *= entityDimension;
    }

    @Override
    public void draw (Graphics g)
    {
        drawing = new DrawApple(apple.getPosX(), apple.getPosY(), entityDimension);
        drawing.draw(g);
    }

    @Override
    public void update ()
    {
        randomCoordinate();
        apple.setPosY(this.posY);
        apple.setPosX(this.posX);
        apple.setDimension(entityDimension);
    }

    public Entity getApple ()
    {
        return this.apple;
    }
}
