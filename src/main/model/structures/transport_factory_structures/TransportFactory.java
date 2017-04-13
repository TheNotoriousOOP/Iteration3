package model.structures.transport_factory_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class TransportFactory extends ProductionStructure {

    private ParentLandNode parentLandNode;

    public ParentLandNode getParentLandNode() {
        return parentLandNode;
    }

    public void setParentLandNode(ParentLandNode parentLandNode) {
        this.parentLandNode = parentLandNode;
    }
}
