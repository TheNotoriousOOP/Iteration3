package model.ability_management.ability.wonder_abilities;

import model.ability_management.ability.Ability;
import model.phase.WonderPhase;
import model.transporters.Transporter;

/**
 * Created by Customer-PC on 4/14/2017.
 */
public class BuyBrickWithGoldAbility extends Ability {
    private WonderPhase wonderPhase;

    public BuyBrickWithGoldAbility(Transporter actor, boolean isListening, WonderPhase phase) {
        //super(actor, isListening);
        this.wonderPhase = phase;
    }

    public void perform() { wonderPhase.buyBrickWithGold(); }
}
