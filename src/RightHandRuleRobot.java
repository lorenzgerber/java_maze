/**
 * Created by loge on 16/04/16.
 */
public class RightHandRuleRobot extends Robot
{

    private int direction = 0;

    public RightHandRuleRobot(Maze maze)
    {
        super(maze);
        setInitialDirection();


    }

    private void moveGrid(int moveDir) throws IllegalArgumentException
    {
        switch (moveDir)
        {
            case 0:
                this.setCurrentPosition(getCurrentPosition().getPosToNorth());
                break;
            case 1:
                this.setCurrentPosition(getCurrentPosition().getPosToEast());
                break;
            case 2:
                this.setCurrentPosition(getCurrentPosition().getPosToSouth());
                break;
            case 3:
                this.setCurrentPosition(getCurrentPosition().getPosToWest());
                break;
            default:
                throw new IllegalArgumentException("input argument needs to be brom 1 - 4");
        }

    }

    private boolean wallGrid(int checkDir) throws IllegalArgumentException
    {
        switch (checkDir)
        {
            case 0:
                return maze.isWall(this.getCurrentPosition().getPosToNorth());
            case 1:
                return maze.isWall(this.getCurrentPosition().getPosToEast());
            case 2:
                return maze.isWall(this.getCurrentPosition().getPosToSouth());
            case 3:
                return maze.isWall(this.getCurrentPosition().getPosToWest());
        }
        throw new IllegalArgumentException("input argument needs to be brom 1 - 4");
    }

    private boolean movableGrid(int checkDir) throws IllegalArgumentException
    {
        switch (checkDir)
        {
            case 0:
                return maze.isMovable(this.getCurrentPosition().getPosToNorth());
            case 1:
                return maze.isMovable(this.getCurrentPosition().getPosToEast());
            case 2:
                return maze.isMovable(this.getCurrentPosition().getPosToSouth());
            case 3:
                return maze.isMovable(this.getCurrentPosition().getPosToWest());
        }
        throw new IllegalArgumentException("input argument needs to be brom 1 - 4");
    }





    public void move() throws IllegalArgumentException
    {
        if (movableGrid(this.direction)){
            moveGrid(this.direction);
            if (!wallGrid(this.direction +1 )){
                this.direction = (this.direction + 1) % 4 ;
                moveGrid(this.direction);
            }
        } else
        {
            this.direction = (this.direction - 1) % 4;
            moveGrid(this.direction);
            if(!wallGrid(this.direction +1)){
                this.direction = (this.direction +1) % 4;
                moveGrid(this.direction);
            }
        }
    }

    private void setInitialDirection(){
        Position now = this.getCurrentPosition();
        boolean north = this.maze.isWall(now.getPosToNorth());
        boolean east  = this.maze.isWall(now.getPosToEast());
        boolean south = this.maze.isWall(now.getPosToSouth());
        boolean west = this.maze.isWall(now.getPosToWest());

        if ( !north && !east && !south && !north && !west)
            throw new IllegalArgumentException("there is no wall in reach of the start position");

        if (east)
        {
            this.direction = 0;
        } else if (south)
        {
            this.direction = 1;
        } else if (west)
        {
            this.direction = 2;
        } else
        {
            this.direction = 3;
        }
    }

}

