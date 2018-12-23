package Controller.BodyController;

import Model.Entity;

import java.util.List;


public class SnakeMoveLeft implements Moving
{

    private int entityDimension;

    public SnakeMoveLeft (int entityDimension)
    {
        this.entityDimension = entityDimension;
    }

    @Override
    public void move (List<Entity> snake)
    {
        int headY = snake.get(0).getPosY();
        int headX = snake.get(0).getPosX();

        Entity newHead = snake.remove(snake.size()-1);

        headX -= entityDimension;

        newHead.setPosX(headX);
        newHead.setPosY(headY);

        snake.add(0, newHead);

    }
}
