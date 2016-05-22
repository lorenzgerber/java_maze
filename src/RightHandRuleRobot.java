/**
 *
 * File:    RightHandRuleRobot.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */

/**
 * RightHandRuleRobot Class is a specialization of
 * the abstract Robot class that implements a 'right hand
 * wall following' behaviour for the move method. The robot
 * translates between the directions N, E, S, W and his own
 * movement direction which is stored as a private property
 *
 */
public class RightHandRuleRobot extends Robot
{

    private int direction = 0;

    /**
     * Constructor for the RightHandRuleRobot. It
     * takes a Maze object as argument in which the
     * new robot object will be placed on the start
     * position.
     * @param maze
     */
    public RightHandRuleRobot(Maze maze)
    {
        super(maze);
        setInitialDirection();


    }

    /**
     * override move method that implements 'right hand
     * wall following' behaviour.
     * @throws IllegalArgumentException If the start position of the maze object is
     * not next to a wall, the robot can not be instantiated.
     */
    public void move() throws IllegalArgumentException
    {

        if (movableDirection(this.direction)){
            moveDirection(this.direction);

            // if current position is goal don't move more
            // otherwise, handle the right turn
            if(!this.isGoal(this.getCurrentPosition())){
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

    /**
     * Method to check whether a position is the Goal
     * @param checkPosition
     * @return
     */
    private boolean isGoal(Position checkPosition){
        return this.maze.isGoal(checkPosition);
    }


    /**
     * moveDirection translates from the robot-centric direction to
     * the directions N E S W by a switch statement. This method executes
     * the actual move of the robot.
     * @param moveDir int
     * @throws IllegalArgumentException moveDir can be 0, 1 , 2 or 3
     */
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
                throw new IllegalArgumentException("input argument needs to be brom 0 - 3");
        }

    }

    /**
     * wallDirection translates from the robot-centric direction to
     * the directions N E S W by a switch statement. This method checks whether
     * there is a wall in the queried direction.
     * @param checkDir
     * @return boolean
     * @throws IllegalArgumentException wallDirection can be 0, 1, 2 or 3
     */
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
        throw new IllegalArgumentException("input argument needs to be brom 0 - 3");
    }

    /**
     * movableDirection translates from the robot-centric direction to
     * the directions N E S W by a switch statement. This method checks whether
     * the queried direction is movable for the robot.
     * @param checkDir
     * @return boolean
     * @throws IllegalArgumentException movableDirection can be 0, 1, 2 or 3
     */
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
                throw new IllegalArgumentException("input argument needs to be brom 0 - 3");
            }

        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }


    /**
     * setInitialDirection is used to set the direction
     * of the robot at construction time. The sequence of checking for
     * walls is N, E, S, W. Hence the robot will choose the first viable
     * wall in reach.
     */
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

