import org.junit.Test;
import static org.junit.Assert.*;

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
