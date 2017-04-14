package model.phase;

import model.phase.visitors.MovementPhaseNotificationVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class MovementPhase extends Phase {
    @Override
    void startPhase(ModelMediator mediator) {
        mediator.updateModel(new MovementPhaseNotificationVisitor());
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }
}
