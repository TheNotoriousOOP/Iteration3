package model.phase;

import model.phase.visitors.WonderPhaseNotificationVisitor;

import controller.WonderPhaseController;
import model.player.Player;
import model.wonder.Wonder;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class WonderPhase extends Phase {

    private Wonder wonder;
    private Player player;

    @Override
    void startPhase(ModelMediator mediator) {
        mediator.updateModel(new WonderPhaseNotificationVisitor());
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }

    public void buyBrickWithGold() {

    }

    public void buyBrickWithCoin() {

    }

    public void buyBrickWithStock() {

    }


}
