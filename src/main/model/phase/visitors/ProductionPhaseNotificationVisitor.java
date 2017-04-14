package model.phase.visitors;

import model.game.GameModel;

public class ProductionPhaseNotificationVisitor implements PhaseNotificationVisitor {

    // Notify that the Production phase has begun
    public void notifyPhase(GameModel model) { model.onProductionPhaseStart(); }

}
