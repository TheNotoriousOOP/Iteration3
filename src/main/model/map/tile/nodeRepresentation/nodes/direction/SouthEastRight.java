package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthEastRightAbility;
import model.ability_management.ability.move_abilities.MoveSouthEastRightAbility;

/**
 *
 */
public class SouthEastRight extends ChildDirection {
    public SouthEastRight() {
        setAbility(new MoveSouthEastRightAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthEastRightAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthEastRightAbility();
    }
}
