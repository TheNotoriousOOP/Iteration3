package model.ability_management.ability.build_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class BuildRowboatFactoryAbility extends Ability {

    public BuildRowboatFactoryAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    @Override
    public String toString() {
        return "Build Rowboat Factory";
    }
}
