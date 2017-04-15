import model.resources.Gold;
import model.resources.TileStorage;
import org.junit.Before;
import org.junit.Test;

public class TileStorageTest {

    private TileStorage storage;

    @Before
    public void setup() {
        this.storage = new TileStorage();
    }

    @Test
    public void testStorageEmptyToStart() {
        assert (storage.isEmpty());
    }

    @Test
    public void testAddingSpecificResource() {

        assert(storage.getSize() == 0);
        assert (storage.isEmpty());

        storage.addGold(new Gold());
        assert (storage.getSize() == 1);
        assert (!storage.isEmpty());

        Gold g = storage.removeGold();
        assert(storage.getSize() == 0);
        assert (storage.isEmpty());

    }

    @Test
    public void testAddUnknownResource() {

        assert(storage.getSize() == 0);
        assert (storage.isEmpty());

        storage.addResource(new Gold());
        assert (storage.getSize() == 1);
        assert (!storage.isEmpty());

        Gold g = storage.removeGold();
        assert (g != null);
        assert(storage.getSize() == 0);
        assert (storage.isEmpty());

    }

}
