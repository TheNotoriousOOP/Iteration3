package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthLeftAbility;
import model.ability_management.ability.move_abilities.MoveNorthRightAbility;

/**
 *
 */
public class NorthRight extends ChildDirection {
    public NorthRight() {
        setAbilityEnum(AbilityEnum.MOVE_NORTHRIGHT);
        setAbility(new MoveNorthRightAbility());
    }
}
