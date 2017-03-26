import model.map.CubeVector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 */
public class CubeVectorTest {
    @Test
    public void testCubeVector(){
        CubeVector cubeVector = new CubeVector(1,2,3);
        assertEquals(1, cubeVector.getXCoord());
        assertEquals(2, cubeVector.getYCoord());
        assertEquals(3, cubeVector.getZCoord());
    }
}
