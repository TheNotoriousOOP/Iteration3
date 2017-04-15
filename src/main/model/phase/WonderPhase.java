package model.phase;

import model.phase.visitors.WonderPhaseNotificationVisitor;

import model.player.Player;
import model.wonder.Wonder;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class WonderPhase extends Phase {

    private Wonder wonder;

    //POOP:Is this a bad friend?
    private Player currentPlayer;

    @Override
    void startPhase(ModelMediator mediator) {
        WonderPhaseNotificationVisitor visitor = new WonderPhaseNotificationVisitor();
        mediator.updateModel(visitor);
        currentPlayer = visitor.getActivePlayer();
        wonder.resetPlayerModifier();
        //Swap controller
    }

    @Override
    void endPhase(ModelMediator mediator) {
        //TODO implement
    }

    public void buyBrickWithGold() {
        currentPlayer.decrementStarterTileGold(wonder.getBrickCost(currentPlayer));
        wonder.build(currentPlayer);
    }

    public void buyBrickWithCoin() {
        currentPlayer.decrementStarterTileCoin(wonder.getBrickCost(currentPlayer));
        wonder.build(currentPlayer);
    }

    public void buyBrickWithStock() {
        currentPlayer.decrementStarterTileStock(wonder.getBrickCost(currentPlayer));
        wonder.build(currentPlayer);
    }


}
