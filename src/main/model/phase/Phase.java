package model.phase;

import model.ability_management.ability.Ability;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Phase {

    // Start the chosen phase
    abstract void startPhase(ModelMediator mediator);

    // End the chosen phase
    abstract void endPhase(ModelMediator mediator);

    // Clear all nodes
    public void clearAllNode() {
        // Todo: implement
    }

}
