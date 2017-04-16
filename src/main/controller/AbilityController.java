package controller;

import model.ability_management.AbilityObserver;
import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.transporters.MyBidirectionalIterator;

import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class AbilityController extends KeyEventHandler implements AbilityObserver{
    private Ability currentAbility;
    private MyBidirectionalIterator<Ability> currentAbilityIterator;

    //Initialization of currentAbility and currentAbilityIterator done through setter when TransporterController initializes
    public AbilityController() {
        currentAbility = null; //TODO will this cause a bug? doesn't look like it
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

    public void setAbilityIterator(MyBidirectionalIterator<Ability> updatedAbilitySetIterator) {
       // System.out.println("class AbilityController: updating current ability iterator...");
        currentAbilityIterator = updatedAbilitySetIterator;
        updateCurrentAbility(currentAbilityIterator.getCurrent());
    }

    @Override
    public void update(AbilitySet abilitySet) {
       // System.out.println("class AbilityController: Updating ability set based on observer: " + abilitySet.toString() + " |");
        setAbilityIterator(abilitySet.iterator());
    }

    private void cycleUp() {
     //   System.out.println("class AbilityController: Cycling ability up...");
        updateCurrentAbility(currentAbilityIterator.next());
    }

    private void cycleDown() {
      //  System.out.println("class AbilityController: Cycling ability down...");
        updateCurrentAbility(currentAbilityIterator.prev());
    }

    private void updateCurrentAbility(Ability updatedAbility) {
        if (updatedAbility != null) { //TODO might cause bug, but doesn't look like it
            System.out.println("class AbilityController: Updating ability to " + updatedAbility.toString());
            currentAbility = updatedAbility;
            System.out.println("class AbilityController: Updated ability bound to " + updatedAbility.getActor().toString());
        }
    }

    private void performCurrentAbility() {
        if (currentAbility != null) {
            System.out.println("class AbilityController: Performing ability..." + currentAbility.toString());
            currentAbility.perform();

        }
    }

    //TODO remove; for testing only
    public Ability getCurrentAbility() {
        return currentAbilityIterator.getCurrent();
    }

}
