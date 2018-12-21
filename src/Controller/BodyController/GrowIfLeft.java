package Controller.BodyController;

import Controller.GamePanel;
import Model.BodyPart;
import Model.Entity;

import java.util.List;

public class GrowIfLeft implements Growing
{

    @Override
    public void grow(List<Entity> snake)
    {
        int headX = snake.get(0).getPosX();
        int headY = snake.get(0).getPosY();

        snake.add(0, new BodyPart(headX - GamePanel.DIMENSION, headY, GamePanel.DIMENSION));
    }
}