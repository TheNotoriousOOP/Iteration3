package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.Coins;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Mint extends SecondaryProduction {

    private final int maxCoin = 1;
    private int currentCoin;

    public Mint(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {
        if(!isExhausted())
            if(resourceStorage.exchangeCoin(makeCoin()))
                updateExhaustion();
    }
    @Override
    public void produce(TileStorage resourceStorage){
        if(!isExhausted())
            if(resourceStorage.exchangeCoin(makeCoin()))
                updateExhaustion();
    }
    @Override
    public void resetExhaustion(){
        setExhausted(false);
        currentCoin = 0;
    }

    private void updateExhaustion(){
        currentCoin++;
        if(currentCoin >= maxCoin)
            setExhausted(true);
    }

    private Coins makeCoin(){
        return new Coins();
    }

}
