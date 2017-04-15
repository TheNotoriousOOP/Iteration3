import model.ability_management.ability.Ability;
import model.ability_management.ability.resource_abilities.DropOffBoardAbility;
import model.ability_management.ability.resource_abilities.PickUpBoardUtility;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.Boards;
import model.resources.TransportStorage;
import model.resources.resourceVisitor.AddResourceVisitor;
import model.resources.resourceVisitor.BoardVisitor;
import model.resources.resourceVisitor.RemoveResourceVisitor;
import model.transporters.Transporter;
import model.transporters.land_transporters.Donkey;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class ResourceAbilityTest {

    @Test
    public void basicResourceAbilityTest() {
        ParentLandNode p = new ParentLandNode(null);
        Transporter t = new Donkey(null, null, new TransportStorage(5), null, p, 5);
        Boards b = new Boards();
        t.getResources().addBoards(b);

        Ability a = new DropOffBoardAbility();
        a.setActor(t);
        a.perform();
        BoardVisitor bb = new BoardVisitor();
        p.acceptResourceVisitor(new RemoveResourceVisitor(bb));
        assertEquals(b,bb.getBoards());
        assertEquals(0, t.getResources().getBoardsArrayList().size());
        p.acceptResourceVisitor(new AddResourceVisitor(bb));

        a = new PickUpBoardUtility();
        a.setActor(t);
        a.perform();
        assertEquals(b, t.getResources().getBoardsArrayList().get(0));
    }


}
