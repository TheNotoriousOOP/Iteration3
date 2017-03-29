package view.renderer;

import model.map.tile.*;
import view.BoardPanel;
import view.assets.AssetLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

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
//        this.riverImg = determineCorrectImageAndRotation(desertTile);
        boardPanel.drawTile(desertTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_DESERT"), assetLoader.getImage(riverTypeString));

    }
    public void draw(MountainsTile mountainsTile) {
//        this.riverImg = determineCorrectImageAndRotation(mountainsTile);
        boardPanel.drawTile(mountainsTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_MOUNTAIN"), assetLoader.getImage(riverTypeString));
    }
    public void draw(PastureTile pastureTile) {
//        this.riverImg = determineCorrectImageAndRotation(pastureTile);
        boardPanel.drawTile(pastureTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_PASTURE"), assetLoader.getImage(riverTypeString));
    }
    public void draw(RockTile rockTile) {
//        this.riverImg = determineCorrectImageAndRotation(rockTile);
        boardPanel.drawTile(rockTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_ROCK"), assetLoader.getImage(riverTypeString));
    }
    public void draw(SeaTile seaTile) {
//        this.riverImg = determineCorrectImageAndRotation(seaTile);
        boardPanel.drawTile(seaTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_SEA"), assetLoader.getImage(riverTypeString));
    }
    public void draw(WoodsTile woodsTile) {
//        this.riverImg = determineCorrectImageAndRotation(woodsTile);
        boardPanel.drawTile(woodsTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_WOODS"), assetLoader.getImage(riverTypeString));
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
