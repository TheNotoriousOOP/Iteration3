package model.ability_management.ability.build_abilities.road;


import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthEastLeftAbility extends Ability {
    // Constructor
    public BuildRoadSouthEastLeftAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthEastLeft();
    }

    @Override
    public String toString() {
        return "Build Road Southeast Left";
    }

}
