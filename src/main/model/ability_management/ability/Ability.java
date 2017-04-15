package model.ability_management.ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Ability {

    private Transporter actor;
    private boolean isListening;



    public Ability(){

    }

    public void perform(){
        //TODO implement
        System.out.println("class: Ability performing itself...");
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

    //TODO remove; used for testing purposes. (Could be made legitimate if more checking is done)
    public boolean equals(Ability otherAbility) {
        return toString().equals(otherAbility.toString());
    }
}
