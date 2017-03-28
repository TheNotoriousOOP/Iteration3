package view;
import controller.MainMenuController;
import controller.MapEditorController;
import sun.applet.Main;

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
    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    private MainMenuController mainMenuController;

    private JFileChooser mapFileChooser;

    public MainMenuPanel(Dimension d){
        this.setPreferredSize(d);
        this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();

        this.title = new JLabel("Dinoboats & Dinoroads");
        Font titleFont = new Font("Times New Roman", Font.BOLD|Font.ITALIC, 72);
        title.setFont(titleFont);

        Font buttonFont = new Font("Times New Roman", Font.ITALIC, 36);
        this.startGame = new JButton("Start Game");
        this.newMap = new JButton("New Map");
        this.loadMap = new JButton(("Load Map"));
        this.exit = new JButton(("Exit"));

        //Initialize JFileChooser for map files using directory from which application was launched
        mapFileChooser = new JFileChooser(System.getProperty("user.dir"));
        //Apply desired file filter
        mapFileChooser.setFileFilter( selectFileFilter() );

        newMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers();
            }
        });

        loadMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseMapFile();
                notifyAllObservers();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startGame.setFont(buttonFont);
        newMap.setFont(buttonFont);
        loadMap.setFont(buttonFont);
        exit.setFont(buttonFont);

        Dimension buttonDimension = new Dimension(200, 60);
        startGame.setPreferredSize(buttonDimension);
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
        this.add(startGame, c);
        c.gridy = 2;
        c.gridx = 0;
        this.add(newMap, c);
        c.gridy = 3;
        c.gridx = 0;
        this.add(loadMap, c);
        c.gridy = 4;
        c.gridx = 0;
        this.add(exit, c);


    }

    private void chooseMapFile() {
        int mapFileChooserState = mapFileChooser.showOpenDialog(MainMenuPanel.this);


        if (mapFileChooserState == JFileChooser.APPROVE_OPTION) {
            mainMenuController.loadMapInModel(mapFileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private FileFilter selectFileFilter() {
        return new FileNameExtensionFilter("Map Text Files", "txt");
    }

    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void notifyAllObservers(){
        for(PanelObserver observer : observers){
            observer.update("MapEditorPanel");
        }
    }

    public void setController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}

class BgPanel extends JPanel {
    Image bg = new ImageIcon("src/main/view/dinotopia-1-huge.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}