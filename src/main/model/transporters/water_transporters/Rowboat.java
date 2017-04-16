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
public class Rowboat extends WaterTransporter {
    private static final int rowboatCapacity = 5;
    private static final int rowboatMovementSpeed = 4;

    public Rowboat(Player owner, ParentNode parentNode) {
            super(owner, parentNode, rowboatCapacity, rowboatMovementSpeed);
    }

    @Override
    public String toString() {
        return "Rowboat";

    }
}
