package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildroadNorthWestRightAbility extends Ability {
    // Constructor
    public BuildroadNorthWestRightAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorthWestRight();
    }

    @Override
    public String toString() {
        return "Build Road Northwest Right";
    }
}
