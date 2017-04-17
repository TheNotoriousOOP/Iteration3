package model.ability_management.ability.build_abilities.road;

import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadNorthWestAbility extends Ability {
    // Constructor
    public BuildRoadNorthWestAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadNorthWest();
    }

    @Override
    public String toString() {
        return "Build Road Northwest";
    }
}
