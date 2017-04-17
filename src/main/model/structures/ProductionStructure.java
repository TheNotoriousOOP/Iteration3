package model.structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class ProductionStructure {

    private ParentNode parentNode;

    public ProductionStructure(ParentNode parentNode) {
        this.parentNode = parentNode;
    }

    public ParentNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(ParentNode parentNode) {
        this.parentNode = parentNode;
    }

    public abstract void render(MapRenderer r);

}
