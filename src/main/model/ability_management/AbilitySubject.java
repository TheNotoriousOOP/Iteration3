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
        observers.remove(abilityObserver);
    }

    public void registerAbilityObserver(AbilityObserver abilityObserver) {
        observers.add(abilityObserver);
    }

    public void notifyObservers() {
        for (AbilityObserver abilityObserver : observers) {
            abilityObserver.update(getAbilitySet());
        }
    }

    public abstract AbilitySet getAbilitySet();
}
