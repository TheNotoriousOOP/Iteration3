package controller;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.transporters.MyBidirectionalIterator;

import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class AbilityController extends KeyEventHandler{
    private Ability currentAbility; //TODO need this? or just tell ability set to perform active?
    private MyBidirectionalIterator<Ability> currentAbilityIterator;
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
    public void setAbilityIterator(MyBidirectionalIterator<Ability> updatedAbilitySetIterator) {
        System.out.println("class AbilityController: updating current ability set...");
        currentAbilityIterator = updatedAbilitySetIterator;
    }

    private void cycleUp() {
        //TODO assign currentAbility to next valid ability in currentAbilitySet
        System.out.println("class AbilityController: Cycling ability up...");
        updateCurrentAbility(currentAbilityIterator.next());
    }

    private void cycleDown() {
        //TODO assign currentAbility to prev valid ability in currentAbilitySet
        System.out.println("class AbilityController: Cycling ability down...");
        updateCurrentAbility(currentAbilityIterator.prev());
    }

    private void updateCurrentAbility(Ability updatedAbility) {
        currentAbility = updatedAbility;
    }

    private void performCurrentAbility() {
        //TODO act on currentAbility
        System.out.println("class AbilityController: Performing ability...");
        if (currentAbility != null) {
            currentAbility.perform();
        }
    }
}
