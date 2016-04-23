/**
 * Created by loge on 16/04/16.
 */

import java.util.Stack;
import java.util.HashMap;

public class MemoryRobot extends Robot {

    private Stack<Position> backtrack;
    private HashMap<Integer, Position> positionHistory;

    public MemoryRobot(Maze maze){
        super(maze);
        backtrack = new Stack<Position>();
        positionHistory = new HashMap<Integer, Position>();

    }



    public void move(){

        try
        {
            if(this.maze.isMovable(this.getCurrentPosition().getPosToNorth()))
            {
                if(!positionHistory.containsKey(this.getCurrentPosition().getPosToNorth().hashCode()))
                {
                    backtrack.push(this.getCurrentPosition());
                    this.setCurrentPosition(getCurrentPosition().getPosToNorth());
                    positionHistory.put(this.getCurrentPosition().hashCode(),this.getCurrentPosition());
                    return;
                }

            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("to the north, end of area");
        }



        try
        {
            if(this.maze.isMovable(this.getCurrentPosition().getPosToEast()))
            {
                if(!positionHistory.containsKey(this.getCurrentPosition().getPosToEast().hashCode()))
                {
                    backtrack.push(this.getCurrentPosition());
                    this.setCurrentPosition(getCurrentPosition().getPosToEast());
                    positionHistory.put(this.getCurrentPosition().hashCode(),this.getCurrentPosition());
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("to the east, end of area");
        }



        try
        {
            if(this.maze.isMovable(this.getCurrentPosition().getPosToSouth()))
            {
                if(!positionHistory.containsKey(this.getCurrentPosition().getPosToSouth().hashCode()))
                {
                    backtrack.push(this.getCurrentPosition());
                    this.setCurrentPosition(getCurrentPosition().getPosToSouth());
                    positionHistory.put(this.getCurrentPosition().hashCode(),this.getCurrentPosition());
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("to the south, end of area");
        }

        try
        {
            if(this.maze.isMovable(this.getCurrentPosition().getPosToWest()))
            {
                if(!positionHistory.containsKey(this.getCurrentPosition().getPosToWest().hashCode()))
                {
                    backtrack.push(this.getCurrentPosition());
                    this.setCurrentPosition(getCurrentPosition().getPosToWest());
                    positionHistory.put(this.getCurrentPosition().hashCode(),this.getCurrentPosition());
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("to the west, end of area");
        }


        // if there is no way to move, backtrack one step
        this.setCurrentPosition(backtrack.peek());
        this.backtrack.pop();

    }


}