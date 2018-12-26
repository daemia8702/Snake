package Model;

/**
 * The base abstract class for the game entities
 */

public abstract class Entity
{

    /**
     * Private field for the game entities
     * posX for x coordiante
     * posY for y coordinate
     * dimension for the width and height
     */
    private int posX;
    private int posY;
    private int dimension;

    public Entity(int posX, int posY, int dimension)
    {
        this.posX = posX;
        this.posY = posY;
        this.dimension = dimension;
    }

    /**
     * Getters and Setters for the private fields of this class
     */
    public int getPosX()
    {
        return posX;
    }

    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public void setDimension(int dimension)
    {
        this.dimension = dimension;
    }
}
