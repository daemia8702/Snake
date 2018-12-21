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
        g.setColor(Color.WHITE);
        g.fillRect(x, y, dimension, dimension);
        g.setColor(Color.RED);
        g.drawRect(x, y, dimension, dimension);
    }
}
