package model.phase.visitors;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.game.GameModel;
import model.phase.WonderPhase;
import model.phase.WonderPhaseMediator;
import model.player.Player;

public class WonderPhaseNotificationVisitor implements PhaseNotificationVisitor {

    private Player activePlayer;
    private WonderPhaseMediator mediator;

    public WonderPhaseNotificationVisitor(WonderPhaseMediator mediator) {
    }

    // Notify the model that the Wonder phase has begun
    public void notifyPhase(GameModel model) {
        model.onWonderPhaseStart(mediator);
        activePlayer = model.getActivePlayer();
    }

    public Player getActivePlayer() { return activePlayer; };
    public AbilitySet getWonderAbilitySet() { return getWonderAbilitySet(); }

}
