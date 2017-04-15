package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.ResourceStorage;
import model.resources.Stone;
import model.resources.TileStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Quarry extends PrimaryProduction {

    public Quarry(ParentNode parentNode) {
        super(parentNode);
    }

    @Override
    public void produce(TileStorage resourceStorage) {
        resourceStorage.addStone(makeStone());
    }

    private Stone makeStone(){
        return new Stone();
    }
}
