package Controller.BodyController;

import Model.BodyPart;
import Model.Entity;

import java.util.List;

public class GrowIfUp implements Growing
{

    private int entityDimension;

    public GrowIfUp (int entityDimension)
    {
        this.entityDimension = entityDimension;
    }

    @Override
    public void grow(List<Entity> snake)
    {
        int headX = snake.get(0).getPosX();
        int headY = snake.get(0).getPosY();

        snake.add(0 , new BodyPart(headX, headY - entityDimension, entityDimension));
    }
}
