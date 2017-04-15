package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.map.tile.nodeRepresentation.nodes.direction.SouthWest;
import model.transporters.Transporter;

/**
 *
 */
public class MoveSouthWestLeftAbility extends Ability {

    public MoveSouthWestLeftAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveSouthWestLeftAbility(){

    }

    @Override
    public String toString() {
        return "Move Southwest Left";
    }
}
