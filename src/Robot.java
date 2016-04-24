/**
 *
 * File:    Robot.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */


/**
 * Abstract Robot Class
 * Parent class for specializing robots
 * that can compete in Maze class objects.
 * Uses the Position class for keeping track
 * it's position.
 *
 */
public abstract class Robot
{
    private Position position;
    protected Maze maze;

    /**
     * constructor for abstract Robot class
     * Takes a maze object as paramter. The new
     * robot will be placed on the start position
     * of the maze object.
     * @param maze
     */
    public Robot(Maze maze)
    {
        this.maze = maze;
        this.position = maze.getStartPosition();

    }

    /**
     * abstract method move
     */
    public abstract void move();

    /**
     * method to return a Position object with the
     * current position of the robot in the maze object
     * @return
     */
    public Position getCurrentPosition(){
        return this.position;
    }

    /**
     * protected method that allows setting the robot
     * on a new position in the maze
     * @param position
     */
    protected void setCurrentPosition(Position position){
        this.position = position;
    }

    /**
     * method to check whether the robot
     * has reached the goal position in the
     * maze object
     * @return
     */
    public boolean hasReachedGoal(){
        if(maze.isGoal(this.position))
        {
            return true;
        }
        return false;
    }

}