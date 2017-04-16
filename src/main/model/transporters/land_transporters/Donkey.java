package model.transporters.land_transporters;

import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.Resource;
import model.resources.TransportStorage;
import model.transporters.Transporter;
import model.transporters.TransporterID;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Donkey extends AllTerrainLandTransporter {
    private static final int donkeyCapacity = 2;
    private static final int donkeyOffRoadMovementSpeed = 1;
    private static final int donkeyOnRoadMovementSpeed = 2;

    public Donkey(Player owner, ParentNode parentNode) {
        super(owner, parentNode, donkeyCapacity, donkeyOnRoadMovementSpeed);
    }

    @Override
    public String toString() {
        return "Donkey" + getTransporterID().getUniqueID();
    }


}
