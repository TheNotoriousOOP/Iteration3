package model.ability_management.ability.build_abilities.road;


import model.ability_management.ability.Ability;

/**
 *
 */
public class BuildRoadSouthWestAbility extends Ability {
    // Constructor
    public BuildRoadSouthWestAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildRoadSouthWest();
    }

    @Override
    public String toString() {
        return "Build Road Southwest";
    }

}