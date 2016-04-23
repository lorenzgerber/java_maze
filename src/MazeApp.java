/**
 * Created by loge on 16/04/16.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;




public class MazeApp {

    public static void main( String[] args ) throws FileNotFoundException
    {
        //File inputFile = new File(args[0]);
        FileReader in = new FileReader(args[0]);
        BufferedReader b;
        b = new BufferedReader(new FileReader(args[0]));

        Maze myMaze;
        myMaze = new Maze(b);
        System.out.print(myMaze.toString());

        //RightHandRuleRobot myRobot = new RightHandRuleRobot(myMaze);
        MemoryRobot myRobot = new MemoryRobot(myMaze);

        for(int path = 0; path < 80; path++)
        {
            myRobot.move();
            System.out.print(myRobot.getCurrentPosition().toString());
            if(myRobot.hasReachedGoal())
            {
                System.out.println("GOAL");
                break;
            }
        }

    }



}
