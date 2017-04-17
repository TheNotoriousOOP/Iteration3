import model.player.Player;
import model.wonder.Wonder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class WonderTest {

    private Wonder wonder;

    @Before
    public void setup() {
        wonder = new Wonder();
    }

    @Test
    public void basicWonderTest() {
        wonder.build();
        assertEquals(1, wonder.getSize());
        assertEquals(1, wonder.getTier());
        assertEquals(1, wonder.getBrickCost(new Player("lol")));
    }

    @Test
    public void wonderTierTest() {
        assertEquals(1, wonder.getTier());
        wonder.build();
        assertEquals(1, wonder.getTier());
        while(wonder.getSize() < 12)
            wonder.build();
        assertEquals(3, wonder.getTier());
        wonder.build();
        assertEquals(4, wonder.getTier());
        while(wonder.getSize() < 17)
            wonder.build();
        assertEquals(4, wonder.getTier());
        wonder.build();
        assertEquals(5, wonder.getTier());
        while(wonder.getSize() < 22)
            wonder.build();
        assertEquals(5, wonder.getTier());
        wonder.build();
        assertEquals(6, wonder.getTier());
        //TODO: Make less retarded
    }

    @Test
    public void wonderCostTest() {
        Player player = new Player("lol");
        assertEquals(1, wonder.getBrickCost(player));
        wonder.build(player);
        assertEquals(2,wonder.getBrickCost(player));
        wonder.build(player);
        assertEquals(3, wonder.getBrickCost(player));
        wonder.resetPlayerModifier();
        assertEquals(1, wonder.getBrickCost(player));
        while(wonder.getSize() < 5)
            wonder.build();
        assertEquals(2, wonder.getBrickCost(player));
        wonder.build(player);
        assertEquals(3, wonder.getBrickCost(player));
        wonder.resetPlayerModifier();
        while(wonder.getSize() < 17)
            wonder.build();
        assertEquals(4, wonder.getBrickCost(player));
        wonder.build();
        assertEquals(6, wonder.getBrickCost(player));
    }



}
