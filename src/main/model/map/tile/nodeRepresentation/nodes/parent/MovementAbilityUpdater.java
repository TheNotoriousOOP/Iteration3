package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability_set.AbilitySet;
import model.transporters.Transporter;
import model.transporters.land_transporters.AllTerrainLandTransporter;
import model.transporters.land_transporters.RoadLandTransporter;
import model.transporters.water_transporters.WaterTransporter;

/**
 *
 */
public interface MovementAbilityUpdater {


    public AbilitySet getMovementAbility(AllTerrainLandTransporter allT);

    public AbilitySet getMovementAbility(RoadLandTransporter rlT);

    public AbilitySet getMovementAbility(WaterTransporter waterT);
}
