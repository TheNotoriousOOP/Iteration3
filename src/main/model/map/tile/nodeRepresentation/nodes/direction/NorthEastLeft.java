package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.move_abilities.MoveNorthEastLeftAbility;

/**
 *
 */
public class NorthEastLeft extends ChildDirection {
    public NorthEastLeft() {

        setAbility(new MoveNorthEastLeftAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthEastLeftAbility(); }
}
