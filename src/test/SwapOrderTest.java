import model.game.GameModel;
import model.player.Player;
import org.junit.Before;
import org.junit.Test;

public class SwapOrderTest {

    private Player[] players;
    private Player p1;
    private Player p2;
    private GameModel model;

    @Before
    public void setup() {

        model = new GameModel();
        players = model.getPlayers();
        p1 = players[0];
        p2 = players[1];

    }

    // Test swap
    @Test
    public void testSwap() {

        // Assert order normal at first
        assert (p1.equals(players[0]));
        assert (p2.equals(players[1]));

        // Perform swap
        model.swapPlayerOrder();

        // Assert order should be swaped
        assert (p1.equals(players[1]));
        assert (p2.equals(players[0]));

    }

    // Test active player order changed
    @Test
    public void testActivePlayerChanges() {

        // Get active player
        Player active = model.getActivePlayer();

        // Swap
        model.swapPlayerOrder();

        // Assert active player has changed
        assert (!active.equals(model.getActivePlayer()));

    }

}
