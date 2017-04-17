package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.TileStorage;
import model.structures.ProductionStructure;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class PrimaryProduction extends ProductionStructure {

    public PrimaryProduction(ParentNode parentNode) {
        super(parentNode);
    }

    abstract public void produce(TileStorage resourceStorage);

    @Override
    public void render(MapRenderer r) {
        r.drawStructure(this);
    }
}
