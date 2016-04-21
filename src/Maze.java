/**
 * Created by loge on 13/04/16.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze {


    public int rows = 0;
    public int columns = 0;
    public Position start;
    private Character[][] mazeData;


    /**
     * constructor method for Maze
     * @param in java.io.Reader
     */
    public Maze(java.io.Reader in){

        readMaze(in);

    }

    /**
     * toString override for Maze
     * @return
     */
    public String toString(){

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

    public boolean isMovable(Position position){
        if(mazeData[position.getX()][position.getY()] == 32)
            return true;
        return false;
    }

    public boolean isGoal(Position position){
        if(mazeData[position.getX()][position.getY()] == 39 )
            return true;
        return false;
    }

    public Position getStartPosition(){

        for (int iii = 0; iii < rows; iii++){
            for (int jjj = 0; jjj < columns; jjj++){
                if (mazeData[iii][jjj] == 51)
                    return new Position(iii, jjj);

            }

        }

        return new Position(0,0);
    }

    private void readMaze(java.io.Reader in){
        try
        {
            int ch;
            ArrayList<Character> buffer = new ArrayList<Character>();


            while ((ch = in.read()) != -1) {
                char character = (char) ch;
                if (ch == 10) {
                    this.rows++;
                } else {
                    buffer.add(character);
                }

            }

            this.columns = buffer.size()/this.rows;

            Iterator<Character> mazeIterator = buffer.iterator();
            this.mazeData = new Character[this.rows][this.columns];

            for (int iii = 0; iii < this.rows; iii++){
                for (int jjj = 0; jjj < this.columns; jjj++){
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
