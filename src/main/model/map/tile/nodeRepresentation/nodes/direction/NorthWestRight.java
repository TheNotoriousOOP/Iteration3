package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildroadNorthWestRightAbility;
import model.ability_management.ability.move_abilities.MoveNorthWestRightAbility;

/**
 *
 */
public class NorthWestRight extends ChildDirection {
    public NorthWestRight() {

        setAbility(new MoveNorthWestRightAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthWestRightAbility(); }

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildroadNorthWestRightAbility();
    }
}
