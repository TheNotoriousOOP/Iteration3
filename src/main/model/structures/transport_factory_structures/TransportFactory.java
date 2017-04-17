package model.structures.transport_factory_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.structures.ProductionStructure;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class TransportFactory extends ProductionStructure {

    public TransportFactory(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void render(MapRenderer r) {
        r.drawStructure(this);
    }
}