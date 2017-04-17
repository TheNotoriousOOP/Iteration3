package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthWestLeftAbility;
import model.ability_management.ability.move_abilities.MoveSouthWestLeftAbility;

/**
 *
 */
public class SouthWestLeft extends ChildDirection {
    public SouthWestLeft() {
        setAbility(new MoveSouthWestLeftAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthWestLeftAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthWestLeftAbility();
    }
}
