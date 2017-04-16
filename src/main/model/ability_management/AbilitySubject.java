package model.ability_management;

import model.ability_management.ability_set.AbilitySet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathen on 4/15/2017.
 */
public abstract class AbilitySubject {

    List<AbilityObserver> observers = new ArrayList<>();

    public void deregisterAbilityObserver(AbilityObserver abilityObserver) {
        System.out.println("class: AbilitySubject " + toString() + " is deregistered from " + abilityObserver.toString());
        observers.remove(abilityObserver);
    }

    public void registerAbilityObserver(AbilityObserver abilityObserver) {
        System.out.println("class: AbilitySubject " + toString() + " is registered to " + abilityObserver.toString());
        observers.add(abilityObserver);
    }

    public void notifyObservers() {
        System.out.println("class: AbilitySubject method notifyObservers()");
        for (AbilityObserver abilityObserver : observers) {
            System.out.println("class: AbilitySubject notifying observer");
            abilityObserver.update(getAbilitySet());
        }
    }

    public abstract AbilitySet getAbilitySet();
}
