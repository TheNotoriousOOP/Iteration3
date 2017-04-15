package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.move_abilities.MoveSouthEastAbility;

/**
 *
 */
public class SouthEast extends ChildDirection {
    public SouthEast() {
        setAbilityEnum(AbilityEnum.MOVE_SOUTHEAST);
        setAbility(new MoveSouthEastAbility());
    }
}
