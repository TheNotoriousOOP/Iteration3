package model.phase.visitors;

import model.game.GameModel;

// Notify GameModel of current phase initiated
public interface PhaseNotificationVisitor {
    void notifyPhase(GameModel model);
}
