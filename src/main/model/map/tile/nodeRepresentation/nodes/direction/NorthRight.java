package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.move_abilities.MoveNorthLeftAbility;

/**
 *
 */
public class NorthRight extends ChildDirection {
    public NorthRight() {
        setAbility(new MoveNorthLeftAbility());
    }
}
