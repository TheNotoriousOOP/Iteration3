package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadNorthEastAbility;
import model.ability_management.ability.move_abilities.MoveNorthEastAbility;

/**
 *
 */
public class NorthEast extends ChildDirection {
    public NorthEast() {

        setAbility(new MoveNorthEastAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthEastAbility(); }

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadNorthEastAbility();
    }

}
