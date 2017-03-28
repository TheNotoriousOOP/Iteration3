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

    BoardPanel boardPanel;
    AssetLoader assetLoader;

    public MapRenderer(BoardPanel boardPanel, AssetLoader assetLoader) {
        this.boardPanel = boardPanel;
        this.assetLoader = assetLoader;
    }

    public void draw(DesertTile desertTile) {
        boardPanel.drawTile(desertTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_DESERT"));
    }
    public void draw(MountainsTile mountainsTile) {
        boardPanel.drawTile(mountainsTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_MOUNTAIN"));
    }
    public void draw(PastureTile pastureTile) {
        boardPanel.drawTile(pastureTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_PASTURE"));
    }
    public void draw(RockTile rockTile) {
        boardPanel.drawTile(rockTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_ROCK"));
    }
    public void draw(SeaTile seaTile) {
        boardPanel.drawTile(seaTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_SEA"));
    }
    public void draw(WoodsTile woodsTile) {
        boardPanel.drawTile(woodsTile.getLocation().getCubeVectorAsPoint(), assetLoader.getImage("TILE_WOODS"));
    }

    public void drawRiverSprite(Graphics2D g, Zone[] zones) {
        if(zones.length != 6) {
            System.out.printf("ERROR: Illegal zone size");
            return;
        }


        int orientation = -1;
        int waterCount = 0;
        boolean adjacency = false;
        for(int iii = 0; iii < 6; iii++) {
            if(zones[iii].isHasWater()) {
                waterCount++;
                if(orientation == -1)
                    orientation = iii;
                if(!adjacency)
                    adjacency = zones[(iii == 0) ? iii-1 : 5].isHasWater();
            }
        }

        if(waterCount == 0 || waterCount == 6)
            return;

        BufferedImage img = null;
        switch(waterCount) {
            case 1:
                img = assetLoader.getImage("RIVER_SOURCE");
                break;
            case 2:
                if(adjacency) {
                    img = assetLoader.getImage("RIVER_U");
                } else {
                    img = assetLoader.getImage("RIVER_CURVED");
                }
                break;
            case 3:
                img = assetLoader.getImage("RIVER_TRI");
        }

        AffineTransform tr = g.getTransform();
        tr.rotate(Math.toRadians(orientation * 60));
        if(img != null)
            g.drawImage(img, tr, null);
    }


}
