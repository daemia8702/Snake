package Controller;

import Model.Entity;

public class Collision
{
    public boolean collectApple (Entity snake, Entity apple)
    {
        return snake.getPosX() == apple.getPosX() && snake.getPosY() == apple.getPosY();
    }

    public void collideWithWalls (Snake snake)
    {
        if (snake.getSnake().get(0).getPosX() < 0)
            snake.getSnake().get(0).setPosX(GamePanel.HEIGHT);

        if (snake.getSnake().get(0).getPosX() > GamePanel.HEIGHT)
            snake.getSnake().get(0).setPosX(0);

        if (snake.getSnake().get(0).getPosY() > GamePanel.WIDTH)
            snake.getSnake().get(0).setPosY(0);

        if (snake.getSnake().get(0).getPosY() < 0)
            snake.getSnake().get(0).setPosY(GamePanel.WIDTH);
    }
}
