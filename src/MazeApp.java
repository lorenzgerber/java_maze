/**
 * Created by loge on 16/04/16.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;




public class MazeApp
{

    public static void main( String[] args ) throws FileNotFoundException
    {


        // Loading and initializing the maze
        final int ROUNDS = 80;
        int rhrRobotCounter = 0;
        int memRobotCounter = 0;

        BufferedReader b;
        b = new BufferedReader(new FileReader(args[0]));

        Maze myMaze;
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

    }


}
