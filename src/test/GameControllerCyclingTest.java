import controller.GameController;
import model.ability_management.ability.Ability;
import model.ability_management.ability.move_abilities.*;
import model.ability_management.ability_set.AbilitySet;
import model.game.GameModel;
import model.map.tile.nodeRepresentation.StraightRiverSetup;
import model.map.tile.nodeRepresentation.TriRiverSetup;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.*;
import model.transporters.Transporter;
import model.transporters.TransporterID;
import model.transporters.land_transporters.Donkey;
import model.transporters.water_transporters.Rowboat;
import org.junit.Before;
import org.junit.Test;
import view.PanelManager;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Jonathen on 4/15/2017.
 */
public class GameControllerCyclingTest {

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

    private AbilitySet setUpFirstAbilitySet() {

        HashMap<String, Ability> abilities = new HashMap<>();

        Ability tmp = new MoveNorthAbility();
        abilities.put(tmp.toString(), tmp);

        tmp = new MoveNorthEastAbility();
        abilities.put(tmp.toString(), tmp);

        tmp = new MoveNorthEastAbility();
        abilities.put(tmp.toString(), tmp);

        for (Ability ability : abilities.values()) {
            ability.setActor(t);
        }

        return new AbilitySet(abilities);
    }

    private AbilitySet setUpSecondAbilitySet() {

        HashMap<String, Ability> abilities = new HashMap<>();

        Ability tmp = new MoveSouthAbility();
        abilities.put(tmp.toString(), tmp);

        tmp = new MoveSouthEastAbility();
        abilities.put(tmp.toString(), tmp);

        tmp = new MoveSouthEastLeftAbility();
        abilities.put(tmp.toString(), tmp);

        for (Ability ability : abilities.values()) {
            ability.setActor(t2);
        }

        return new AbilitySet(abilities);
    }

    @Before
    public void fillUpPlayer() {

        //Init player
        Player player = (new Player());

        //Init stuff for transporters
        TransportStorage resources = new TransportStorage(200);
        resources.addCoins(new Coins());
        resources.addFuel(new Fuel());
        ParentNode parentNode1 = new ParentLandNode(new StraightRiverSetup(0));
        ParentNode parentNode2 = new ParentLandNode(new TriRiverSetup(0));

        t = new Donkey(player, null);
        t2 = new Rowboat(player,null);

        //Init ability sets
        AbilitySet tAbilitySet = setUpFirstAbilitySet();
        t.setAbilitySet(tAbilitySet);

        AbilitySet t2AbilitySet = setUpSecondAbilitySet();
        t2.setAbilitySet(t2AbilitySet);

        player.addTransporter(t);
        player.addTransporter(t2);

        Player[] players = { player, (new Player()) };
        gameModel.setPlayers(players);
    }

    @Test
    public void keyPressed() throws Exception {
        //Simulate key presses

        System.out.println("class: GameControllerCyclingTest t " + t.toString() + " |");
        int keyCode = KeyEvent.VK_UP; // press the up arrow key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        assert(gameController.getCurrentTransporter().equals(t));

        keyCode = KeyEvent.VK_UP; // press the up arrow key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        assert(gameController.getCurrentTransporter().equals(t));

        keyCode = KeyEvent.VK_DOWN; // press the down arrow key
        gameController.keyPressed(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
        gameController.keyReleased(new KeyEvent(panelManager.getGameViewPanel(), 0, 0, 0, keyCode, 'E', 0));
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