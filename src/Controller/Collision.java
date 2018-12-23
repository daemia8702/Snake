package Controller;

import Model.Entity;

public class Collision
{

    private int width;
    private int height;

    public Collision (int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public boolean collectApple (Entity snake, Entity apple)
    {
        return snake.getPosX() == apple.getPosX() && snake.getPosY() == apple.getPosY();
    }

    public void collideWithWalls (SnakeController snake)
    {
        if (snake.getSnake().get(0).getPosX() < 0)
            snake.getSnake().get(0).setPosX(height);

        if (snake.getSnake().get(0).getPosX() > height)
            snake.getSnake().get(0).setPosX(0);

        if (snake.getSnake().get(0).getPosY() > width)
            snake.getSnake().get(0).setPosY(0);

        if (snake.getSnake().get(0).getPosY() < 0)
            snake.getSnake().get(0).setPosY(width);
    }
}
