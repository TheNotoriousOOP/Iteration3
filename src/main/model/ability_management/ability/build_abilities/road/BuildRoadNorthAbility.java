package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadNorthAbility extends Ability {
    // Constructor
    public BuildRoadNorthAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorth();
    }

    @Override
    public String toString() {
        return "Build Road North";
    }
}
