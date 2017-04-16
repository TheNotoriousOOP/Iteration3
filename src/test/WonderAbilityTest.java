import model.ability_management.ability.Ability;
import model.ability_management.ability.wonder_abilities.BuyBrickWithGoldAbility;
import model.ability_management.ability.wonder_abilities.BuyBrickWithStockAbility;
import model.ability_management.ability_set.AbilitySet;
import model.game.GameModel;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.phase.WonderPhase;
import model.player.Player;
import model.resources.Gold;
import model.resources.resourceVisitor.AddResourceVisitor;
import model.resources.resourceVisitor.CountResourceVisitor;
import model.resources.resourceVisitor.GoldVisitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Customer-PC on 4/16/2017.
 */
public class WonderAbilityTest {

    private WonderPhase phase;
    private Player player;

    @Before
    public void setup() {
        phase = new WonderPhase();
        player = new Player();
        phase.zzzTESTING_setPlayer(player);
    }

    @Test
    public void basicWonderAbilityTest() {
        ParentLandNode location = new ParentLandNode(null);
        GoldVisitor resource = new GoldVisitor();
        for(int iii = 0; iii < 10; iii++) {
            resource.setGold(new Gold());
            location.acceptResourceVisitor(new AddResourceVisitor(resource));
        }
        player.setStartingLocation(location);
        Ability buyGold = new BuyBrickWithGoldAbility(phase);

        buyGold.perform();
        CountResourceVisitor v = new CountResourceVisitor(resource);
        location.acceptResourceVisitor(v);
        assertEquals(9, v.getAmount());

        buyGold.perform();
        location.acceptResourceVisitor(v);
        assertEquals(7, v.getAmount());

        AbilitySet set = phase.generateAbilitySet(player);
        assert set.getValidAbilities().containsKey(buyGold.toString());
        assert !set.getValidAbilities().containsKey(new BuyBrickWithStockAbility(null).toString());
    }

}
