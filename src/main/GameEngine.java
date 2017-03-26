import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Game Application Engine
public class GameEngine extends Application {

    // Set debug mode on
    private static final boolean DEBUG_MODE = true;

    // Screen size
    private static final int MIN_WIDTH = 1200;
    private static final int MIN_HEIGHT = 800;

    // Components

    private int frameCounter = 0;   // Frame counter


    @Override   // Start application
    public void start(Stage stage) {

        // Set stage title
        stage.setTitle("Boats & Roads (w/ Dinosaurs)");

        // Set base root group & scene
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);

        // Fullscreen for production mode
        if (!DEBUG_MODE) {
            stage.setFullScreen(true);
            stage.setMaximized(true);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        }

        // Setup exit conditions
        stage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        // Setup stage size
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);

        // Show stage
        stage.show();

    }

}
