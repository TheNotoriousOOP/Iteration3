package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthRightAbility extends Ability {
    // Constructor
    public BuildRoadSouthRightAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthRight();
    }

    @Override
    public String toString() {
        return "Build Road South Right";
    }

}