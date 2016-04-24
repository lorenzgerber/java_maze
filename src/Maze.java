/**
 * Created by loge on 13/04/16.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze
{


    private int rows = 0;
    private int columns = 0;
    private Character[][] mazeData;


    /**
     * constructor method for Maze
     * @param in java.io.Reader
     */
    public Maze(java.io.Reader in) throws IllegalStateException
    {

        readMaze(in);
        getStartPosition();
        hasGoalPosition();

    }



    /**
     * toString override for Maze
     * @return
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

    public boolean isMovable(Position position)
    {
        if(mazeData[position.getY()][position.getX()] != 42)
            return true;
        return false;
    }

    public boolean isGoal(Position position)
    {
        if(mazeData[position.getY()][position.getX()] == 71 )
            return true;
        return false;
    }

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


    private void readMaze(java.io.Reader in) throws IllegalArgumentException
    {
        try
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
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }

}
