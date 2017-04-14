package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.move_abilities.MoveNorthLeftAbility;

/**
 *
 */
public class NorthLeft extends ChildDirection {
    public NorthLeft() {
        setAbility(new MoveNorthLeftAbility());
    }
}
