/**
 *
 * File:    PositionTest.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-24
 */

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * JUnit class to test the Position Class
 */
public class PositionTest {
    @Test
    public void canCreateNewPosition() throws Exception {
        new Position(1,1);
    }

    @Test
    public void assertEqualMethod() throws Exception{
        assertEquals(new Position(1,1), new Position(1,1));
    }

    @Test
    public void assertInequalityOfDifferentPositions() throws Exception{
        assertNotEquals(new Position(1,1), new Position(1,2));
    }

    @Test
    public void assertDifferentHashCodes() throws Exception{
        Position A = new Position(1,1);
        Position B = new Position(1,2);
        int hcA = A.hashCode();
        int hcB = B.hashCode();

        assertNotEquals(hcA, hcB);
    }

}
