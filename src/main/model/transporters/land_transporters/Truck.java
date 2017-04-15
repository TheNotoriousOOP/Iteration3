package model.transporters.land_transporters;

import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.Resource;
import model.transporters.Transporter;
import model.transporters.TransporterID;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Truck extends RoadLandTransporter {
    public Truck(TransporterID transporterID, Player owner, Resource[] resources, Transporter transporterCargo, ParentNode parentNode, AbilitySet abilitySet, int movementSpeed) {
            super(transporterID, owner, resources, transporterCargo, parentNode, abilitySet, movementSpeed);
    }
}
