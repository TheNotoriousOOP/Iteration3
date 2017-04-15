package model.ability_management.ability.produce_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class ProduceFuelAbility extends Ability {

    public ProduceFuelAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    @Override
    public String toString(){
        return "Produce Fuel";
    }
}
