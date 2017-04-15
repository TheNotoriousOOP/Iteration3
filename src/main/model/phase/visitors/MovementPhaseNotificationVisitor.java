package model.phase.visitors;

import model.game.GameModel;

public class MovementPhaseNotificationVisitor implements PhaseNotificationVisitor {

    // Notify that the Movement phase has begun
    public void notifyPhase(GameModel model) { model.onMovementPhaseStart(); }

}
