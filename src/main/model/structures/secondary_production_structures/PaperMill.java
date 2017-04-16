package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.resources.Paper;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PaperMill extends SecondaryProduction {

    private final int maxPaper = 1;
    private int currentPaper;

    public PaperMill(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {
        if(!isExhausted())
            if(resourceStorage.exchangePaper(makePaper()))
                updateExhaustion();
    }

    @Override
    public void produce(TileStorage resourceStorage){
        if(!isExhausted())
            if(resourceStorage.exchangePaper(makePaper()))
                updateExhaustion();

    }
    @Override
    public void resetExhaustion(){
        setExhausted(false);
        currentPaper = 0;
    }

    public void updateExhaustion(){
        currentPaper++;
        if(currentPaper <= maxPaper)
            setExhausted(true);
    }

    public Paper makePaper(){
        return new Paper();
    }
}
