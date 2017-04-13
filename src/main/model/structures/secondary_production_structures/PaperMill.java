package model.structures.secondary_production_structures;

import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PaperMill extends SecondaryProduction {

    private int maxPaper;

    @Override
    void produce(ResourceStorage resourceStorage) {
        //TODO implement
    }

    public int getMaxPaper() {
        return maxPaper;
    }

    public void setMaxPaper(int maxPaper) {
        this.maxPaper = maxPaper;
    }
}
