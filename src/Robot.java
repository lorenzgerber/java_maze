/**
 * Created by loge on 13/04/16.
 */
public class Robot {
    private Position position;
    protected Maze maze;

    public Robot(Maze maze){
        //TODO Robot constructor
    }

    public void move(){

    }

    public Position getCurrentPosition(){
        // TODO get current position of the robot
        return new Position(1,1);
    }

    protected void setCurrentPosition(Position position){
        // TODO set current position of the robot
    }

    public boolean hasReachedGoal(){
        //TODO check if robot reached goal
        return false;
    }

}

public class MemoryRobot extends Robot {

    public MermoryRobot(){

    }

    public void move(){
        //TODO algorithm for memory robot, depth first search
    }


}

public class RightHandRuleRobot extends Robot {

    public RightHandfRuleRobot(){

    }

    public void move(){
        //TODO algorithm for move Right hand rule
    }
    
}
