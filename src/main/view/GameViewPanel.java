package view;


import controller.GameControllerMediator;

import model.map.tile.Tile;
import model.transporters.Transporter;
import view.assets.AssetLoader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by TheNotoriousOOP
 * Class Description:
 * Responsibilities:
 */
public class GameViewPanel extends JPanel{

    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    private BoardPanel gameBoard;
    private AssetLoader assetLoader;
    private JPanel sidePanel;
    private JLabel phaseLabel;
    private JTextField phase;
    private JLabel playerLabel;
    private JTextField playerName;
    private JButton researchButton;
    private JButton wonderButton;
    private JButton exitButton;
    private JButton endTurnButton;
    private JButton fastForwardButton;

    private JPanel tileInfoPanel;
    private JLabel currentTransporterLabel;
    private DefaultListModel<String> abilityListModel;
    private JList<String> abilityList;
    private GameControllerMediator gameControllerMediator;

    //for printing out resources
        //available on node
    private DefaultListModel<String> resourceOnNodeListModel;
    private JList<String> resourceOnNodeList;
    private JLabel nodeResourceLabel;

        //all transporters
    private DefaultListModel<String> resourceOnTransporterListModel;
    private JList<String> resourceOnTransporterList;
    private JLabel transporterResourceLabel;

    public GameViewPanel(AssetLoader assetLoader){
        this.assetLoader = assetLoader;
        this.setLayout(new GridBagLayout());
        gameBoard = new BoardPanel(assetLoader);
        JPanel endTurnPanel = new JPanel(new GridBagLayout());

        sidePanel = new JPanel(new GridBagLayout());
        Dimension sidePanelDimension = new Dimension(350, 700);
        sidePanel.setMinimumSize(sidePanelDimension);
        sidePanel.setFocusable(false);

        JPanel extraInfoPanel = new JPanel(new GridLayout(4, 2));
        extraInfoPanel.setFocusable(false);


        phaseLabel = new JLabel("Phase: ");
        phase = new JTextField();
        phase.setBackground(Color.lightGray);
        Dimension textFieldD = new Dimension(80, 15);
        phase.setMinimumSize(textFieldD);
        phase.setEditable(false);
        phase.setFocusable(false);
        phaseLabel.setLabelFor(phase);
        GridBagConstraints c = new GridBagConstraints();

        playerLabel = new JLabel("Player:");
        playerName = new JTextField();
        playerName.setEditable(false);
        playerName.setFocusable(false);
        playerName.setBackground(Color.lightGray);
        playerLabel.setLabelFor(playerName);
        extraInfoPanel.add(phaseLabel);
        extraInfoPanel.add(phase);
        extraInfoPanel.add(playerLabel);
        extraInfoPanel.add(playerName);

        researchButton = new JButton("View Research");
        researchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers("ResearchTablePanel");
            }
        });

        researchButton.setFocusable(false);
        extraInfoPanel.add(researchButton);

        wonderButton = new JButton("View Wonder");
        wonderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers("WonderViewPanel");
            }
        });

        exitButton = new JButton("Exit to Menu");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers("MainMenuPanel");
            }
        });

        endTurnButton = new JButton("End Turn");
        endTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameControllerMediator.endTurn();

            }
        });

        fastForwardButton = new JButton("Fast Forward");
        fastForwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        wonderButton.setFocusable(false);
        exitButton.setFocusable(false);
        endTurnButton.setFocusable(false);
        extraInfoPanel.add(wonderButton);
        extraInfoPanel.add(exitButton);

        JButton saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        extraInfoPanel.add(saveButton);
        sidePanel.add(extraInfoPanel);

        tileInfoPanel = new JPanel();
        tileInfoPanel.setFocusable(false);
        Dimension tileInfoD = new Dimension(350, 500);
        tileInfoPanel.setMinimumSize(tileInfoD);
        //tileInfoPanel.setBackground(Color.black);
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 400;
        c.weighty = 180;
        c.gridy = 3;

        TitledBorder tileInfoBorder = BorderFactory.createTitledBorder("Tile Information");
        tileInfoPanel.setBorder(tileInfoBorder);

        //Add stuff to tile info that will display cycling stuff
        currentTransporterLabel = new JLabel();

        abilityListModel = new DefaultListModel<>();
        abilityList = new JList<>();
        abilityList.setModel(abilityListModel);
        abilityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tileInfoPanel.add(currentTransporterLabel);
        tileInfoPanel.add(abilityList);
        sidePanel.add(tileInfoPanel, c);

        JPanel resourceInfoPanel = new JPanel(new GridBagLayout());
        resourceInfoPanel.setFocusable(false);
        Dimension resourceInfoD = new Dimension(350, 200);
        resourceInfoPanel.setMinimumSize(resourceInfoD);

        //resource info
        resourceOnNodeListModel = new DefaultListModel<>();
        resourceOnNodeList = new JList<>();
        resourceOnNodeList.setModel(resourceOnNodeListModel);

        Dimension resourceListD = new Dimension(150, 170);
        resourceOnNodeList.setMinimumSize(resourceListD);
        nodeResourceLabel = new JLabel("Node:");

        resourceOnTransporterListModel = new DefaultListModel<>();
        resourceOnTransporterList = new JList<>();
        resourceOnTransporterList.setModel(resourceOnTransporterListModel);
        resourceOnTransporterList.setMinimumSize(resourceListD);
        transporterResourceLabel = new JLabel("Transporter:");
        //transporterResourceLabel.setLabelFor(resourceOnTransporterList);

        resourceOnNodeList.setFocusable(false);
        resourceOnTransporterList.setFocusable(false);
        resourceInfoPanel.setFocusable(false);
        GridBagConstraints resourceC = new GridBagConstraints();
        resourceC.gridx = 0;
        resourceC.gridy = 0;
        resourceC.insets = new Insets(-14, 0, 3, 13);
        resourceInfoPanel.add(nodeResourceLabel, resourceC);
        resourceC.gridx = 1;
        resourceC.gridy = 0;
        resourceC.insets = new Insets(-14, 13, 3, 0);
        resourceInfoPanel.add(transporterResourceLabel, resourceC);
        resourceC.gridx = 0;
        resourceC.gridy = 1;
        resourceC.gridwidth = 1;
        resourceC.weightx = 100;
        resourceC.fill = GridBagConstraints.HORIZONTAL;
        resourceC.insets = new Insets(5, 0, 0, 15);
        resourceInfoPanel.add(resourceOnNodeList, resourceC);
        resourceC.gridx = 1;
        resourceC.gridy = 1;
        resourceC.insets = new Insets(5, 15, 0, 0);
        resourceInfoPanel.add(resourceOnTransporterList, resourceC);

        TitledBorder resourceInfoBorder = BorderFactory.createTitledBorder("Resource Information");
        resourceInfoPanel.setBorder(resourceInfoBorder);

        c.gridx = 0;
        c.insets = new Insets(3, 0, 0, 0);
        c.weighty = 200;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 4;
        sidePanel.add(resourceInfoPanel, c);

        GridBagConstraints endTurnPanelC = new GridBagConstraints();
        endTurnPanelC.gridx = 0;
        endTurnPanelC.gridy = 0;
        endTurnPanelC.weightx = 1;
        endTurnPanelC.weighty = 1;
        endTurnPanel.add(endTurnButton, endTurnPanelC);
        endTurnPanelC.gridx = 1;
        endTurnPanel.add(fastForwardButton, endTurnPanelC);
        c.gridx = 0;
        c.weighty = 1;
        c.gridy = 5;
        sidePanel.add(endTurnPanel, c);

        GridBagConstraints ccc = new GridBagConstraints();
        ccc.gridx = 0;
        ccc.gridy = 0;
        ccc.fill = GridBagConstraints.BOTH;
        ccc.weightx = 1;
        ccc.weighty = 1;
        this.add(gameBoard, ccc);
        ccc.fill = GridBagConstraints.VERTICAL;
        ccc.weightx = 0.1;
        ccc.weighty = 0.3;
        ccc.gridx = 1;
        this.add(sidePanel, ccc);
    }

    public void moveCameraUp(){ gameBoard.moveCameraUp();}
    public void moveCameraDown(){ gameBoard.moveCameraDown();}
    public void moveCameraRight(){ gameBoard.moveCameraRight();}
    public void moveCameraLeft(){ gameBoard.moveCameraLeft();}

    public Point highlightNorthWest(){
        return gameBoard.highlightNorthWest();
    }
    public Point highlightNorth(){
        return gameBoard.highlightNorth();
    }
    public Point highlightNorthEast(){
        return gameBoard.highlightNorthEast();
    }
    public Point highlightSouthWest(){
        return gameBoard.highlightSouthWest();
    }
    public Point highlightSouth(){
        return gameBoard.highlightSouth();
    }
    public Point highlightSouthEast(){
        return gameBoard.highlightSouthEast();
    }

    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void notifyAllObservers(String panelName){
        for(PanelObserver observer : observers){
            observer.update(panelName);
        }
    }
    public void getFocusToBoard(){
        gameBoard.setFocusable(true);
        gameBoard.requestFocusInWindow();
    }
    public void addKeyListenerToBoard(KeyListener keyListener) {
        gameBoard.addKeyListener(keyListener);
    }

    public void updateBoard(Tile[][] mapAsGrid) {
        gameBoard.updateBoard(mapAsGrid);
    }

    public void updateTransporters(ArrayList<Transporter> allTransporters) {
        gameBoard.updateTransporters(allTransporters);
    }

    public void setCurrentTransporterString(String s) {
        currentTransporterLabel.setText(s);
    }

    public void setCurrentAbilitiesString(java.util.List<String> abilitiesString) {
        abilityListModel.clear();
        for (String abilityString : abilitiesString) {
            abilityListModel.addElement(abilityString);
        }
    }

    public void setResourceOnNodeString(List<String> resourceOnNodeString) {
        resourceOnNodeListModel.clear();
        for (String resourceString : resourceOnNodeString) {
            resourceOnNodeListModel.addElement(resourceString);
        }
    }

    public void setResourceOnTransporterString(List<String> resourceOnTransporterString) {
        resourceOnTransporterListModel.clear();
        for (String resourceString : resourceOnTransporterString) {
            resourceOnTransporterListModel.addElement(resourceString);
        }

    }
    public void setActiveAbilityString(String s) {
        abilityList.setSelectedIndex(abilityListModel.indexOf(s));
    }

    public void addControllerMediator(GameControllerMediator gameControllerMediator) {
        this.gameControllerMediator = gameControllerMediator;
    }
}
