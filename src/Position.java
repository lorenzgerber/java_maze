/**
 * Created by loge on 13/04/16.
 */
public class Position {
    private int x;
    private int y;


    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public Position getPosToSouth()
    {
        Position south = new Position(getX(), getY()+1);
        return south;


    }

    public Position getPosToNorth()
    {
        Position north = new Position(getX(), getY()-1);
        return north;


    }

    public Position getPosToWest()
    {
        Position west = new Position(getX()-1, getY());
        return west;
    }

    public Position getPosToEast()
    {
        Position east = new Position(getX()+1, getY());
        return east;
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append("\n position: ");
        output.append(this.getX());
        output.append(" / ");
        output.append(this.getY());
        output.append("\n");

        return output.toString();
    }

    public boolean equals(Object o)
    {
        Position other = (Position) o;
        if (this.getX() == other.getX() && this.getY() == other.getY())
        {
            return true;
        }
        return false;
    }

    public int hashCode(){
        return (int) this.getX() + this.getY();
    }

}
