package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.move_abilities.MoveNorthEastAbility;

/**
 *
 */
public class NorthEastLeft extends ChildDirection {
    public NorthEastLeft() {
        setAbility(new MoveNorthEastAbility());
    }
}
