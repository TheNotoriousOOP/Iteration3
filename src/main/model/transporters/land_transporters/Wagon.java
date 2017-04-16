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
public class Wagon extends RoadLandTransporter {
    private static final int wagonCapacity = 3;
    private static final int wagonMovementSpeed = 3;

    public Wagon(Player owner, ParentNode parentNode) {
            super(owner, parentNode, wagonCapacity, wagonMovementSpeed);
    }

    public String toString(){
        return "Wagon";
    }
}
