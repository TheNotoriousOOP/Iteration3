package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.Clay;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class ClayPit extends PrimaryProduction {

    public ClayPit(ParentNode parentNode) {
        super(parentNode);
    }

    @Override
    public void produce(TileStorage resourceStorage) {
        resourceStorage.addClay(makeClay());
    }

    private Clay makeClay(){
        return new Clay();
    }
}
