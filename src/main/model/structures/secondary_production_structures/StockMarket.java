package model.structures.secondary_production_structures;

import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class StockMarket extends SecondaryProduction {

    private int maxBonds;

    @Override
    void produce(ResourceStorage resourceStorage) {
        //TODO implement
    }

    public int getMaxBonds() {
        return maxBonds;
    }

    public void setMaxBonds(int maxBonds) {
        this.maxBonds = maxBonds;
    }
}
