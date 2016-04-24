import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;



public class MazeTest {
    @Test
    public void canCreateNewMaze() throws Exception {
        BufferedReader b;
        b = new BufferedReader(new FileReader("maze1.txt"));
        new Maze(b);
    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionIfNoStartPosition() throws Exception {
        BufferedReader b;
        b = new BufferedReader(new FileReader("mazeNoStart.txt"));
        new Maze(b);

    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionIfNoGoalPosition() throws Exception {
        BufferedReader b;
        b = new BufferedReader(new FileReader("mazeNoGoal.txt"));
        new Maze(b);

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfUnequalRowLength() throws Exception {
        BufferedReader b;
        b = new BufferedReader(new FileReader("mazeVariableRowLength.txt"));
        new Maze(b);

    }


}
