package model.transporters.water_transporters;

import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.Resource;
import model.resources.TransportStorage;
import model.transporters.Transporter;
import model.transporters.TransporterID;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */

public class Steamboat extends WaterTransporter {
    public Steamboat(TransporterID transporterID, Player owner, TransportStorage resources, Transporter transporterCargo, ParentNode parentNode, int movementSpeed) {
            super(transporterID, owner, resources, transporterCargo, parentNode, movementSpeed);

    }

    public String toString(){
        return "Steamboat";
    }
}
