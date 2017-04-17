package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadNorthRightAbility;
import model.ability_management.ability.move_abilities.MoveNorthRightAbility;

/**
 *
 */
public class NorthRight extends ChildDirection {
    public NorthRight() {

        setAbility(new MoveNorthRightAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthRightAbility(); }

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadNorthRightAbility();
    }
}
