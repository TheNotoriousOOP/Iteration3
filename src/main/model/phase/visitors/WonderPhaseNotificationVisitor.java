package model.phase.visitors;

import model.game.GameModel;
import model.player.Player;

public class WonderPhaseNotificationVisitor implements PhaseNotificationVisitor {

    private Player activePlayer;

    // Notify the model that the Wonder phase has begun
    public void notifyPhase(GameModel model) {
        model.onWonderPhaseStart();
        activePlayer = model.getActivePlayer();
    }

    public Player getActivePlayer() { return activePlayer; };

}
