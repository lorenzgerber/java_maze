/**
 * Created by loge on 13/04/16.
 */
public class Maze {

    private String mazeData;

    public Maze(java.io.Reader){
        //TODO constructor method for Maze
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
