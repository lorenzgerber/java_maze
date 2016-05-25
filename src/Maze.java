/**
 *
 * File:    Maze.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Maze that implements a labyrinth
 * including it's import from text data
 * The labyrinth is the playground for
 * robot classes that try to navigate
 * from a start field 'S' to a goal 'G'.
 *
 */
public class Maze
{


    private int rows = 0;
    private int columns = 0;
    private Character[][] mazeData;


    /**
     * constructor method for Maze
     * @param in java.io.Reader
     */
    public Maze(java.io.Reader in) throws IllegalStateException, IOException
    {
        readMaze(in);
        getStartPosition();
        hasGoalPosition();
    }



    /**
     * toString override for Maze
     * outputs a formated string that
     * shows a representation of the labyrinth
     * @return String
     */
    public String toString()
    {

        StringBuilder output = new StringBuilder();
        output.append("\n");
        for (int iii = 0; iii < rows; iii++){
            for (int jjj = 0; jjj < columns; jjj++){
                output.append(this.mazeData[iii][jjj]);
            }
            output.append("\n");
        }

        return output.toString();
    }

    /**
     * method isMovable checks if the Maze object coordinates
     * given by the Position object are movable for
     * a robot object.
     * @param position
     * @return boolean
     */
    public boolean isMovable(Position position)
    {
        if(mazeData[position.getY()][position.getX()] != 42)
            return true;
        return false;
    }

    /**
     * method isGoal checks if the Maze object coordinates
     * given by the Position object are the goal.
     * @param position
     * @return boolean
     */
    public boolean isGoal(Position position)
    {
        if(mazeData[position.getY()][position.getX()] == 71 )
            return true;
        return false;
    }


    /**
     * method isWall checks if the Maze object coordinates
     * given by the Position object are a wall. This method
     * will also return true if the requested position is outside
     * of the maze.
     * @param position
     * @return boolean
     */
    public boolean isWall(Position position)
    {
        try
        {
            if (mazeData[position.getY()][position.getX()] == 42)
                return true;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
                return true;
        }
        return false;
    }

    /**
     * method getStartPosition will return a Position object
     * with the coordinates of the start position of the current
     * maze object.
     * @return Position with start coordinates
     * @throws IllegalStateException if no start position is found
     */
    public Position getStartPosition() throws IllegalStateException
    {

        for (int iii = 0; iii < rows; iii++){
            for (int jjj = 0; jjj < columns; jjj++){
                if (mazeData[iii][jjj] == 83)
                    return new Position(jjj, iii);

            }

        }

        throw new IllegalStateException("maze has no start position");
    }

    /**
     * method hasGoalPosition checks whether the current Maze
     * object has at least one goal position.
     * @return boolean
     * @throws IllegalStateException if no goal field is found
     */
    private boolean hasGoalPosition() throws IllegalStateException
    {
        for (int iii = 0; iii < rows; iii++){
            for (int jjj = 0; jjj < columns; jjj++){
                if (mazeData[iii][jjj] == 71)
                    return true;

            }

        }

        throw new IllegalStateException("maze has no Goal position");

    }


    /**
     * readMaze method reads the maze and reformats it
     * into a String array that is then stored as the internal
     * property mazeData.
     * @param in java.io.Reader
     * @throws IllegalArgumentException If there are rows of different length.
     */
    private void readMaze(java.io.Reader in) throws IllegalArgumentException, IOException
    {
            int readChar;
            int checkLengthRow = 0;
            int lastRowLength = 0;

            ArrayList<Character> buffer = new ArrayList<Character>();


            while ((readChar = in.read()) != -1)
            {
                char character = (char) readChar;
                checkLengthRow++;

                // detect end of row
                if (readChar == 10) {

                    // check if the rows are of equal length.
                    // Is not checked in the 0 index row.
                    if(this.rows != 0){
                        if(checkLengthRow != lastRowLength){
                            throw new IllegalArgumentException("Maze rows not of equal length");
                        } else {
                            lastRowLength = checkLengthRow;
                            checkLengthRow = 0;
                        }
                    } else {
                        lastRowLength = checkLengthRow;
                        checkLengthRow = 0;
                    }

                    this.rows++;
                } else
                {
                    buffer.add(character);
                }

            }

            this.columns = buffer.size()/this.rows;

            Iterator<Character> mazeIterator = buffer.iterator();
            this.mazeData = new Character[this.rows][this.columns];

            for (int iii = 0; iii < this.rows; iii++)
            {
                for (int jjj = 0; jjj < this.columns; jjj++)
                {
                    this.mazeData[iii][jjj] = mazeIterator.next();
                }
            }


    }

}
