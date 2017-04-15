package model.transporters.water_transporters;

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
public abstract class WaterTransporter extends Transporter{

    public WaterTransporter(TransporterID transporterID, Player owner, Resource[] resources, Transporter transporterCargo, ParentNode parentNode, int movementSpeed) {
            super(transporterID, owner, resources, transporterCargo, parentNode, movementSpeed);
    }

    @Override
    public void updateMovementAbilitySet() {
        setAbilitySet(getParentNode().getMovementAbility(this));
    }
}
