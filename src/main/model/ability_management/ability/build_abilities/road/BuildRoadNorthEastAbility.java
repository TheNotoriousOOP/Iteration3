package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadNorthEastAbility extends Ability {
    // Constructor
    public BuildRoadNorthEastAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorthEast();
    }

    @Override
    public String toString() {
        return "Build Road Northeast";
    }
}
