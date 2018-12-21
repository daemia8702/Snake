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
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, dimension, dimension);
        g.setColor(Color.RED);
        g.drawRect(x, y, dimension, dimension);
    }
}
