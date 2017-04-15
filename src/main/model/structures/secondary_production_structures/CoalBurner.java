package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.Fuel;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class CoalBurner extends SecondaryProduction {

    private final int maxFuel = 6;
    private int currentFuelCount;

    public CoalBurner(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {
        if(!isExhausted())
            if(resourceStorage.exchangeFuel(makeFuel()))
                updateExhaustion();


    }
    @Override
    public void produce(TileStorage resourceStorage){
        if(!isExhausted())
            if(resourceStorage.exchangeFuel(makeFuel()))
                updateExhaustion();
    }

    @Override
    public void resetExhaustion(){
        setExhausted(false);
        currentFuelCount = 0;
    }

    private Fuel makeFuel(){
        return new Fuel();
    }

    private void updateExhaustion(){
        currentFuelCount++;
        if(currentFuelCount >= maxFuel)
            setExhausted(true);
    }
}
