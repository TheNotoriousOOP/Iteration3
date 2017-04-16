package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadNorthWestAbility;
import model.ability_management.ability.move_abilities.MoveNorthWestAbility;

/**
 *
 */
public class NorthWest extends ChildDirection {
    public NorthWest() {

        setAbility(new MoveNorthWestAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthWestAbility(); }

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadNorthWestAbility();
    }
}
