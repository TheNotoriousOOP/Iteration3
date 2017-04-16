package model.transporters.land_transporters;

import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.Player;
import model.resources.Resource;
import model.transporters.Transporter;
import model.transporters.TransporterID;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Donkey extends AllTerrainLandTransporter {

    public Donkey(TransporterID transporterID, Player owner, Resource[] resources, Transporter transporterCargo, ParentNode parentNode, int movementSpeed) {
            super(transporterID, owner, resources, transporterCargo, parentNode, movementSpeed);
    }

    @Override
    public String toString() {
        return "Donkey";

    }

    @Override
    public void render(MapRenderer r) {
        r.drawTransporter(this);
    }
}
