package model.ability_management.ability_set;

import model.ability_management.ability.Ability;
import model.transporters.MyBidirectionalIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class AbilitySet implements Iterable<Ability> {

    private ArrayList<Ability> invalidAbilities;
    private ArrayList<Ability> validAbilities;

    public AbilitySet(ArrayList<Ability> invalidAbilities, ArrayList<Ability> validAbilities) {
        this.invalidAbilities = invalidAbilities;
        this.validAbilities = validAbilities;
    }

    public void updateAbilitiesByNode(ArrayList<Ability> nodeValidAbilities){
        //TODO implement
    }

    public ArrayList<Ability> getInvalidAbilities() {
        return invalidAbilities;
    }

    public void setInvalidAbilities(ArrayList<Ability> invalidAbilities) {
        this.invalidAbilities = invalidAbilities;
    }

    public ArrayList<Ability> getValidAbilities() {
        return validAbilities;
    }

    public void setValidAbilities(ArrayList<Ability> validAbilities) {
        this.validAbilities = validAbilities;
    }

    @Override
    public MyBidirectionalIterator<Ability> iterator() {
        return new MyBidirectionalIterator<>(validAbilities);
    }
}
