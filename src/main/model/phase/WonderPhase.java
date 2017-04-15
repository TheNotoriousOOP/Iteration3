package model.phase;

import model.phase.visitors.WonderPhaseNotificationVisitor;

import model.player.Player;
import model.resources.resourceVisitor.CoinVisitor;
import model.resources.resourceVisitor.GoldVisitor;
import model.resources.resourceVisitor.StockVisitor;
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
    public void startPhase(ModelMediator mediator) {
        WonderPhaseNotificationVisitor visitor = new WonderPhaseNotificationVisitor();
        mediator.updateModel(visitor);
        currentPlayer = visitor.getActivePlayer();
        wonder.resetPlayerModifier();
        //Swap controller
    }

    @Override
    public void endPhase(ModelMediator mediator) {
        //TODO implement
    }

    public void buyBrickWithGold() {
        currentPlayer.decrementStarterTileGoods(wonder.getBrickCost(currentPlayer), new GoldVisitor());
        wonder.build(currentPlayer);
    }

    public void buyBrickWithCoin() {
        currentPlayer.decrementStarterTileGoods(wonder.getBrickCost(currentPlayer), new CoinVisitor());
        wonder.build(currentPlayer);
    }

    public void buyBrickWithStock() {
        currentPlayer.decrementStarterTileGoods(wonder.getBrickCost(currentPlayer), new StockVisitor());
        wonder.build(currentPlayer);
    }


}
