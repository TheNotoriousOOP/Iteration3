package model.ability_management.ability.build_abilities;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class BuildOilRigAbility extends Ability {

    // Constructor
    public BuildOilRigAbility() {
        super();
    }

    @Override
    public void perform() {
        getActor().buildOilRig();
    }

    @Override
    public String toString() {
        return "Build Oil Rig";
    }
}
