/**
 * Created by loge on 13/04/16.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze {

    private String mazeData;

    public Maze(java.io.Reader in){
        //TODO constructor method for Maze
        // TODO file read

        try
        {
            int ch;
            ArrayList<Character> buffer = new ArrayList<Character>();
            int total = 0;
            int rows = 0;

            while ((ch = in.read()) != -1) {
                char character = (char) ch;
                if (ch == 10) {
                    System.out.println(character);
                    rows++;
                } else {
                    total++;
                    buffer.add(character);
                    System.out.print(character);
                }

            }
            System.out.printf("This maze has %d rows and %d columns ", rows, total/rows);

        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        


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

}
