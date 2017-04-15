package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthAbility;

/**
 *
 */
public class North extends ChildDirection {
    public North() {
        setAbilityEnum(AbilityEnum.MOVE_NORTH);
        setAbility(new MoveNorthAbility());
    }
}
