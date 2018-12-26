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
        posX = rand.nextInt(gamePanelWidth);
        posY = rand.nextInt(gamePanelHeight);

        posX -= posX % entityDimension;
        posY -= posY % entityDimension;
        //System.out.println("Generated xPos: " + posX);
        //System.out.println("Generated yPos: " + posY);
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
