package model.ability_management.ability.build_abilities.road;


import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthWestLeftAbility extends Ability {
    // Constructor
    public BuildRoadSouthWestLeftAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthWestLeft();
    }

    @Override
    public String toString() {
        return "Build Road Southwest Left";
    }

}
