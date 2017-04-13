package model.resources;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents Geese in game
 * Responsibilities: Represent geese in game to turn into research
 * Reproduces as well
 */
public class Goose extends Resource {
    //TODO lmao not decal
    private ParentNode parentNode;

    public ParentNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(ParentNode parentNode) {
        this.parentNode = parentNode;
    }
}
