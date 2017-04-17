package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadNorthAbility;
import model.ability_management.ability.move_abilities.MoveNorthAbility;

/**
 *
 */
public class North extends ChildDirection {
    public North() {

        setAbility(new MoveNorthAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthAbility(); }

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadNorthAbility();
    }
}
