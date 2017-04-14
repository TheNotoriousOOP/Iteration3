package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveNorthEastAbility;

/**
 *
 */
public class NorthEast extends ChildDirection {
    public NorthEast() {
        setAbilityEnum(AbilityEnum.MOVE_NORTHEAST);
    }
}
