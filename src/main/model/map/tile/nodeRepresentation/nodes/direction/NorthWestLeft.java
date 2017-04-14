package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.move_abilities.MoveNorthWestLeftAbility;

/**
 *
 */
public class NorthWestLeft extends ChildDirection {
    public NorthWestLeft() {
        setAbility(new MoveNorthWestLeftAbility());
    }
}
