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
    private BufferedImage river;            // River image on top of tile
    private int hexRotation;                // Rotation of tile

    private Graphics2D g2d;                 // Graphics2D Obj for drawing

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
        this.g2d = (Graphics2D) tilePreview.createGraphics();

        repaint();

    }

    // Override the paint component method to draw the resulting image
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent( g );

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.tilePreview, (getWidth() - this.tilePreview.getWidth()) / 2, 0, null);

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


    // Todo: Draw River Image

    // Todo: Rotate tile based on passed hex value
    public void updateImageRotation(int rotation) {
        this.hexRotation += rotation;
        repaint();
    }



}
