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
        int trueCount = 0;
        boolean adjacency = false;
        for(int iii = 0; iii < 6; iii++) {
            if(zones[iii].isHasWater()) {
                trueCount++;
                if(orientation == -1)
                    orientation = iii;
                if(!adjacency)
                    adjacency = zones[(iii == 0) ? iii-1 : 5].isHasWater();
            }
        }

        if(trueCount == 0 || trueCount == 6)
            return;

        AffineTransform tr = g.getTransform();
        tr.rotate(Math.toRadians(orientation * 60));
        switch(trueCount) {
            case 1:
                g.drawImage(assetLoader.getImage("RIVER_SOURCE"), tr, null);
                break;
            case 2:
                if(adjacency) {
                    g.drawImage(assetLoader.getImage("RIVER_U"), tr, null);
                } else {
                    g.drawImage(assetLoader.getImage("RIVER_CURVED"), tr, null);
                }
                break;
            case 3:
                g.drawImage(assetLoader.getImage("RIVER_TRI"), tr, null);

        }
    }


}
