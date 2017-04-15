package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthRightAbility;

/**
 *
 */
public class SouthRight extends ChildDirection {
    public SouthRight() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTHRIGHT);
        setAbility(new MoveSouthRightAbility());
    }
}
