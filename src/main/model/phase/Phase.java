package model.phase;

import model.ability_management.ability.Ability;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Phase {

    private Ability[] phaseAbilities;

    abstract void startPhase();
    abstract void endPhase();

    public void clearAllNode(){
        //TODO implement
    }

    public Ability[] getPhaseAbilities() {
        return phaseAbilities;
    }

    public void setPhaseAbilities(Ability[] phaseAbilities) {
        this.phaseAbilities = phaseAbilities;
    }
}
