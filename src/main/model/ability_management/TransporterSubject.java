package model.ability_management;

import controller.ResourceObserver;
import model.ability_management.ability_set.AbilitySet;
import model.transporters.Transporter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathen on 4/15/2017.
 */
public abstract class TransporterSubject {

    private List<AbilityObserver> abilityObservers = new ArrayList<>();
    private List<ResourceObserver> resourceObservers = new ArrayList<>();

    public void deregisterAbilityObserver(AbilityObserver abilityObserver) {
        System.out.println("class: TransporterSubject " + toString() + " is deregistered from " + abilityObserver.toString());
        abilityObservers.remove(abilityObserver);
    }

    public void registerAbilityObserver(AbilityObserver abilityObserver) {
        System.out.println("class: TransporterSubject " + toString() + " is registered to " + abilityObserver.toString());
        abilityObservers.add(abilityObserver);
    }

    public void notifyAbilityObservers() {
        System.out.println("class: TransporterSubject method notifyAbilityObservers()");
        for (AbilityObserver abilityObserver : abilityObservers) {
            System.out.println("class: TransporterSubject notifying ability observer");
            abilityObserver.update(getAbilitySet());
        }
    }

    public abstract AbilitySet getAbilitySet();


    public void deregisterResourceObserver(ResourceObserver resourceObserver) {
        System.out.println("class: TransporterSubject " + toString() + " is deregistered from " + resourceObserver.toString());
        resourceObservers.remove(resourceObserver);
    }

    public void registerResourceObserver(ResourceObserver resourceObserver) {
        System.out.println("class: TransporterSubject " + toString() + " is registered to " + resourceObserver.toString());
        resourceObservers.add(resourceObserver);
    }

    //Might not be the best thing...
    public void notifyResourceObservers(Transporter transporter) {
        System.out.println("class: TransporterSubject method notifyResourceObservers()");
        for (ResourceObserver resourceObserver : resourceObservers) {
            System.out.println("class: TransporterSubject notifying resource observer");
            resourceObserver.update(transporter);
        }
    }

}
