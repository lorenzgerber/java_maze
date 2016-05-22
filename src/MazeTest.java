/**
 *
 * File:    MazeTest.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */

/**
 * JUnit class to test the Maze Class
 */

import org.junit.Test;
import org.junit.Assert;
import java.io.*;

public class MazeTest {
    @Test
    public void canCreateNewMaze() throws Exception {
        StringReader b;
        String s = "*SG\n***";
        b = new StringReader(s);
        new Maze(b);
    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionIfNoStartPosition() throws Exception {
        StringReader b;
        String s = "*****\n*****";
        b = new StringReader(s);
        new Maze(b);

    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionIfNoGoalPosition() throws Exception {
        StringReader b;
        String s = "****S\n*****";
        b = new StringReader(s);
        new Maze(b);

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfUnequalRowLength() throws Exception {
        StringReader b;
        String s = "****SG\n*\n**";
        b = new StringReader(s);
        new Maze(b);

    }

    @Test
    public void isMovable() {
        StringReader b;
        String s = "*SG\n***";
        b = new StringReader(s);
        Maze testMaze = new Maze(b);
        Assert.assertEquals(false, testMaze.isMovable(new Position(0,0)));



    }


}
