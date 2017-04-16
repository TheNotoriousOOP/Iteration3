package controller;

import model.ability_management.AbilityObserver;
import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.transporters.MyBidirectionalIterator;
import view.GameViewPanel;

import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class AbilityController extends KeyEventHandler implements AbilityObserver{
    private MyBidirectionalIterator<Ability> currentAbilityIterator;
    private AbilitySet currentAbilitySet;

    //TODO ugh
    private GameViewPanel gameViewPanel;

    //Initialization of currentAbility and currentAbilityIterator done through setter when TransporterController initializes
    public AbilityController(GameViewPanel gameViewPanel) {
        this.gameViewPanel = gameViewPanel;
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

    public void setAbilitySet(AbilitySet abilitySet) {
        currentAbilitySet = abilitySet;
        updateAbilityIterator(currentAbilitySet.iterator());
        updateGameViewPanel();
    }

    public void updateAbilityIterator(MyBidirectionalIterator<Ability> updatedAbilitySetIterator) {
        System.out.println("class AbilityController: updating current ability iterator...");
        currentAbilityIterator = updatedAbilitySetIterator;
    }

    @Override
    public void update(AbilitySet abilitySet) {
        // System.out.println("class AbilityController: Updating ability set based on observer: " + abilitySet.toString() + " |");
        setAbilitySet(abilitySet);
    }

    private void cycleUp() {
        //   System.out.println("class AbilityController: Cycling ability up...");
        currentAbilityIterator.prev();
        updateGameViewPanelActiveAbility();
        printAbilityUpdateString();
    }

    private void cycleDown() {
        //  System.out.println("class AbilityController: Cycling ability down...");
        System.out.println("class AbilityController: Cycling ability down...");
        currentAbilityIterator.next();
        updateGameViewPanelActiveAbility();
        printAbilityUpdateString();
    }

    private void performCurrentAbility() {
        if (currentAbilityExists()) {
            System.out.println("class AbilityController: Performing ability..." + currentAbilityIterator.getCurrent());
            currentAbilityIterator.getCurrent().perform();
        }
    }

    private void printAbilityUpdateString() {
        if (currentAbilityExists()) {
            System.out.println("class AbilityController: Updated ability to " + currentAbilityIterator.getCurrent().toString());
            System.out.println("class AbilityController: Updated ability bound to " + currentAbilityIterator.getCurrent().getActor().toString());
        }
    }

    private void updateGameViewPanel() {
        gameViewPanel.setCurrentAbilitiesString(currentAbilitySet.abiliityStrings());
        updateGameViewPanelActiveAbility();
    }

    private void updateGameViewPanelActiveAbility() {
        if(currentAbilityExists()) {
            gameViewPanel.setActiveAbilityString(currentAbilityIterator.getCurrent().toString());
        }
    }

    private boolean currentAbilityExists() {
        return (currentAbilityIterator.getCurrent() != null);
    }

    //TODO remove; for testing only
    public Ability getCurrentAbility() {
        return currentAbilityIterator.getCurrent();
    }
}
