package model.ability_management.ability.build_abilities;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class BuildCoalBurnerAbility extends Ability {

    // Constructor
    public BuildCoalBurnerAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildCoalBurner();
    }

    @Override
    public String toString() {
        return "Build Coal Burner";
    }
}
