package view.renderer;

import model.map.tile.*;
import view.BoardPanel;
import view.assets.AssetLoader;

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
        boardPanel.drawTile(desertTile.getLocation(), assetLoader.getImage("TILE_DESERT"));
    }
    public void draw(MountainsTile mountainsTile) {
        boardPanel.drawTile(mountainsTile.getLocation(), assetLoader.getImage("TILE_MOUNTAIN"));
    }
    public void draw(PastureTile pastureTile) {
        boardPanel.drawTile(pastureTile.getLocation(), assetLoader.getImage("TILE_PASTURE"));
    }
    public void draw(RockTile rockTile) {
        boardPanel.drawTile(rockTile.getLocation(), assetLoader.getImage("TILE_ROCK"));
    }
    public void draw(SeaTile seaTile) {
        boardPanel.drawTile(seaTile.getLocation(), assetLoader.getImage("TILE_SEA"));
    }
    public void draw(WoodsTile woodsTile) {
        boardPanel.drawTile(woodsTile.getLocation(), assetLoader.getImage("TILE_WOODS"));
    }
}
