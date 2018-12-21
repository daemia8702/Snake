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
    private Snake snake;

    public KeyManager (Snake snake)
    {
        left = false;
        right = false;
        up = false;
        down = false;
        this.snake = snake;
    }

    public void keyPressed (KeyEvent e)
    {


        if (e.getKeyCode() == KeyEvent.VK_LEFT && !right)
        {
            left = true;
            snake.setMoving(new SnakeMoveLeft());

            up = false;
            down = false;
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left)
        {
            right = true;
            snake.setMoving(new SnakeMoveRight());

            left = false;
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP && !down)
        {
            up = true;
            snake.setMoving(new SnakeMoveUp());

            left = false;
            down = false;
            right = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && !up)
        {
            down = true;
            snake.setMoving(new SnakeMoveDown());

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
