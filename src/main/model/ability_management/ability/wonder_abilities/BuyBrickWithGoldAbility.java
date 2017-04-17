package model.ability_management.ability.wonder_abilities;

import model.ability_management.ability.Ability;
import model.phase.WonderPhase;
import model.phase.WonderPhaseMediator;
import model.resources.resourceVisitor.GoldVisitor;
import model.transporters.Transporter;

/**
 * Created by Customer-PC on 4/14/2017.
 */
public class BuyBrickWithGoldAbility extends Ability {
    private WonderPhase wonderPhase;

    public BuyBrickWithGoldAbility(WonderPhase phase) {
        //super(actor, isListening);
        this.wonderPhase = phase;
    }

    public void perform() {
        wonderPhase.buyBrick(new GoldVisitor());
        getActor().updateWonderAbilitySet(wonderPhase.generateAbilitySet(getActor().getOwner()));
        getActor().getAbilitySet().addActorToSet(getActor());
    }

    public String toString() {
        return "Buy Brick With Gold";
    }
}
