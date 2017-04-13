package model.structures.secondary_production_structures;

import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class SawMill extends SecondaryProduction {

    private int maxBoards;

    public int getMaxBoards() {
        return maxBoards;
    }

    public void setMaxBoards(int maxBoards) {
        this.maxBoards = maxBoards;
    }

    @Override
    void produce(ResourceStorage resourceStorage) {
        //TODO implement
    }
}
