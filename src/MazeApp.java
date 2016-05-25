/**
 *
 * File:    MazeApp.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * MazeApp test program for the classes Maze,
 * Position, Maze, Robot, RightHandRuleRobot and
 * MemoryRobot.
 * Loads a maze from a text file given by the first
 * command line arguemnt.
 */
public class MazeApp
{

    /**
     *
     * main program for testing the robot maze assignent
     * from the object oriented programming course (OU2)
     * The text file should contain a rectangular field where
     * '*' mark walls, space empty room to move, 'S' the
     * start position and 'G's goal positions.
     *
     * @param args textfile that contains a labyrinth
     * @throws FileNotFoundException
     */
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {


        // Loading and initializing the maze
        final int ROUNDS = 80;
        int rhrRobotCounter = 0;
        int memRobotCounter = 0;

        // Handling missing command line argument
        if(args.length == 0){
            System.out.println("Missing command line argument. Maze text file needed");
            return;
        }

        BufferedReader b;
        b = new BufferedReader(new FileReader(args[0]));

        Maze myMaze;
        try
        {
            myMaze = new Maze(b);


            // Creating the Robots
            RightHandRuleRobot rhrRobot = new RightHandRuleRobot(myMaze);
            MemoryRobot memRobot = new MemoryRobot(myMaze);



            // Running the competition
            for (int path = 0; path < ROUNDS; path++)
            {
                if (!rhrRobot.hasReachedGoal())
                {
                    rhrRobotCounter++;
                    rhrRobot.move();
                }

                if (!memRobot.hasReachedGoal())
                {
                    memRobotCounter++;
                    memRobot.move();
                }
            }


            // Evaluating the Competition
            if (rhrRobot.hasReachedGoal())
            {
                System.out.printf("Right Hand Rule Robot has reached goal in %d moves\n", rhrRobotCounter);
            } else {
                System.out.printf("Right Hand Rule Robot did not reach the goal in %d moves\n", ROUNDS);
            }

            if (memRobot.hasReachedGoal())
            {
                System.out.printf("Memory Robot has reached goal in %d moves\n", memRobotCounter);
            } else
            {
                System.out.printf("Memory Robot did not reach the goal in %d moves\n", ROUNDS);
            }

            if (memRobotCounter == rhrRobotCounter)
            {
                System.out.println("It's a draw\n");
            }
            else if (memRobotCounter < rhrRobotCounter)
            {
                System.out.println("The Memory Robot wins\n");
            } else
            {
                System.out.println("The Right Hand Rule Robot wins\n");
            }

        } catch(IOException e)
        {
            System.out.println("Something wrong with the file");
        }

    }
}
