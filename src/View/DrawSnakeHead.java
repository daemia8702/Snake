package View;

import java.awt.*;

/**
 * Class for drawing the snake head to the screen, with the given
 * positions and dimension
 * This class is implementing Drawing interface, which is a functional interface with the abstract method
 * public void draw(Graphics g)
 */

public class DrawSnakeHead implements Drawing
{
    private int x;
    private int y;
    private int dimension;

    /**
     * Constructor of this class. Using to inject the coordinates from the Controller package
     * @param x the x coordinate of a snake head on the screen
     * @param y the y coordinate of a snake head on the screen
     * @param dimension the dimension of the snake head
     */
    public DrawSnakeHead (int x, int y, int dimension)
    {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
    }

    /**
     * The function from the Drawing interface
     * @param g The Graphics object from java.awt library. It's used to draw the snake head
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, dimension, dimension);
    }
}
