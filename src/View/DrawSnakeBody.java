package View;

import java.awt.*;

public class DrawSnakeBody implements Drawing
{
    private int x;
    private int y;
    private int dimension;

    public DrawSnakeBody (int x, int y, int dimension)
    {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.drawOval(x, y, dimension, dimension);
    }
}
