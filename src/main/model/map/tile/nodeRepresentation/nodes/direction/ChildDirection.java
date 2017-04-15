package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;

/**
 *
 */
public abstract class ChildDirection {
    protected Ability ability;



    public Ability getAbility() {
        return ability;
    }

    protected void setAbility(Ability ability) {
        this.ability = ability;
    }
}
