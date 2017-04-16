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

    private HashMap<String, Ability> validAbilities = new HashMap<>();

    public AbilitySet(){

    }

    public AbilitySet(HashMap<String, Ability> validAbilities){
        this.validAbilities = validAbilities;
    }


    //set the actor of each ability in the set
    public void addActorToSet(Transporter t){
        for (Ability ability : validAbilities.values()){
            ability.setActor(t);
        }
    }
    
    public HashMap<String, Ability> getValidAbilities() {
        return validAbilities;
    }

    public void setValidAbilities(HashMap<String, Ability> validAbilities) {
        this.validAbilities = validAbilities;
    }

    @Override
    public MyBidirectionalIterator<Ability> iterator() {
        return new MyBidirectionalIterator<Ability>(new ArrayList<>(validAbilities.values()));
    }

    public void addValidAbility(Ability ability){
        validAbilities.put(ability.toString(), ability);
    }

    public void removeAbilityFromValidList(Ability ability){
        validAbilities.remove(ability);
    }

    @Override
    public String toString() {
        String myString = "";
        for (Ability ability : validAbilities.values()) {
            myString = myString + ability.toString() + ",";
        }
        return myString;
    }

    public List<String> abiliityStrings() {
        List<String> abilityStrings = new ArrayList<>();
        for (Ability ability : validAbilities.values()) {
            abilityStrings.add(ability.toString());
        }
        return abilityStrings;
    }
}
