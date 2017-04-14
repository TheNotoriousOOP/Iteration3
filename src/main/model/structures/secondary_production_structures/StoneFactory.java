package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class StoneFactory extends SecondaryProduction {

    private int maxStones;

    public StoneFactory(ParentLandNode parentLandNode) {
        super(parentLandNode);
        this.maxStones = 3;
    }

    @Override
    void produce(ResourceStorage resourceStorage) {
       //TODO implement
    }

    public int getMaxStones() {
        return maxStones;
    }

    public void setMaxStones(int maxStones) {
        this.maxStones = maxStones;
    }

}
