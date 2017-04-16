package view.renderer;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * contains all images and offset for node drawings
 */
public class NodeOffset {
    private ArrayList<Integer> xOffSets = new ArrayList<Integer>();
    private ArrayList<Integer> yOffSets = new ArrayList<>();
    private ArrayList<BufferedImage> images = new ArrayList<>();

    public NodeOffset() {
    }

    public ArrayList<Integer> getxOffSets() {
        return xOffSets;
    }

    public ArrayList<Integer> getyOffSets() {
        return yOffSets;
    }

    public ArrayList<BufferedImage> getImages() {
        return images;
    }


}
