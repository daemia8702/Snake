package Controller.BodyController;

import Model.Entity;

import java.util.List;

public class DontMove implements Moving
{

    @Override
    public void move(List<Entity> snake) {
        return;
    }
}
