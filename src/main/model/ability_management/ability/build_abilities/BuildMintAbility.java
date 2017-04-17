package model.ability_management.ability.build_abilities;

import model.ability_management.ability.Ability;

public class BuildMintAbility extends Ability {

    // Constructor
    public BuildMintAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildMint();
    }

    @Override
    public String toString() {
        return "Build Mint";
    }

}
