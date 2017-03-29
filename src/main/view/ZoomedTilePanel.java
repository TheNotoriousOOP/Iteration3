package view;

import javafx.scene.transform.Affine;
import view.assets.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ZoomedTilePanel extends JPanel {

    // Set default size
//    private final Dimension DEFAULT_SIZE;

    private AssetLoader assets;             // Assets

    private BufferedImage tilePreview;      // Tile base image
    private BufferedImage riverImage;            // River image on top of tile
    private int hexRotation;                // Rotation of tile
    private boolean river = false;
    // Constructor
    public ZoomedTilePanel(AssetLoader assets) {

        this.assets = assets;
//        this.setPreferredSize(DEFAULT_SIZE);
        this.setBackground(Color.WHITE);

        this.tilePreview = assets.getImage("TILE_WOODS");
        Dimension d = new Dimension(120, 120);
        this.setPreferredSize(d);

        setImage(this.tilePreview);  // Paint panel

    }


    // Display inputted buffered target_image in frame
    public void setImage( BufferedImage src ) {

        this.tilePreview = src;
        repaint();
    }
    public void setRiver(BufferedImage src){
        this.riverImage = src;
        repaint();
    }
    // Override the paint component method to draw the resulting image

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent( g );

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.tilePreview, (getWidth() - this.tilePreview.getWidth()) / 2, 0, null);
        if(river){
            g2d.drawImage(this.riverImage, (getWidth() - this.tilePreview.getWidth()) / 2, 0, null);
            river = false;
        }

    }


    // Draw terrain image
    public void updateTileTerrainImage(String terrain) {

        // Setup terrain base
        switch (terrain.toUpperCase()) {
            case "WOODS":
                setImage(assets.getImage("TILE_WOODS"));
                break;
            case "SEA":
                setImage(assets.getImage("TILE_SEA"));
                break;
            case "MOUNTAINS":
                setImage(assets.getImage("TILE_MOUNTAIN"));
                break;
            case "ROCK":
                setImage(assets.getImage("TILE_ROCK"));
                break;
            case "DESERT":
                setImage(assets.getImage("TILE_DESERT"));
                break;
            case "PASTURE":
                setImage(assets.getImage("TILE_PASTURE"));
                break;
        }

    }

    public void updateTileRiverImage(String riverType){
        switch (riverType) {
            case "0":
                river = false;
                repaint();
                break;
            case "1":
                setRiver(assets.getImage("RIVER_SOURCE"));
                river = true;
                break;
            case "2 straight":
                setRiver(assets.getImage("RIVER_2_STRAIGHT"));
                river = true;
                break;
            case "2 sharp":
                setRiver(assets.getImage("RIVER_2_U"));
                river = true;
                break;
            case "2 wide":
                setRiver(assets.getImage("RIVER_2_CURVED"));
                river = true;
                break;
            case "3":
                setRiver(assets.getImage("RIVER_3"));
                river = true;
                break;
        }
    }



    // Todo: Rotate tile based on passed hex value
    public void updateImageRotation(int rotation) {
        this.hexRotation += rotation;
        repaint();
    }



}
