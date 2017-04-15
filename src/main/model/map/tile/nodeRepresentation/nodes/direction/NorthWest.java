package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthWestAbility;

/**
 *
 */
public class NorthWest extends ChildDirection {
    public NorthWest() {
        setAbilityEnum(AbilityEnum.MOVE_NORTHWEST);
        setAbility(new MoveNorthWestAbility());
    }
}
