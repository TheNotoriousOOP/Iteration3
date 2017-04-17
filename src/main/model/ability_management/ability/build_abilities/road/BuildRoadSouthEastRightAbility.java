package model.ability_management.ability.build_abilities.road;


import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthEastRightAbility extends Ability {
    // Constructor
    public BuildRoadSouthEastRightAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthEastRight();
    }

    @Override
    public String toString() {
        return "Build Road Southright";
    }

}
