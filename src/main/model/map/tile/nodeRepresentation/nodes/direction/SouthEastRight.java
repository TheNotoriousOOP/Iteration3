package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.move_abilities.MoveSouthEastRightAbility;

/**
 *
 */
public class SouthEastRight extends ChildDirection {
    public SouthEastRight() {
        setAbility(new MoveSouthEastRightAbility());
    }
}
