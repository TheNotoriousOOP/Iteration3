package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.move_abilities.MoveSouthWestRightAbility;

/**
 *
 */
public class SouthWestRight extends ChildDirection {
    public SouthWestRight() {
        setAbility(new MoveSouthWestRightAbility());
    }
}
