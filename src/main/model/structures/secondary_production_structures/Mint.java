package model.structures.secondary_production_structures;

import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Mint extends SecondaryProduction {

    private int maxCoin;

    @Override
    void produce(ResourceStorage resourceStorage) {
        //TODO implement
    }

    public int getMaxCoin() {
        return maxCoin;
    }

    public void setMaxCoin(int maxCoin) {
        this.maxCoin = maxCoin;
    }
}