package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadNorthEastRightAbility;
import model.ability_management.ability.move_abilities.MoveNorthEastRightAbility;

/**
 *
 */
public class NorthEastRight extends ChildDirection {
    public NorthEastRight() {

        setAbility(new MoveNorthEastRightAbility());
    }

    @Override
    public Ability getAbility() { return new MoveNorthEastRightAbility(); }

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadNorthEastRightAbility();
    }
}
