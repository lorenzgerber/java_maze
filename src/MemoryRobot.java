/**
 * Created by loge on 16/04/16.
 */

import java.util.Stack;
import java.util.Collections;
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
        //TODO algorithm for memory robot, depth first search
    }

    private Position nextPosition(){
        boolean north = this.maze.isMovable(this.getCurrentPosition().getPosToNorth());
        boolean east = this.maze.isMovable(this.getCurrentPosition().getPosToEast());
        boolean south = this.maze.isMovable(this.getCurrentPosition().getPosToSouth());
        boolean west = this.maze.isMovable(this.getCurrentPosition().getPosToSouth());

        //TODO if north movable
        if (north){
            positionHistory.containsKey(this.getCurrentPosition().getPosToNorth().hashCode());
            positionHistory.put(this.getCurrentPosition().hashCode(),this.getCurrentPosition());

        }
        //TODO mark current position
        //TODO put current position on stack


        //TODO if no position possible
        //TODO pop stack and move to popped position

        return this.getCurrentPosition();

    }


}