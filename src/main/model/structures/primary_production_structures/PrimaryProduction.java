package model.structures.primary_production_structures;

import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class PrimaryProduction extends ProductionStructure {

    abstract public void produce(ResourceStorage resourceStorage);

}
