package view;

import view.assets.AssetLoader;

import javax.swing.*;
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
    private GameViewPanel gameViewPanel;
    private BgPanel mapPanelWithBG;
    private WonderViewPanel wonderViewPanel;
    private StartGamePanel startGamePanel;
    // Screen size
    private static final int MIN_WIDTH = 1280;
    private static final int MIN_HEIGHT = 720;

    public PanelManager() {

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e)
        {}
        frame = new JFrame();
        frame.setTitle("DinoBoats & DinoRoads");

        Dimension screenDimension = new Dimension(MIN_WIDTH, MIN_HEIGHT);
        frame.setPreferredSize(screenDimension);
        frame.setMinimumSize(new Dimension(1280, 720));

        AssetLoader assets = new AssetLoader();

        mainMenuPanel = new MainMenuPanel(screenDimension, assets);
        mapEditorPanel = new MapEditorPanel(screenDimension, assets);
        gameViewPanel = new GameViewPanel(screenDimension, assets);
        wonderViewPanel = new WonderViewPanel(assets);
        startGamePanel = new StartGamePanel(assets);
        mainMenuPanel.attach(this);
        mapEditorPanel.attach(this);
        gameViewPanel.attach(this);
        startGamePanel.attach(this);

        mapPanelWithBG = new BgPanel(assets);
        mapPanelWithBG.setLayout(new GridLayout());
        mapPanelWithBG.add(mainMenuPanel, BorderLayout.CENTER);

        frame.setContentPane(mapPanelWithBG);
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
            frame.setContentPane(mapPanelWithBG);
            frame.revalidate();
        } else if(panel.equals("MapEditorPanel")){
            frame.setContentPane(mapEditorPanel);
            frame.revalidate();
            mapEditorPanel.getFocusToBoard();
        } else if(panel.equals("GameViewPanel")){
            frame.setContentPane(gameViewPanel);
            frame.revalidate();
        } else if(panel.equals("StartGamePanel")){
            frame.setContentPane(startGamePanel);
            frame.revalidate();
        }
    }

    public MapEditorPanel getMapEditorPanel() {
        return mapEditorPanel;
    }
    public MainMenuPanel getMainMenuPanel() {return mainMenuPanel;}
    public GameViewPanel getGameViewPanel() {return gameViewPanel;}
}