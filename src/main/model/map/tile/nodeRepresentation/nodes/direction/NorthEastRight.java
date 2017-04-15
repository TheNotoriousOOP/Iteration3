package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.move_abilities.MoveNorthEastRightAbility;

/**
 *
 */
public class NorthEastRight extends ChildDirection {
    public NorthEastRight() {

        setAbility(new MoveNorthEastRightAbility());
    }
}
