package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthAbility;

/**
 *
 */
public class South extends ChildDirection {
    public South() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTH);
        setAbility(new MoveSouthAbility());
    }
}
