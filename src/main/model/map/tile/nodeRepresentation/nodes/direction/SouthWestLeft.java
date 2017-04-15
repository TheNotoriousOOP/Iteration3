package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthWestLeftAbility;

/**
 *
 */
public class SouthWestLeft extends ChildDirection {
    public SouthWestLeft() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTHWESTLEFT);
        setAbility(new MoveSouthWestLeftAbility());
    }
}
