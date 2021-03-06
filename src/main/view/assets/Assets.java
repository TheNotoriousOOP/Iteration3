package view.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.*;

// Store assets
public class Assets {

    // Singleton instance
    private static final Assets INSTANCE = new Assets();

    // Map for assets
    private HashMap<String, BufferedImage> assets = new HashMap<String, BufferedImage>();

    // Private constructor for only one instance
    private Assets() {}

    // Static constructor
    static Assets getInstance() {
        return INSTANCE;
    }

    // Load all asset resources
    public void loadResources() {
        loadImages();
    }

    // Load all images
    private void loadImages() {

        loadItem("MENU_BACKGROUND", "res/images/dinotopia-1-huge.jpg");
        loadItem("TILE_DESERT", "res/images/tiles/Desert.png");
        loadItem("TILE_MOUNTAIN", "res/images/tiles/Mountain.png");
        loadItem("TILE_PASTURE", "res/images/tiles/Pasture.png");
        loadItem("TILE_ROCK", "res/images/tiles/Rocks.png");
        loadItem("TILE_WOODS", "res/images/tiles/Woods.png");
        loadItem("TILE_SEA", "res/images/tiles/Sea.png");
        loadItem("RIVER_2_U", "res/images/tiles/extremecurvedriver.png");
        loadItem("RIVER_2_STRAIGHT","res/images/tiles/Straight.png");
        loadItem("RIVER_SOURCE","res/images/tiles/Sourceriver.png");
        loadItem("RIVER_2_CURVED","res/images/tiles/WideCurveRiver.png");
        loadItem("RIVER_3","res/images/tiles/TriRiver.png");
        loadItem("SAVE_ICON", "res/images/piggy-bank.png");
        loadItem("ADD_ICON", "res/images/plus.png");
        loadItem("REMOVE_ICON", "res/images/minus.png");
        loadItem("EXIT_ICON", "res/images/exit.png");
        loadItem("DOT", "res/images/Dot.png");
        loadItem("DONKEY", "res/images/Donkey.png");
        loadItem("ROAD", "res/images/Road.png");
        loadItem("STRUCTURE", "res/images/Structure.png");
        loadItem("PRIMARY", "res/images/Primary.png");
        loadItem("SECONDARY", "res/images/Secondary.png");
        loadItem("FACTORY", "res/images/Factory.png");
        loadItem("LAND", "res/images/LandTransporter.png");
        loadItem("WATER", "res/images/WaterTransporter.png");

        //Research Table Sprites
        loadItem("BRIGHT_IDEA", "res/images/ResearchTableSprites/Bright Idea.png");
        loadItem("DRILLING", "res/images/ResearchTableSprites/Drilling.png");
        loadItem("ENLARGEMENT", "res/images/ResearchTableSprites/Enlargement.png");
        loadItem("NEW_SHAFTS", "res/images/ResearchTableSprites/New Shafts.png");
        loadItem("ROWING", "res/images/ResearchTableSprites/Rowing.png");
        loadItem("SHIPPING", "res/images/ResearchTableSprites/Shipping.png");
        loadItem("SPECIALIZATION", "res/images/ResearchTableSprites/Specialization.png");
        loadItem("TRUCKING", "res/images/ResearchTableSprites/Trucking.png");
        loadItem("RESEARCHBG", "res/images/ResearchTableSprites/ResearchBG.jpg");

        //Wonder View Sprites
        loadItem("TEMPLE", "res/images/WonderViewSprites/Temple.png");
        loadItem("WONDERBG", "res/images/WonderViewSprites/WonderBG.jpg");
        loadItem("BUILDPHASE", "res/images/WonderViewSprites/BuildPhase.png");
        loadItem("MOVEMENTPHASE", "res/images/WonderViewSprites/MovementPhase.png");
        loadItem("PRAYER1", "res/images/WonderViewSprites/Prayer1.png");
        loadItem("PRAYER2", "res/images/WonderViewSprites/Prayer2.png");
        loadItem("PRODUCTIONPHASE", "res/images/WonderViewSprites/ProductionPhase.png");
        loadItem("SEQUENCE1", "res/images/WonderViewSprites/Sequence1.png");
        loadItem("SEQUENCE2", "res/images/WonderViewSprites/Sequence2.png");
        loadItem("WONDERPHASE", "res/images/WonderViewSprites/WonderPhase.png");


    }

    // Load specified item
    private void loadItem(String name, String path) {

        File file = new File(path); // Get file
        BufferedImage image;

//        try {
//
//            image = ImageIO.read(file);
//            assets.put(name, image);
//
//            // Log item loading
//            System.out.println("Loaded Item: " + name);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Attempt to read image
        if(name.equals("MENU_BACKGROUND") || name.equals("SAVE_ICON") || name.equals("ADD_ICON") || name.equals("REMOVE_ICON") || name.equals("EXIT_ICON")
                || name.equals("TEMPLE") || name.equals("WONDERBG") || name.equals("RESEARCHBG") || name.equals("DOT") || name.equals("DONKEY") ||
                name.equals("ROAD") || name.equals("BUILDPHASE") || name.equals("MOVEMENTPHASE") || name.equals("PRAYER1") || name.equals("PRAYER2") || name.equals("PRODUCTIONPHASE")
                || name.equals("SEQUENCE1") || name.equals("SEQUENCE2") || name.equals("WONDERPHASE") || name.equals("STRUCTURE") || (name.equals("WATER")) || (name.equals("LAND")) ||
                (name.equals("PRIMARY")) || (name.equals("SECONDARY"))  || (name.equals("FACTORY"))){
            
            try {

                image = ImageIO.read(file);
                assets.put(name, image);

                // Log item loading
                System.out.println("Loaded Item: " + name);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else{
            try {

                image = ImageIO.read(file);
                BufferedImage resizedImage = new BufferedImage(135, 135, BufferedImage.TYPE_INT_ARGB);
                Graphics g = resizedImage.createGraphics();
                g.drawImage(image, -3, -6, 135, 135, null);
                g.dispose();
                assets.put(name, resizedImage);
                // Log item loading
                System.out.println("Loaded Item: " + name);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Get image from asset loader
    public BufferedImage getImage(String imageName) {
        return assets.get(imageName);
    }

}
