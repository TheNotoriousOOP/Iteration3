package model.phase;

import model.ability_management.ability.Ability;
import model.ability_management.ability.wonder_abilities.BuyBrickWithCoinAbility;
import model.ability_management.ability.wonder_abilities.BuyBrickWithGoldAbility;
import model.ability_management.ability.wonder_abilities.BuyBrickWithStockAbility;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.phase.visitors.WonderPhaseNotificationVisitor;
import model.player.Player;
import model.resources.resourceVisitor.*;
import model.wonder.Wonder;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class WonderPhase extends Phase {

    private Wonder wonder;

    //POOP:Is this a bad friend?
    private Player currentPlayer;

    public WonderPhase() {
        this.wonder = new Wonder();
    }




    @Override
    public void startPhase(ModelMediator mediator) {
        WonderPhaseNotificationVisitor visitor = new WonderPhaseNotificationVisitor(new WonderPhaseMediator(this));
        mediator.updateModel(visitor);
        currentPlayer = visitor.getActivePlayer();
        wonder.resetPlayerModifier();
        //Swap controller
    }

    @Override
    public void endPhase(ModelMediator mediator) {
        //TODO implement
    }


    public void buyBrick(InnerResourceVisitor good) {
        currentPlayer.decrementStarterTileGoods(wonder.getBrickCost(currentPlayer), good);
        wonder.build(currentPlayer);
    }

    public AbilitySet generateAbilitySet(Player player) {
        ArrayList<Ability> map = new ArrayList<Ability>();
        int cost = wonder.getBrickCost(player);
        //No mutations are carried out on location, so TDA is not violated
        ParentLandNode location = player.getStartingLocation();

        CountResourceVisitor v = new CountResourceVisitor(new GoldVisitor());
        location.acceptResourceVisitor(v);
        Ability ability = new BuyBrickWithGoldAbility(this);
        if(v.getAmount() >= cost)
            map.add(ability);

        v = new CountResourceVisitor(new CoinVisitor());
        location.acceptResourceVisitor(v);
        ability = new BuyBrickWithCoinAbility(this);
        if(v.getAmount() >= cost)
            map.add(ability);

        v = new CountResourceVisitor(new StockVisitor());
        location.acceptResourceVisitor(v);
        ability = new BuyBrickWithStockAbility(this);
        if(v.getAmount() >= cost)
            map.add(ability);

        return new AbilitySet(map);
    }

    //DELETE BEFORE TURN IN
    public void zzzTESTING_setPlayer(Player player) {
        System.err.println("If this is appearing in production shit's fucked");
        this.currentPlayer = player;
    }
}
