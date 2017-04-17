package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadNorthRightAbility extends Ability {
    // Constructor
    public BuildRoadNorthRightAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorthRight();
    }

    @Override
    public String toString() {
        return "Build Road North Right";
    }
}
