package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class PanelManager extends PanelObserver{
    private JFrame frame;
    private MainMenuPanel mainMenuPanel;
    private MapEditorPanel mapEditorPanel;
    private JPanel background;
    // Screen size
    private static final int MIN_WIDTH = 1200;
    private static final int MIN_HEIGHT = 800;

    public PanelManager(){
        frame = new JFrame();
        frame.setTitle("Boats & Roads (w/ Dinosaurs)");
        Dimension screenDimension = new Dimension(MIN_WIDTH, MIN_HEIGHT);
        frame.setPreferredSize(screenDimension);
        mainMenuPanel = new MainMenuPanel(screenDimension);
        mapEditorPanel = new MapEditorPanel(screenDimension);
        mainMenuPanel.attach(this);
        mapEditorPanel.attach(this);
        background = new BgPanel();
        background.setLayout(new GridLayout());
        background.add(mainMenuPanel, BorderLayout.CENTER);
        frame.setContentPane(background);
        frame.pack();
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setFullScreen(){
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public void showScreen(){
        frame.setVisible(true);
    }
    @Override
    public void update(String panel){
        if(panel.equals("MainMenuPanel")){
            frame.setContentPane(background);
            frame.revalidate();
        } else if(panel.equals("MapEditorPanel")){
            frame.setContentPane(mapEditorPanel);
            frame.revalidate();
        }
    }
}