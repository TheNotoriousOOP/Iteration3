import controller.GameController;
import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.game.GameModel;
import model.map.tile.nodeRepresentation.StraightRiverSetup;
import model.map.tile.nodeRepresentation.TriRiverSetup;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.Gold;
import model.resources.Resource;
import model.resources.Trunks;
import model.transporters.Transporter;
import model.transporters.TransporterID;
import model.transporters.land_transporters.Donkey;
import model.transporters.water_transporters.Rowboat;
import org.junit.Before;
import org.junit.Test;
import view.PanelManager;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jonathen on 4/15/2017.
 */
public class GameControllerTest {

    GameController gameController;

    //Classes that the controllers need
    PanelManager panelManager;
    GameModel gameModel;

    Transporter t;
    Transporter t2;

    //Create controllers
    @Before
    public void setup() {
        panelManager = new PanelManager();
        gameModel = new GameModel();

        fillUpPlayer();

        gameController = new GameController(panelManager.getGameViewPanel(), gameModel);
    }

    @Before
    public AbilitySet setUpFirstAbilitySet() {
        ArrayList<Ability> abilities = new ArrayList<>();
        return new AbilitySet(abilities);
    }

    @Before
    public AbilitySet setUpSecondAbilitySet() {
        ArrayList<Ability> abilities = new ArrayList<>();
        return new AbilitySet(abilities);
    }

    @Before
    public void fillUpPlayer() {

        Player player = (new Player());

        Resource[] resources = { new Gold(), new Trunks()};
        ParentNode parentNode1 = new ParentLandNode(new StraightRiverSetup(0));
        ParentNode parentNode2 = new ParentLandNode(new TriRiverSetup(0));
        int movementSpeed = 2;

        t = new Donkey(new TransporterID(), player, resources, null, parentNode1, movementSpeed);
        AbilitySet tAbilitySet = setUpFirstAbilitySet();

        player.addTransporter(t);

        movementSpeed = 4;
        t2 = new Rowboat(new TransporterID(), player, resources, null, parentNode2, movementSpeed);
        AbilitySet t2AbilitySet = setUpSecondAbilitySet();
        player.addTransporter(t2);

        //Needed to initialize gameModel
        Player[] players = { player, (new Player()) };
        gameModel.setPlayers(players);
    }

    @Test
    public void keyPressed() throws Exception {
        //Simulate key presses

        int keyCode = KeyEvent.VK_ENTER; // press the enter key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        System.out.println(gameController.getCurrentTransporter().toString());
        System.out.println(t.toString());
        assert(gameController.getCurrentTransporter().equals(t));

        keyCode = KeyEvent.VK_LEFT; // press the left arrow key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        assert(gameController.getCurrentTransporter().equals(t2));

        keyCode = KeyEvent.VK_LEFT; // press the left arrow key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        assert(gameController.getCurrentTransporter().equals(t));

        keyCode = KeyEvent.VK_RIGHT; // press the right arrow key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        assert(gameController.getCurrentTransporter().equals(t2));
    }

}