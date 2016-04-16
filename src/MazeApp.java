/**
 * Created by loge on 16/04/16.
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class MazeApp {

    public static void main( String[] args ) throws FileNotFoundException
    {
        File inputFile = new File(args[0]);
        FileReader in = new FileReader(inputFile);
        Maze myMaze;
        myMaze = new Maze(in);
    }


}
