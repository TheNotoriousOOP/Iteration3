package controller;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;

import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class AbilityController extends KeyEventHandler{
    private AbilitySet currentAbilitySet;
    private Ability currentAbility; //TODO need this? or just tell abiility set to perform active?
    //private Map<KeyCode, Runnable> keyCodeRunnableMap; TODO delete this if I don't need this

    public AbilityController() {
        //TODO init currentAbility and currentAbilitySet
    }

    @Override
    public void handle(int keyCode) throws IllegalArgumentException{
        switch (keyCode) {
            case KeyEvent.VK_ENTER:
                performCurrentAbility();
                break;
            case KeyEvent.VK_UP:
                cycleUp();
                break;
            case KeyEvent.VK_DOWN:
                cycleDown();
                break;
            default:
                throw new IllegalArgumentException("class AbilityController does not recognize input: " + KeyEvent.getKeyText(keyCode));
        }
    }

    //TODO update to take in an ability set
    public void setAbilitySet(AbilitySet updatedAbilitySet) {
        System.out.println("class AbilityController: updating current ability set...");
        currentAbilitySet = updatedAbilitySet;
    }

    private void cycleUp() {
        //TODO assign currentAbility to next valid ability in currentAbilitySet
        System.out.println("class AbilityController: Cycling ability up...");
    }

    private void cycleDown() {
        //TODO assign currentAbility to prev valid ability in currentAbilitySet
        System.out.println("class AbilityController: Cycling ability down...");
    }

    private void performCurrentAbility() {
        //TODO act on currentAbility
        System.out.println("class AbilityController: Performing ability...");
    }
}
