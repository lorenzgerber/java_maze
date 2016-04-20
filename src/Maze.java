/**
 * Created by loge on 13/04/16.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze {


    public int rows = 0;
    public int columns = 0;
    public Character[][] maze;
    private Character[][] mazeData;

    private int total = 0;


    /**
     * constructor method for Maze
     * @param in java.io.Reader
     */
    public Maze(java.io.Reader in){

        this.mazeData = readMaze(in);

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
        //TODO method to check if a position is possible
        return false;
    }

    public boolean isGoal(Position position){
        //TODO method to check if a position is the goal
        return false;
    }

    public Position getStartPosition(){
        //TODO method to
        return new Position(1,1);
    }

    private Character[][] readMaze(java.io.Reader in){
        try
        {
            int ch;
            ArrayList<Character> buffer = new ArrayList<Character>();


            while ((ch = in.read()) != -1) {
                char character = (char) ch;
                if (ch == 10) {
                    rows++;
                } else {
                    total++;
                    buffer.add(character);
                }

            }

            columns = total/rows;

            Iterator<Character> mazeIterator = buffer.iterator();
            maze = new Character[rows][columns];

            for (int iii = 0; iii < rows; iii++){
                for (int jjj = 0; jjj < columns; jjj++){
                    maze[iii][jjj] = mazeIterator.next();
                }
            }


        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        return maze;
    }

}
