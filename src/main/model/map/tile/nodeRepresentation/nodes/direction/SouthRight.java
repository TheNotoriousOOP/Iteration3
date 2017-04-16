package model.map.tile.nodeRepresentation.nodes.direction;
import model.ability_management.ability.Ability;
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
}
