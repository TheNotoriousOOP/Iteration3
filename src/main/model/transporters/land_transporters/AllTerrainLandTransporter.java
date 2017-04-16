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
public class AllTerrainLandTransporter extends LandTransporter {


    public AllTerrainLandTransporter(Player owner, ParentNode parentNode, int capacity, int movementSpeed) {
        super(owner, parentNode, capacity, movementSpeed);

    }

    @Override
    public void updateMovementAbilitySet() {
        System.out.println(getParentNode().toString());
        setAbilitySet(getParentNode().getMovementAbility(this));
    }
}
