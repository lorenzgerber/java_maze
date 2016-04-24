/**
 *
 * File:    MemoryRobot.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */

import java.util.Stack;
import java.util.HashMap;

/**
 * Memory Robot Class is a specialisation of the Robot class
 * It implements memory behaviour according to a depth-first search
 * by using a stack and a hash map. The stack is used for
 * backtracking and the hash map keeps track of already visited
 * positions.
 */
public class MemoryRobot extends Robot {

    private Stack<Position> backtrack;
    private HashMap<Integer, Position> positionHistory;


    /**
     * Constructor method for MemoryRobot
     * Needs a maze object as argument to position
     * the new Memory Robot object in.
     * @param maze
     */
    public MemoryRobot(Maze maze){
        super(maze);
        backtrack = new Stack<Position>();
        positionHistory = new HashMap<Integer, Position>();

    }


    /**
     * Implementation of the move method
     * Uses a stack and a hash map to implement
     * depth-first search behaviour. The sequence of checking
     * for viable move directions is N, E, S, W.
     */
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