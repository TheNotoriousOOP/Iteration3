package view;

import controller.MainMenuController;
import view.assets.AssetLoader;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */

public class MainMenuPanel extends JPanel{
    private JLabel title;
    private JButton startGame;
    private JButton newMap;
    private JButton loadMap;
    private JButton exit;

    private JButton newGame;
    private JButton loadGame;
    private JFileChooser newGameMapChooser;
    private JFileChooser savedGameMapChooser;

    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    private MainMenuController mainMenuController;

    private JFileChooser mapFileChooser;

    private AssetLoader assets;

    public MainMenuPanel(AssetLoader assets){
        this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();

        this.title = new JLabel("Dinoboats & Dinoroads");
        Font titleFont = new Font("Times New Roman", Font.BOLD|Font.ITALIC, 72);
        title.setFont(titleFont);

        // Add assets loader
        this.assets = assets;

        Font buttonFont = new Font("Times New Roman", Font.ITALIC, 36);
        this.newGame = new JButton("New Game");
        this.loadGame = new JButton("Load Game");
        this.newMap = new JButton("New Map");
        this.loadMap = new JButton(("Load Map"));
        this.exit = new JButton(("Exit"));

        //Initialize JFileChooser for map files using directory from which application was launched
        mapFileChooser = new JFileChooser(System.getProperty("user.dir"));
        //Apply desired file filter
        mapFileChooser.setFileFilter( selectFileFilter() );

        newGameMapChooser = new JFileChooser(System.getProperty("user.dir"));
        savedGameMapChooser = new JFileChooser(System.getProperty("user.dir"));
        newGameMapChooser.setFileFilter(selectFileFilter());
        savedGameMapChooser.setFileFilter(selectFileFilter());

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseNewGameMapFile();
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseSavedGameMapFile();
            }
        });

        newMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuController.resetMap();
                notifyAllObservers("MapEditorPanel");
            }
        });

        loadMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseMapFile();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        newGame.setFont(buttonFont);
        loadGame.setFont(buttonFont);
        newMap.setFont(buttonFont);
        loadMap.setFont(buttonFont);
        exit.setFont(buttonFont);

        Dimension buttonDimension = new Dimension(200, 60);
        newGame.setPreferredSize(buttonDimension);
        loadGame.setPreferredSize(buttonDimension);
        newMap.setPreferredSize(buttonDimension);
        loadMap.setPreferredSize(buttonDimension);
        exit.setPreferredSize(buttonDimension);

        GridBagConstraints t = new GridBagConstraints();
        t.gridx = 0;
        t.gridy = 0;
        t.insets = new Insets(0,0,160,0);
        t.fill = GridBagConstraints.BOTH;
        this.add(title, t);
        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(5, 0, 0, 0);
        this.add(newGame, c);
        c.gridy = 2;
        c.gridx = 0;
        this.add(loadGame, c);
        c.gridy = 3;
        c.gridx = 0;
        this.add(newMap, c);
        c.gridy = 4;
        c.gridx = 0;
        this.add(loadMap, c);
        c.gridy = 5;
        c.gridx = 0;
        this.add(exit, c);


    }

    private void chooseMapFile() {
        int mapFileChooserState = mapFileChooser.showOpenDialog(MainMenuPanel.this);


        if (mapFileChooserState == JFileChooser.APPROVE_OPTION) {
            mainMenuController.loadMapInModel(mapFileChooser.getSelectedFile().getAbsolutePath());
            notifyAllObservers("MapEditorPanel");
        }
    }
    private void chooseNewGameMapFile() {
        int newGameMapFileChooserState = newGameMapChooser.showOpenDialog(MainMenuPanel.this);

        if (newGameMapFileChooserState == JFileChooser.APPROVE_OPTION) {
            if(mainMenuController.loadMapInGame(newGameMapChooser.getSelectedFile().getAbsolutePath()))
                notifyAllObservers("GameViewPanel");
            else{
                // TODO: INVALID MAP
            }
        }
    }
    private void chooseSavedGameMapFile() {
        int savedGameMapFileChooserState = newGameMapChooser.showOpenDialog(MainMenuPanel.this);

        if (savedGameMapFileChooserState == JFileChooser.APPROVE_OPTION) {
            if(mainMenuController.loadMapInGame(newGameMapChooser.getSelectedFile().getAbsolutePath()))
                notifyAllObservers("GameViewPanel");
            else{
                // TODO: INVALID MAP
            }
        }
    }
    private FileFilter selectFileFilter() {
        return new FileNameExtensionFilter("Map Text Files", "txt");
    }

    public void attach(PanelObserver observer){
        observers.add(observer);
    }

    public void notifyAllObservers(String panelName){
        for(PanelObserver observer : observers){
            observer.update(panelName);
        }
    }

    public void setController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}

class BgPanel extends JPanel {

    AssetLoader assets;
    Image bg;

    public BgPanel(AssetLoader assets) {
        this.assets = assets;
        this.bg = assets.getImage("MENU_BACKGROUND");
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}