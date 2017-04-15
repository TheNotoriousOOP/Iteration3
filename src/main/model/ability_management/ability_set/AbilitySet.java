package model.ability_management.ability_set;

import model.ability_management.ability.Ability;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class AbilitySet {
    //not using this
    private ArrayList<Ability> invalidAbilities;

    private ArrayList<Ability> validAbilities;

    //not using this constructor
    public AbilitySet(ArrayList<Ability> invalidAbilities, ArrayList<Ability> validAbilities) {
        this.invalidAbilities = invalidAbilities;
        this.validAbilities = validAbilities;
    }

    public AbilitySet(ArrayList<Ability> validAbilities){
        this.validAbilities = validAbilities;

    }

    public void updateAbilitiesByNode(ArrayList<Ability> nodeValidAbilities){
        validAbilities.addAll(nodeValidAbilities);
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
}
