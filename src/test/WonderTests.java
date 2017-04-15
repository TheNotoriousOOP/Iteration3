import model.player.Player;
import model.wonder.Wonder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class WonderTests {

    private Wonder wonder;

    @Before
    public void setup() {
        wonder = new Wonder();
    }

    @Test
    public void basicFunctionality() {
        wonder.build();
        assertEquals(1, wonder.getSize());
        assertEquals(1, wonder.getBrickCost(new Player(null)));
    }




}
