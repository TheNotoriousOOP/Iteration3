package model.phase;

import model.ability_management.ability_set.AbilitySet;
import model.player.Player;

/**
 * Created by Customer-PC on 4/16/2017.
 */
public class WonderPhaseMediator {

    private WonderPhase phase;

    public WonderPhaseMediator(WonderPhase phase) {
        this.phase = phase;
    }

    public AbilitySet generateAbilitySet(Player player) {
        return phase.generateAbilitySet(player);
    }
}
