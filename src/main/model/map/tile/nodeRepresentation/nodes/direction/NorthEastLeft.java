package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthEastAbility;
import model.ability_management.ability.move_abilities.MoveNorthEastLeftAbility;

/**
 *
 */
public class NorthEastLeft extends ChildDirection {
    public NorthEastLeft() {
        setAbilityEnum(AbilityEnum.MOVE_NORTHEASTLEFT);
        setAbility(new MoveNorthEastLeftAbility());
    }
}
