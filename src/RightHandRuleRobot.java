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

    public void move() throws IllegalArgumentException
    {

        if (movableDirection(this.direction)){
            moveDirection(this.direction);

            // if current position is goal don't move more
            // otherwise, handle the right turn
            if(!this.maze.isGoal(this.getCurrentPosition())){
                if (!wallDirection((this.direction + 1) % 4 )){
                    this.direction = (this.direction + 1) % 4 ;
                    moveDirection(this.direction);
                }
            }


        } else
        {
            if((this.direction - 1) % 4 < 0)
            {
                this.direction = ((this.direction - 1) % 4) + 4;
            } else {
                this.direction = (this.direction - 1) % 4;
            }
        }
    }
    

    private void moveDirection(int moveDir) throws IllegalArgumentException
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

    private boolean wallDirection(int checkDir) throws IllegalArgumentException
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

    private boolean movableDirection(int checkDir) throws IllegalArgumentException
    {
        try
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
                default:
                throw new IllegalArgumentException("input argument needs to be brom 1 - 4");
            }

        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
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

