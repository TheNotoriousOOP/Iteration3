package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadNorthEastLeftAbility extends Ability {
    // Constructor
    public BuildRoadNorthEastLeftAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorthEastLeft();
    }

    @Override
    public String toString() {
        return "Build Road Northeast Left";
    }
}
