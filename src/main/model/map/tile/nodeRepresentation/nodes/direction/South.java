package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.move_abilities.MoveSouthAbility;

/**
 *
 */
public class South extends ChildDirection {
    public South() {
        setAbility(new MoveSouthAbility());
    }
}
