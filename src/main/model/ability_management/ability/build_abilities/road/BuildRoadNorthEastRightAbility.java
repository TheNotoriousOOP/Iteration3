package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadNorthEastRightAbility extends Ability {
    // Constructor
    public BuildRoadNorthEastRightAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorthEastRight();
    }

    @Override
    public String toString() {
        return "Build Road Northeast Right";
    }
}
