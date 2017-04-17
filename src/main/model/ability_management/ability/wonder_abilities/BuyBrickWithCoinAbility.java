package model.ability_management.ability.wonder_abilities;

import model.ability_management.ability.Ability;
import model.phase.WonderPhase;
import model.resources.resourceVisitor.CoinVisitor;
import model.transporters.Transporter;

/**
 * Created by Customer-PC on 4/14/2017.
 */
public class BuyBrickWithCoinAbility extends Ability{

    private WonderPhase wonderPhase;

    public BuyBrickWithCoinAbility(WonderPhase phase) {
        this.wonderPhase = phase;
    }

    public void perform() {
        wonderPhase.buyBrick(new CoinVisitor());
        //Cake is baked
        getActor().updateWonderAbilitySet(wonderPhase.generateAbilitySet(getActor().getOwner()));
        getActor().getAbilitySet().addActorToSet(getActor());
    }

    public String toString() {
        return "Buy Brick With Coin";
    }
}
