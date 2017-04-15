package model.phase.visitors;

import model.game.GameModel;

public class BuildPhaseNotificationVisitor implements PhaseNotificationVisitor {

    // Notify model that Build phase has begun
    public void notifyPhase(GameModel model) { model.onBuildPhaseStart(); }

}
