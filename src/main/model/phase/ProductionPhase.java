package model.phase;

import model.phase.visitors.ProductionPhaseNotificationVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class ProductionPhase extends Phase {
    @Override
    void startPhase(ModelMediator mediator) {
        mediator.updateModel(new ProductionPhaseNotificationVisitor());
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }
}
