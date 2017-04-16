package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
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
}
