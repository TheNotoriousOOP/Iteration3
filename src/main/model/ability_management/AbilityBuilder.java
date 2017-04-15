package model.ability_management;

import model.ability_management.ability.Ability;
import model.ability_management.ability.move_abilities.*;
import model.transporters.Transporter;

/**
 * Passes in AbilityEnum and Transporter to init the correct Ability
 */
public class AbilityBuilder {
    public Ability getAbility(Transporter transporter, AbilityEnum abilityEnum){
        switch (abilityEnum){
            //movement abilities
            //N
            case MOVE_NORTH:
                return new MoveNorthAbility(transporter, abilityEnum);
            case MOVE_NORTHLEFT:
                return new MoveNorthLeftAbility(transporter, abilityEnum);
            case MOVE_NORTHRIGHT:
                return new MoveNorthRightAbility(transporter, abilityEnum);

            //NE
            case MOVE_NORTHEAST:
                return new MoveNorthEastAbility(transporter, abilityEnum);
            case MOVE_NORTHEASTLEFT:
                return new MoveNorthEastLeftAbility(transporter, abilityEnum);
            case MOVE_NORTHEASTRIGHT:
                return new MoveNorthEastRightAbility(transporter, abilityEnum);

            //NW
            case MOVE_NORTHWEST:
                return new MoveNorthWestAbility(transporter, abilityEnum);
            case MOVE_NORTHWESTLEFT:
                return new MoveNorthWestLeftAbility(transporter, abilityEnum);
        }
        return null;
    }
}
