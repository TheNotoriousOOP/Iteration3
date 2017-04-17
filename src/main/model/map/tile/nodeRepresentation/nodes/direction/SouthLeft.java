package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthLeftAbility;
import model.ability_management.ability.move_abilities.MoveSouthLeftAbility;

/**
 *
 */
public class SouthLeft extends ChildDirection {
    public SouthLeft() {
        setAbility(new MoveSouthLeftAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthLeftAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthLeftAbility();
    }
}
