import view.PanelManager;

import javax.swing.*;
// Class to run the game
public class RunGame {

    // Startup game
    public static void main(String[] args) {
        PanelManager panelManager = new PanelManager();
        panelManager.setFullScreen();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                panelManager.showScreen();
            }
        });
    }

}
