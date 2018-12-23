package Controller;

import Controller.BodyController.SnakeMoveDown;
import Controller.BodyController.SnakeMoveLeft;
import Controller.BodyController.SnakeMoveRight;
import Controller.BodyController.SnakeMoveUp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter
{
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private SnakeController snake;
    private int entityDimension;

    public KeyManager (SnakeController snake, int entityDimension)
    {
        left = false;
        right = false;
        up = false;
        down = false;
        this.snake = snake;
        this.entityDimension = entityDimension;
    }

    public void keyPressed (KeyEvent e)
    {


        if (e.getKeyCode() == KeyEvent.VK_LEFT && !right)
        {
            snake.setMoving(new SnakeMoveLeft(entityDimension));

            left = true;
            up = false;
            down = false;
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left)
        {
            snake.setMoving(new SnakeMoveRight(entityDimension));

            right = true;
            left = false;
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP && !down)
        {
            snake.setMoving(new SnakeMoveUp(entityDimension));

            up = true;
            left = false;
            down = false;
            right = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && !up)
        {
            snake.setMoving(new SnakeMoveDown(entityDimension));

            down = true;
            left = false;
            up = false;
            right = false;

        }
    }

    public boolean isLeft()
    {
        return left;
    }

    public boolean isRight()
    {
        return right;
    }

    public boolean isUp()
    {
        return up;
    }

    public boolean isDown()
    {
        return down;
    }
}
