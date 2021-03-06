package view;

import view.assets.AssetLoader;
import java.awt.image.AffineTransformOp;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
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

    private int hexSize = 120;
    private int borderSize = 1;

    // Constructor
    public ZoomedTilePanel(AssetLoader assets) {

        this.assets = assets;
        this.setBackground(Color.DARK_GRAY);
        this.tilePreview = assets.getImage("TILE_WOODS");
        Dimension d = new Dimension(300, 300);
        this.setPreferredSize(d);
        this.setMinimumSize(d);

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
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(this.tilePreview, (getWidth() - this.tilePreview.getWidth()) / 2, 30, null);


        if(river){
            double rotationRequired = Math.toRadians (hexRotation);
            double locationX = riverImage.getWidth() / 2;
            double locationY = riverImage.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(riverImage, null), (getWidth() - this.tilePreview.getWidth()) / 2, 30, null);
        }

        Polygon poly = hex(0,0);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(9));
        g2d.drawPolygon(poly);




    }
    public Polygon hex (int x0, int y0) {

        int y = y0 + borderSize;
        int x = x0 + borderSize;

        int[] cx,cy;

        cy = new int[] {28, 93, 165, 165, 93, 28};
        cx = new int[] {110,75,113,185,220, 183};

        return new Polygon(cx,cy,6);
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
            default:
                river = false;
        }
    }

    // Todo: Rotate tile based on passed hex value
    public void updateImageRotation(int rotation) {
        this.hexRotation = rotation;
        repaint();
    }



}
