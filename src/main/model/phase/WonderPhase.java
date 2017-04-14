package model.phase;

import model.phase.visitors.WonderPhaseNotificationVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class WonderPhase extends Phase {
    @Override
    void startPhase(ModelMediator mediator) {
        mediator.updateModel(new WonderPhaseNotificationVisitor());
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }
}
