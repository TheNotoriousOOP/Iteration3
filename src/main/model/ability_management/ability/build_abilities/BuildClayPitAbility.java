package model.ability_management.ability.build_abilities;
import model.ability_management.ability.Ability;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class BuildClayPitAbility extends Ability {

    // Constructor
    public BuildClayPitAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildClayPit();
    }

    @Override
    public String toString() {
        return "Build Clay Pit";
    }
}
