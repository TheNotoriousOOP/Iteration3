package view.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


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
        loadItem("TILE_DESERT_RIVER_2_CURVED", "res/images/tiles/DesertRiver2Curved.png");
        loadItem("TILE_DESERT_RIVER_2_STRAIGHT", "res/images/tiles/DesertRiver2Straight.png");
        loadItem("TILE_DESERT_RIVER_2_U", "res/images/tiles/DesertRiver2U.png");
        loadItem("TILE_DESERT_RIVER_SOURCE", "res/images/tiles/DesertRiverSource.png");
        loadItem("TILE_MOUNTAIN", "res/images/tiles/Mountain.png");
        loadItem("TILE_MOUNTAIN_RIVER_2_CURVED", "res/images/tiles/MountainRiver2Curved.png");
        loadItem("TILE_MOUNTAIN_RIVER_2_STRAIGHT", "res/images/tiles/MountainRiver2Straight.png");
        loadItem("TILE_MOUNTAIN_RIVER_2_U", "res/images/tiles/MountainRiver2U.png");
        loadItem("TILE_MOUNTAIN_RIVER_SOURCE", "res/images/tiles/MountainRiverSource.png");
        loadItem("TILE_PASTURE", "res/images/tiles/Pasture.png");
        loadItem("TILE_PASTURE_RIVER_2_CURVED", "res/images/tiles/PastureRiver2Curved.png");
        loadItem("TILE_PASTURE_RIVER_2_STRAIGHT", "res/images/tiles/PastureRiver2Straight.png");
        loadItem("TILE_PASTURE_RIVER_2_U", "res/images/tiles/PastureRiver2U.png");
        loadItem("TILE_PASTURE_RIVER_SOURCE", "res/images/tiles/PastureRiverSource.png");
        loadItem("TILE_ROCK", "res/images/tiles/Rocks.png");
        loadItem("TILE_ROCK_RIVER_2_CURVED", "res/images/tiles/RocksRiver2Curved.png");
        loadItem("TILE_ROCK_RIVER_2_STRAIGHT", "res/images/tiles/RocksRiver2Straight.png");
        loadItem("TILE_ROCK_RIVER_2_U", "res/images/tiles/RocksRiver2U.png");
        loadItem("TILE_ROCK_RIVER_SOURCE", "res/images/tiles/RocksRiverSource.png");
        loadItem("TILE_WOODS", "res/images/tiles/Woods.png");
        loadItem("TILE_WOODS_RIVER_2_CURVED", "res/images/tiles/WoodsRiver2Curved.png");
        loadItem("TILE_WOODS_RIVER_2_STRAIGHT", "res/images/tiles/WoodsRiver2Straight.png");
        loadItem("TILE_WOODS_RIVER_2_U", "res/images/tiles/WoodsRiver2U.png");
        loadItem("TILE_WOODS_RIVER_SOURCE", "res/images/tiles/WoodsRiverSource.png");
        loadItem("TILE_SEA", "res/images/tiles/Sea.png");

    }

    // Load specified item
    private void loadItem(String name, String path) {

        File file = new File(path); // Get file
        BufferedImage image;

        // Attempt to read image
        try {

            image = ImageIO.read(file);
            assets.put(name, image);

            // Log item loading
            System.out.println("Loaded Item: " + name);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Get image from asset loader
    public BufferedImage getImage(String imageName) {
        return assets.get(imageName);
    }


}
