package view.renderer;

import model.map.tile.*;
import view.BoardPanel;
import view.assets.AssetLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Jonathen on 3/28/2017.
 */
public class MapRenderer {

    private BoardPanel boardPanel;
    private AssetLoader assetLoader;
    private BufferedImage riverImg;
    private String riverTypeString;
    public MapRenderer(BoardPanel boardPanel, AssetLoader assetLoader) {
        this.boardPanel = boardPanel;
        this.assetLoader = assetLoader;
        this.riverTypeString = "RIVER_SOURCE";
    }

    public void draw(DesertTile desertTile) {
        this.riverImg = determineCorrectRiverImage(desertTile);
        boardPanel.drawTile(desertTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_DESERT"), riverImg);

    }
    public void draw(MountainsTile mountainsTile) {
        this.riverImg = determineCorrectRiverImage(mountainsTile);
        boardPanel.drawTile(mountainsTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_MOUNTAIN"), riverImg);
    }
    public void draw(PastureTile pastureTile) {
        this.riverImg = determineCorrectRiverImage(pastureTile);
        boardPanel.drawTile(pastureTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_PASTURE"), riverImg);
    }
    public void draw(RockTile rockTile) {
        this.riverImg = determineCorrectRiverImage(rockTile);
        boardPanel.drawTile(rockTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_ROCK"), riverImg);
    }
    public void draw(SeaTile seaTile) {
        boardPanel.drawTile(seaTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_SEA"), null);
    }
    public void draw(WoodsTile woodsTile) {
        this.riverImg = determineCorrectRiverImage(woodsTile);
        boardPanel.drawTile(woodsTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_WOODS"), riverImg);
    }


    public BufferedImage determineCorrectRiverImage(Tile t){
        BufferedImage riverImage = null;
        int hexRotation = 0;
        int rotationBySides = 0;

        //count tile zones with water
        int zonesWithWater = 0;
        ArrayList<Integer> zoneIndices = new ArrayList<>();

        //determine # of zones and their indices
        for(int i = 0; i < t.getZones().length; i++){
            if (t.getSpecificZone(i + 1).isHasWater()){
                zonesWithWater++;
                zoneIndices.add(i + 1);
            }
        }

        switch (zonesWithWater){
            case 0:
                return null;
            case 1:
                //determine rotation
                rotationBySides = zoneIndices.get(0) - 1;
                hexRotation = rotationBySides*60;
                riverImage = assetLoader.getImage("RIVER_SOURCE");
                break;
            case 2:
                //determine rotation
                int zoneDistance = zoneIndices.get(1) - zoneIndices.get(0);
                rotationBySides = zoneIndices.get(0) - 1;
                hexRotation = rotationBySides*60;
                if(zoneDistance == 1){
                    riverImage = assetLoader.getImage("RIVER_2_U");
                } else if (zoneDistance == 2){
                    riverImage = assetLoader.getImage("RIVER_2_CURVED");
                } else if (zoneDistance == 3){
                    riverImage = assetLoader.getImage("RIVER_2_STRAIGHT");
                }

                break;
            case 3:
                //determine rotation
                rotationBySides = zoneIndices.get(0) - 1;
                hexRotation = rotationBySides*60;
                riverImage = assetLoader.getImage("RIVER_3");
                break;
            default:
                riverImage = assetLoader.getImage("RIVER_SOURCE");
        }

        double rotationRequired = Math.toRadians (hexRotation);
        double locationX = riverImage.getWidth() / 2;
        double locationY = riverImage.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(riverImage, null);


    }

//    public BufferedImage determineCorrectImageAndRotation(Tile t){
//        Zone[] zones = t.getZones();
//
//        int orientation = -1;
//        int waterCount = 0;
//        boolean adjacency = false;
//        for(int iii = 0; iii < 6; iii++) {
//            if(zones[iii].isHasWater()) {
//                waterCount++;
//                if(orientation == -1)
//                    orientation = iii;
//                if(!adjacency)
//                    adjacency = zones[(iii == 0) ? iii-1 : 5].isHasWater();
//            }
//        }
//        BufferedImage riverImg = null;
//        orientation *= 60;
//        System.out.println(orientation);
//
//        switch(waterCount) {
//            case 1:
//                riverImg = assetLoader.getImage("RIVER_SOURCE");
//                break;
//            case 2:
//                if(adjacency) {
//                    riverImg = assetLoader.getImage("RIVER_U");
//                } else {
//                    riverImg = assetLoader.getImage("RIVER_CURVED");
//                }
//                break;
//            case 3:
//                riverImg = assetLoader.getImage("RIVER_TRI");
//                break;
//        }
//        return riverImg;
//    }

}
