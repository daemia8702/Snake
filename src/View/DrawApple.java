package View;

import java.awt.*;

/**
 * Class for drawing the apple to the screen, with the given
 * positions and dimension
 * This class is implementing Drawing interface, which is a functional interface with the abstract method
 * public void draw(Graphics g)
 */

public class DrawApple implements Drawing
{
    private int x;
    private int y;
    private int dimension;

    /**
     * Constructor of this class. Using to inject the coordinates from the Controller package
     * @param x the x coordinate of the apple on the screen
     * @param y the y coordinate of the apple on the screen
     * @param dimension the dimension of the apple
     */
    public DrawApple (int x, int y, int dimension)
    {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
    }

    /**
     * The function from the Drawing interface
     * @param g The Graphics object from java.awt library. It's used to draw the apple
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(x, y, dimension, dimension);
    }
}
