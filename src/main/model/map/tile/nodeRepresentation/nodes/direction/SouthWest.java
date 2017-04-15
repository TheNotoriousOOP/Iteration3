package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthWestAbility;

/**
 *
 */
public class SouthWest extends ChildDirection {
    public SouthWest() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTHWEST);
        setAbility(new MoveSouthWestAbility());
    }
}
