package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthLeftAbility;

/**
 *
 */
public class SouthLeft extends ChildDirection {
    public SouthLeft() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTHLEFT);
        setAbility(new MoveSouthLeftAbility());
    }
}
