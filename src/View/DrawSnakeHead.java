package View;

import java.awt.*;

public class DrawSnakeHead implements Drawing
{
    private int x;
    private int y;
    private int dimension;

    public DrawSnakeHead (int x, int y, int dimension)
    {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, dimension, dimension);
    }
}
