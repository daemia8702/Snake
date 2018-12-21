package Model;

public abstract class Entity
{
    private int posX;
    private int posY;
    private int dimension;

    public Entity(int posX, int posY, int dimension)
    {
        this.posX = posX;
        this.posY = posY;
        this.dimension = dimension;
    }

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

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
