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
    private static final int steamboatCapacity = 8;
    private static final int steamboatMovementSpeed = 8;

    public Steamboat(Player owner, ParentNode parentNode) {
            super(owner, parentNode, steamboatCapacity, steamboatMovementSpeed);

    }

    public String toString(){
        return "Steamboat";
    }
}
