package model.map.tile.nodeRepresentation.nodes.direction;

import model.ability_management.ability.Ability;

/**
 *
 */
public abstract class ChildDirection {
    protected Ability ability;

    protected Ability buildRoadAbility;

    public abstract Ability getAbility();

    protected void setAbility(Ability ability) {
        this.ability = ability;
    }

    public abstract Ability getBuildRoadAbility();
}
