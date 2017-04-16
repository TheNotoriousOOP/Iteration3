package model.ability_management;

import model.ability_management.ability_set.AbilitySet;

/**
 * Created by Jonathen on 4/15/2017.
 */
public interface AbilityObserver {

   void update(AbilitySet abilitySet);
}
