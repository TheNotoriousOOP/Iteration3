package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
import model.ability_management.ability.move_abilities.MoveSouthEastAbility;

/**
 *
 */
public class SouthEast extends ChildDirection {
    public SouthEast() {
        setAbility(new MoveSouthEastAbility());
    }


    @Override
    public Ability getAbility() { return new MoveSouthEastAbility();}
}
