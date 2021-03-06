package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthAbility;
import model.ability_management.ability.move_abilities.MoveSouthAbility;

/**
 *
 */
public class South extends ChildDirection {
    public South() {
        setAbility(new MoveSouthAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthAbility();
    }
}
