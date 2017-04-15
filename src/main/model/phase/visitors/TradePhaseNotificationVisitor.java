package model.phase.visitors;

import model.game.GameModel;

public class TradePhaseNotificationVisitor implements PhaseNotificationVisitor {

    // Notify the trade phase has begun
    public void notifyPhase(GameModel model) { model.onTradePhaseStart(); }

}
