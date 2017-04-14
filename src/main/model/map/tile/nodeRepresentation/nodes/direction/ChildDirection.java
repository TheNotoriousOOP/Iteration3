package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;

/**
 *
 */
public abstract class ChildDirection {
    protected Ability ability;
    protected AbilityEnum abilityEnum;

    public AbilityEnum getAbilityEnum() {
        return abilityEnum;
    }

    protected void setAbilityEnum(AbilityEnum abilityEnum) {
        this.abilityEnum = abilityEnum;
    }


}
