package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthEastLeftAbility;

/**
 *
 */
public class SouthEastLeft extends ChildDirection {
    public SouthEastLeft() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTHEASTLEFT);
        setAbility(new MoveSouthEastLeftAbility());
    }
}
