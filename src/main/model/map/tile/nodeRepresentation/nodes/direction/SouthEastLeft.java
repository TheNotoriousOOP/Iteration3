package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.move_abilities.MoveSouthEastLeftAbility;

/**
 *
 */
public class SouthEastLeft extends ChildDirection {
    public SouthEastLeft() {
        setAbility(new MoveSouthEastLeftAbility());
    }
}
