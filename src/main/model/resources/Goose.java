package model.resources;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents Geese in game
 * Responsibilities: Represent geese in game to turn into research
 * Reproduces as well
 */
public class Goose extends Resource {
    //TODO lmao not decal
    private ParentNode parentNode;

    public Goose(ParentNode parentNode) {
        this.parentNode = parentNode;
    }

    public ParentNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(ParentNode parentNode) {
        this.parentNode = parentNode;
    }
}
