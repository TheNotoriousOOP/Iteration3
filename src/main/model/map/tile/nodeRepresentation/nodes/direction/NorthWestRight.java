package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthWestRightAbility;

/**
 *
 */
public class NorthWestRight extends ChildDirection {
    public NorthWestRight() {
        setAbilityEnum(AbilityEnum.MOVE_NORTHWESTRIGHT);
        setAbility(new MoveNorthWestRightAbility());
    }
}
