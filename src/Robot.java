/**
 * Created by loge on 13/04/16.
 */
public abstract class Robot
{
    private Position position;
    protected Maze maze;

    public Robot(Maze maze)
    {
        this.maze = maze;
        this.position = maze.getStartPosition();

    }

    public abstract void move();

    public Position getCurrentPosition(){
        return this.position;
    }

    protected void setCurrentPosition(Position position){
        this.position = position;
    }

    public boolean hasReachedGoal(){
        if(maze.isGoal(this.position))
        {
            return true;
        }
        return false;
    }

}