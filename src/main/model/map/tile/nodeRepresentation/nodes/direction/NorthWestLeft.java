package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthWestLeftAbility;

/**
 *
 */
public class NorthWestLeft extends ChildDirection {
    public NorthWestLeft() {
        setAbilityEnum(AbilityEnum.MOVE_NORTHWESTLEFT);
        setAbility(new MoveNorthWestLeftAbility());
    }
}
