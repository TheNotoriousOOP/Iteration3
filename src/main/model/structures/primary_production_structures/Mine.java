package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.Resource;
import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Mine extends PrimaryProduction{

    private List<Resource> resources;

    public Mine(ParentNode parentNode, List<Resource> resources) {
        super(parentNode);
        this.resources = resources;
    }

    @Override
    public void produce(ResourceStorage resourceStorage){
        //TODO implement
    }

    public void addShaft(){
        //TODO implement
    }

    public void addBigShaft(){
        //TODO implement
    }

    public void addSpecializedGoldShaft(){
        //TODO implement
    }

    public void addSpecializedIronShaft(){
        //TODO implement
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
