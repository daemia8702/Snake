package Controller.BodyController;

import Controller.GamePanel;
import Model.Entity;

import java.util.List;


public class SnakeMoveDown implements Moving
{
    @Override
    public void move (List<Entity> snake)
    {
        int headY = snake.get(0).getPosY();
        int headX = snake.get(0).getPosX();

        Entity newHead = snake.remove(snake.size()-1);

        headY += GamePanel.DIMENSION;

        newHead.setPosX(headX);
        newHead.setPosY(headY);

        snake.add(0, newHead);
    }
}
