package Controller;

import Controller.BodyController.*;
import Model.*;
import View.DrawSnakeBody;
import View.DrawSnakeHead;
import View.Drawing;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SnakeController implements GameController
{
    private final int STARTING_X = 8;
    private final int STARTING_Y = 8;

    private List<Entity> snake = new LinkedList<>();
    private Drawing drawing;
    private Moving moving = new DontMove();
    private Growing growing;
    private int entityDimension;

    public SnakeController (int entityDimension)
    {
        this.entityDimension = entityDimension;
        snake.add(new BodyPart(STARTING_X * entityDimension, STARTING_Y * entityDimension, entityDimension));
    }

    public void snakeGrowing (boolean left, boolean right, boolean up, boolean down)
    {
        if (left)
        {
            growing = new GrowIfLeft(entityDimension);
            growing.grow(snake);
        }

        if (right)
        {
            growing = new GrowIfRight(entityDimension);
            growing.grow(snake);
        }

        if (up)
        {
            growing = new GrowIfUp(entityDimension);
            growing.grow(snake);
        }

        if (down)
        {
            growing = new GrowIfDown(entityDimension);
            growing.grow(snake);
        }
    }

    @Override
    public void draw(Graphics g)
    {
        for (int i = 0; i < snake.size(); i++)
        {
            if (i == 0)
            {
                drawing = new DrawSnakeHead(snake.get(0).getPosX(), snake.get(0).getPosY(), entityDimension);
                drawing.draw(g);
            }
            else
            {
                drawing = new DrawSnakeBody(snake.get(i).getPosX(), snake.get(i).getPosY(), entityDimension);
                drawing.draw(g);
            }
        }
    }

    @Override
    public void update()
    {
        this.moving.move(snake);
    }

    public void setMoving (Moving moving)
    {
        this.moving = moving;
    }

    public List<Entity> getSnake ()
    {
        return this.snake;
    }
}
