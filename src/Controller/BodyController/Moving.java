package Controller.BodyController;

import Model.Entity;

import java.util.List;

@FunctionalInterface
public interface Moving
{
    void move (List<Entity> snake);
}
