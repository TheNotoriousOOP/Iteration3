package model.ability_management.ability_set;

import model.ability_management.ability.Ability;
import model.transporters.Transporter;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class AbilitySet {
    //not using this
    private ArrayList<Ability> invalidAbilities;

    private ArrayList<Ability> validAbilities = new ArrayList<>();

    //not using this constructor
    public AbilitySet(ArrayList<Ability> invalidAbilities, ArrayList<Ability> validAbilities) {
        this.invalidAbilities = invalidAbilities;
        this.validAbilities = validAbilities;
    }

    public AbilitySet(){

    }

    public AbilitySet(ArrayList<Ability> validAbilities){
        this.validAbilities = validAbilities;

    }


    //set the actor of each ability in the set
    public void addActorToSet(Transporter t){
        for (Ability ability : validAbilities){
            ability.setActor(t);
        }
    }



    public ArrayList<Ability> getValidAbilities() {
        return validAbilities;
    }

    public void setValidAbilities(ArrayList<Ability> validAbilities) {
        this.validAbilities = validAbilities;
    }

    public void addValidAbility(Ability ability){
        validAbilities.add(ability);
    }

    public void removeAbilityFromValidList(Ability ability){
        validAbilities.remove(ability);
    }
}
