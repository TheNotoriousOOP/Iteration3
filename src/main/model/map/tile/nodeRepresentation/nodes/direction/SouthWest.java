package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.road.BuildRoadSouthWestAbility;
import model.ability_management.ability.move_abilities.MoveSouthWestAbility;

/**
 *
 */
public class SouthWest extends ChildDirection {
    public SouthWest() {
        setAbility(new MoveSouthWestAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthWestAbility();}

    @Override
    public Ability getBuildRoadAbility() {
        return new BuildRoadSouthWestAbility();
    }
}
