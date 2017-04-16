package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthRightAbility;
import model.ability_management.ability.move_abilities.MoveSouthRightAbility;

/**
 *
 */
public class SouthRight extends ChildDirection {
    public SouthRight() {
        setAbility(new MoveSouthRightAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthRightAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthRightAbility();
    }
}
