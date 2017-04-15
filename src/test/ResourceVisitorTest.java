import model.resources.Boards;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.resources.resourceVisitor.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class ResourceVisitorTest {

    private ResourceStorage tile;
    private ResourceStorage transport;

    @Before
    public void setup() {
        tile = new TileStorage();
        transport = new TransportStorage(5);
    }

    @Test
    public void basicVisitorTest() {
        InnerResourceVisitor bv = new BoardVisitor();
        InnerResourceVisitor bv2 = new BoardVisitor();
        Boards b = new Boards();
        ((BoardVisitor)bv).setBoards(b);
        tile.accept(new AddResourceVisitor(bv));
        assertEquals(1, tile.getBoardsArrayList().size());
        tile.accept(new RemoveResourceVisitor(bv2));
        assertEquals(0, tile.getBoardsArrayList().size());
        transport.accept(new AddResourceVisitor(bv2));
        assertEquals(1, transport.getBoardsArrayList().size());
        assertEquals(b, transport.getBoardsArrayList().get(0));
    }



}
