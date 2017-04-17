package model.ability_management.ability.build_abilities;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class BuildWagonFactoryAbility extends Ability {

    // Constructor
    public BuildWagonFactoryAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildWagonFactory();
    }

    @Override
    public String toString() {
        return "Build Wagon Factory";
    }
}
