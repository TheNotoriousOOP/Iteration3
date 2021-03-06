package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.BoardVisitor;
import model.resources.resourceVisitor.CoinVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffCoinAbility extends Ability {

    public DropOffCoinAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new CoinVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Coin";
    }
}
