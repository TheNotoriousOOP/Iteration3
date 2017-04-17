package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthLeftAbility extends Ability {
    // Constructor
    public BuildRoadSouthLeftAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthLeft();
    }

    @Override
    public String toString() {
        return "Build Road South Left";
    }

}