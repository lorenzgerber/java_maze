/**
 *
 * File:    Position.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */

/**
 * Position Class, used together with Maze and Robot
 * Is a container for an x/y coordinate pair and has functionality
 * to query for the neighbouring coordinates.
 *
 */
public class Position {
    private int x;
    private int y;


    /**
     * Constructor method for Position Class
     * @param x coordinate in x/y pair
     * @param y coordinate in x/y pair
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * getter for x coordinate of Position Class object
     * @return int x
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * getter for y coordinate of Position Class object
     * @return
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * method to get coordinates south of
     * the current Position object
     * @return Position object
     */
    public Position getPosToSouth()
    {
        Position south = new Position(getX(), getY()+1);
        return south;
    }

    /**
     * method to get coordinates north of
     * the current Position object
     * @return Position object
     */
    public Position getPosToNorth()
    {
        Position north = new Position(getX(), getY()-1);
        return north;
    }

    /**
     * method to get coordinates west of
     * the current Position object
     * @return Position object
     */
    public Position getPosToWest()
    {
        Position west = new Position(getX()-1, getY());
        return west;
    }

    /**
     * method to get coordinates east of
     * the current Position object
     * @return Position object
     */
    public Position getPosToEast()
    {
        Position east = new Position(getX()+1, getY());
        return east;
    }

    /**
     * override method that returns a String object
     * of the current Position object. String of the current
     * x/y coordinates
     * @return String
     */
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

    /**
     * override for the equal method. Allows to compare
     * two Position objects for equality of their xy
     * coordinates
     * @param o
     * @return boolean
     */
    public boolean equals(Object o)
    {
        Position other = (Position) o;
        if (this.getX() == other.getX() && this.getY() == other.getY())
        {
            return true;
        }
        return false;
    }

    /**
     * override for hashCode Method
     * Returns a concatenation of the x and y coordinate
     * separated by four '9' digits.
     * @return int
     */
    public int hashCode(){
        return Integer.parseInt(this.getX() + "9999" +  this.getY());
    }

}
