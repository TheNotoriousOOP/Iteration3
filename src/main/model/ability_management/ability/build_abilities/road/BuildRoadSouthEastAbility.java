package model.ability_management.ability.build_abilities.road;


import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthEastAbility extends Ability {
    // Constructor
    public BuildRoadSouthEastAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthEast();
    }

    @Override
    public String toString() {
        return "Build Road Southeast";
    }

}
