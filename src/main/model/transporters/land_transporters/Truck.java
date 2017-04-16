package model.transporters.land_transporters;

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
public class Truck extends RoadLandTransporter {
    private static final int truckCapacity = 6;
    private static final int truckMovementSpeed = 4;

    public Truck(Player owner, ParentNode parentNode) {
        super(owner, parentNode, truckCapacity, truckMovementSpeed);

    }

    public String toString(){
        return "Truck";
    }

}
