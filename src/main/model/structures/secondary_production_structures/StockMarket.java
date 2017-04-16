package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.resources.Stock;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class StockMarket extends SecondaryProduction {

    private final int maxBonds = 6;
    private int currentBonds;
    private int coinCost = 2;
    private int paperCost = 1;

    public StockMarket(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {
        if(!isExhausted())
            if(resourceStorage.exchangeStock(makeStock()))
                updateExhaustion();
    }
    @Override
    public void produce(TileStorage resourceStorage){
        if(!isExhausted())
            if(resourceStorage.exchangeStock(makeStock()))
                updateExhaustion();
    }
    @Override
    public void resetExhaustion(){
        currentBonds = 0;
        setExhausted(false);
    }

    private void updateExhaustion(){
        currentBonds++;
        if(currentBonds >= maxBonds)
            setExhausted(true);
    }

    private Stock makeStock(){
        return new Stock();
    }
}
