package Controller.BodyController;

import Model.Entity;

import java.util.List;

@FunctionalInterface
public interface Growing
{
    void grow (List<Entity> snake);
}
