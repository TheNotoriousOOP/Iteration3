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
public class Raft extends WaterTransporter {
    private static final int raftCapacity = 3;
    private static final int raftMovementSpeed = 3;

    public Raft(Player owner, ParentNode parentNode) {
            super(owner, parentNode, raftCapacity, raftMovementSpeed);

    }

    public String toString(){
        return "Raft";
    }
}
