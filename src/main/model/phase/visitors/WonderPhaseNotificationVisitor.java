package model.phase.visitors;

import model.game.GameModel;

public class WonderPhaseNotificationVisitor implements PhaseNotificationVisitor {

    // Notify the model that the Wonder phase has begun
    public void notifyPhase(GameModel model) { model.onWonderPhaseStart(); }

}
