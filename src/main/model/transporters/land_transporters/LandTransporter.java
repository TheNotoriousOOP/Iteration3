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
public abstract class LandTransporter extends Transporter {
    public LandTransporter(TransporterID transporterID, Player owner, Resource[] resources, Transporter transporterCargo, Node parentNode, AbilitySet abilitySet, int movementSpeed) {
            super(transporterID, owner, resources, transporterCargo, parentNode, abilitySet, movementSpeed);
    }
}
