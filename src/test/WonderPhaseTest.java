import model.game.GameModel;
import model.phase.ModelMediator;
import model.phase.WonderPhase;
import model.wonder.Wonder;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class WonderPhaseTest {

    private WonderPhase phase;
    private GameModel model;

    @Before
    public void setup() {
        phase = new WonderPhase();
        model = new GameModel();
    }

    @Test
    public void basicWonderPhaseTest() {
        System.out.println("Implement tests!");
        //How the fuck do I test this
        //ModelMediator m = new ModelMediator(new GameModel());
        //phase.startPhase(m);
        //phase.endPhase(null);
    }

}
