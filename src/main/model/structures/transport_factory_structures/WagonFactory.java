package model.structures.transport_factory_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.ResourceStorage;
import model.structures.ProductionStructure;
import model.transporters.land_transporters.Donkey;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class WagonFactory extends TransportFactory {

    public WagonFactory(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    public void produce(ResourceStorage resourceStorage, Donkey donkey){
        //TODO implement
    }

}
