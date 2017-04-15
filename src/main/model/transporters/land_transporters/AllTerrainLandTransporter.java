package model.transporters.land_transporters;

import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.player.Player;
import model.resources.Resource;
import model.transporters.Transporter;
import model.transporters.TransporterID;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class AllTerrainLandTransporter extends LandTransporter {

    public AllTerrainLandTransporter(TransporterID transporterID, Player owner, Resource[] resources, Transporter transporterCargo, Node parentNode, int movementSpeed) {
        super(transporterID, owner, resources, transporterCargo, parentNode, movementSpeed);
    }
}
