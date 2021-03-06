package model.ability_management.ability_set;

import model.ability_management.ability.Ability;
import model.transporters.MyBidirectionalIterator;
import model.transporters.Transporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */

public class AbilitySet implements Iterable<Ability> {

    private ArrayList<Ability> validAbilities = new ArrayList<>();

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

    @Override
    public MyBidirectionalIterator<Ability> iterator() {
        return new MyBidirectionalIterator<Ability>(new ArrayList<>(validAbilities));
    }

    public void addValidAbility(Ability ability){
        validAbilities.add(ability);
    }

    public void appendToValidAbility(AbilitySet moreValidAbilities) {
        validAbilities.addAll(moreValidAbilities.getValidAbilities());
    }

    public void removeAbilityFromValidList(Ability ability){
        validAbilities.remove(ability);
    }

    @Override
    public String toString() {
        String myString = "";
        for (Ability ability : validAbilities) {
            myString = myString + ability.toString() + ",";
        }
        return myString;
    }

    public List<String> abiliityStrings() {
        List<String> abilityStrings = new ArrayList<>();
        for (Ability ability : validAbilities) {
            abilityStrings.add(ability.toString());
        }
        return abilityStrings;
    }
}
