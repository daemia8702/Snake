package Controller;

import Controller.BodyController.*;
import Model.*;
import View.DrawSnakeBody;
import View.DrawSnakeHead;
import View.Drawing;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Snake implements GameController
{
    private List<Entity> snake = new LinkedList<>();
    private Drawing drawing;
    private Moving moving = new DontMove();
    private Growing growing;

    public Snake ()
    {
        snake.add(new BodyPart(8 * GamePanel.DIMENSION, 8 * GamePanel.DIMENSION, GamePanel.DIMENSION));
    }

    public void snakeGrowing (boolean left, boolean right, boolean up, boolean down)
    {
        if (left)
        {
            growing = new GrowIfLeft();
            growing.grow(snake);
        }

        if (right)
        {
            growing = new GrowIfRight();
            growing.grow(snake);
        }

        if (up)
        {
            growing = new GrowIfUp();
            growing.grow(snake);
        }

        if (down)
        {
            growing = new GrowIfDown();
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
                drawing = new DrawSnakeHead(snake.get(0).getPosX(), snake.get(0).getPosY(), GamePanel.DIMENSION);
                drawing.draw(g);
            }
            else
            {
                drawing = new DrawSnakeBody(snake.get(i).getPosX(), snake.get(i).getPosY(), GamePanel.DIMENSION);
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
