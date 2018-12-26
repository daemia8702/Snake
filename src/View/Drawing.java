package View;

import java.awt.*;

/**
 * The interface for the three implementing class: DrawApple, DrawSnakeBody, DrawSnakeHead
 */

@FunctionalInterface
public interface Drawing
{
    /**
     * The only abstract method this interface has, hence it's a Functional Interface.
     * @param g
     */
    void draw(Graphics g);
}
