package model.ability_management.ability;

import model.ability_management.AbilityEnum;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Ability {

    private Transporter actor;
    private boolean isListening;
    private AbilityEnum abilityEnum;

    public Ability(Transporter actor, AbilityEnum abilityEnum) {
        this.actor = actor;
        this.abilityEnum = abilityEnum;
    }

    public Ability(){

    }

    protected void perform(){
        //TODO implement
    }

    public void setListening(){
        isListening = true;
    }

    public void clearListener(){
        isListening = false;
    }

    public Transporter getActor() {
        return actor;
    }

    public void setActor(Transporter actor) {
        this.actor = actor;
    }

    public boolean isListening() {
        return isListening;
    }

    public void setListening(boolean listening) {
        isListening = listening;
    }
}
