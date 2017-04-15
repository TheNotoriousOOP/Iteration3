import model.resources.Coins;
import model.resources.Gold;
import model.resources.TransportStorage;
import org.junit.Before;
import org.junit.Test;

public class TransportStorageTest {

    private TransportStorage storage;

    @Before
    public void setup() {
        this.storage = new TransportStorage(3);
    }

    @Test
    public void testStorageEmptyToStart() {
        assert (storage.isEmpty());
    }

    public void testNotFullToStart() {
        assert (!storage.isFull());
    }

    @Test
    public void testStorageCapacitySet() {
        assert (storage.getCapacity() == 3);
    }

    @Test
    public void testAddingSpecificResource() {

        storage.addCoins(new Coins());
        assert (storage.getSize() == 1);
        Coins c = storage.removeCoins();
        assert (c != null);
        assert (storage.isEmpty());
        assert (storage.getSize() == 0);

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
