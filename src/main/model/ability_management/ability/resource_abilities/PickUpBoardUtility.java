package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.BoardVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpBoardUtility extends Ability {

    public PickUpBoardUtility(){}

    @Override
    public void perform() {
        getActor().pickupFromNode(new BoardVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Board";
    }
}
