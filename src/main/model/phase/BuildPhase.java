package model.phase;

import model.phase.visitors.BuildPhaseNotificationVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class BuildPhase extends Phase {

    @Override
    void startPhase(ModelMediator mediator) {
        mediator.updateModel(new BuildPhaseNotificationVisitor());
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }

}
