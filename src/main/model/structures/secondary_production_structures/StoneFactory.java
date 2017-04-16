package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.resources.Stone;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class StoneFactory extends SecondaryProduction {

    private final int maxStones = 6;
    private int currentStone;
    private int clayCost = 1;

    public StoneFactory(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {
        if(!isExhausted())
            if(resourceStorage.exchangeStone(makeStone(), makeStone()))
                updateExhaustion();
    }

    @Override
    public void produce(TileStorage resourceStorage){
        if(!isExhausted())
            if(resourceStorage.exchangeStone(makeStone(), makeStone()))
                updateExhaustion();
    }

    @Override
    public void resetExhaustion(){
        setExhausted(false);
        currentStone = 0;
    }

    private Stone makeStone(){
        return new Stone();
    }

    private void updateExhaustion(){
        currentStone++;
        currentStone++;
        if(currentStone >= maxStones)
            setExhausted(true);
    }
}
