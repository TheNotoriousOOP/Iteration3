package view.assets;

import java.awt.image.BufferedImage;

public class AssetLoader {

    // Assets instance
    Assets assets;

    // Constructor
    public AssetLoader () {

        // Get instance of assets and load all assets
        this.assets = Assets.getInstance();
        assets.loadResources();

    }

    public BufferedImage getImage(String imageName) {
        return assets.getImage(imageName);
    }

    public int getImageWidth(String imageName) {
        return (int) assets.getImage(imageName).getWidth(null);
    }

    public int getImageHeight(String imageName) {
        return (int) assets.getImage(imageName).getHeight(null);
    }

}
