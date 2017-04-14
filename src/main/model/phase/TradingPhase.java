package model.phase;

import model.phase.visitors.TradePhaseNotificationVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TradingPhase extends Phase {
    @Override
    void startPhase(ModelMediator mediator) {
        mediator.updateModel(new TradePhaseNotificationVisitor());
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }
}
