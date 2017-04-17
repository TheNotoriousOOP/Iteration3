package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthWestAbility;
import model.ability_management.ability.move_abilities.MoveSouthWestRightAbility;

/**
 *
 */
public class SouthWestRight extends ChildDirection {
    public SouthWestRight() {
        setAbility(new MoveSouthWestRightAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthWestRightAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthWestAbility();
    }
}
