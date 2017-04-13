package view;

import controller.MapEditorController;
import model.map.tile.Tile;
import view.assets.AssetLoader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class MapEditorPanel extends JPanel{
    private JButton exitButton;
    private JButton saveButton;
    private JButton addTileButton;
    private JButton removeTileButton;
    private JPanel sidePanel;
    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();
    private java.util.List<MapEditorObserver> mapEditorObservers = new ArrayList<MapEditorObserver>();
    private AssetLoader assets;
    private JFileChooser mapFileChooser;

    private TileSelectionPanel tileSelectionPanel;
    private ZoomedTilePanel zoomedTilePanel;
    private BoardPanel board;

    public MapEditorPanel(Dimension d, AssetLoader assets) {

        this.setPreferredSize(d);
        this.setLayout(new GridBagLayout());

        // Add assets
        this.assets = assets;

        JPanel bottomButtonLayout = new JPanel(new GridLayout(3,2));
        JPanel topButtonLayout = new JPanel(new GridLayout(3,2));
        this.sidePanel = new JPanel(new GridLayout(4,1));
        Dimension sidePanelSize = new Dimension(300, 720);
        sidePanel.setMinimumSize(sidePanelSize);

        Icon saveIcon = new ImageIcon(assets.getImage("SAVE_ICON"));
        Icon addIcon = new ImageIcon(assets.getImage("ADD_ICON"));
        Icon removeIcon = new ImageIcon(assets.getImage("REMOVE_ICON"));
        Icon exitIcon = new ImageIcon(assets.getImage("EXIT_ICON"));

        this.exitButton = new JButton(exitIcon);
        this.saveButton = new JButton(saveIcon);
        this.addTileButton = new JButton(addIcon);
        this.removeTileButton = new JButton(removeIcon);

        addTileButton.setFocusable(false);
        removeTileButton.setFocusable(false);
        saveButton.setFocusable(false);

        addTileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAdd();
            }
        });
        removeTileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyRemove();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { notifySave(); }
        });
        mapFileChooser = new JFileChooser(System.getProperty("user.dir"));
        mapFileChooser.setFileFilter(new FileNameExtensionFilter("Map Text Files", "txt"));


        this.board = new BoardPanel(assets);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers();
            }
        });

        Dimension b = new Dimension(110, 60);
        saveButton.setPreferredSize(b);
        exitButton.setPreferredSize(b);
        addTileButton.setPreferredSize(b);
        removeTileButton.setPreferredSize(b);

        board.setBackground(Color.black);

        JPanel topGrid = new JPanel(new GridLayout(1,2));
        topGrid.add(addTileButton);
        topGrid.add(removeTileButton);

        JPanel emptyPanel = new JPanel(new GridLayout(1,1));
        setBackGroundColor(emptyPanel);
        JPanel newEmptyPanel = new JPanel(new GridLayout(1,1));
        setBackGroundColor(newEmptyPanel);
        setBackGroundColor(topButtonLayout);
        topButtonLayout.add(topGrid);
        topButtonLayout.add(emptyPanel);
        topButtonLayout.add(newEmptyPanel);
        sidePanel.add(topButtonLayout);

        GridBagConstraints topLevelC = new GridBagConstraints();
        topLevelC.gridx = 0;
        topLevelC.gridy = 0;
        topLevelC.weightx = 1;
        topLevelC.weighty = 1;
        topLevelC.anchor = GridBagConstraints.FIRST_LINE_START;
        topLevelC.fill = GridBagConstraints.BOTH;
        this.add(board, topLevelC);

        tileSelectionPanel = new TileSelectionPanel(); //init JPanel to TileSelectionPanel

        tileSelectionPanel.setPreferredSize(sidePanelSize);
        tileSelectionPanel.setMinimumSize(sidePanelSize);
        setBackGroundColor(tileSelectionPanel);

        sidePanel.add(tileSelectionPanel);

        this.zoomedTilePanel = new ZoomedTilePanel(assets);

        sidePanel.add(zoomedTilePanel);

        bottomButtonLayout.add(emptyPanel);
        bottomButtonLayout.add(newEmptyPanel);
        JPanel bottomGrid = new JPanel(new GridLayout(1,2));
        bottomGrid.add(saveButton);
        bottomGrid.add(exitButton);
        bottomButtonLayout.add(bottomGrid);
        setBackGroundColor(bottomButtonLayout);
        sidePanel.add(bottomButtonLayout);

        GridBagConstraints sideLevelC = new GridBagConstraints();
        sideLevelC.gridx = 1;
        sideLevelC.gridy = 0;
        sideLevelC.fill = GridBagConstraints.VERTICAL;
        setBackGroundColor(sidePanel);
        this.add(sidePanel, sideLevelC);
    }

    private void setBackGroundColor(JPanel jPanel){
        jPanel.setBackground(Color.darkGray);
    }

    public void getFocusToBoard(){
        board.setFocusable(true);
        board.requestFocusInWindow();
    }
    //sets JLabel text in TileSelectionPanel for terrain
    public void setTerrainInTileSelectionText(String terrain) {
        tileSelectionPanel.setTerrainTypeLabelText(terrain);
        zoomedTilePanel.updateTileTerrainImage(terrain);
    }

    //sets JLabel text in TileSelectionPanel for river
    public void setRiverConnectorsInTileSelectionText(String riverConnectors){
        tileSelectionPanel.setRiverConnectorsLabelText(riverConnectors);
        zoomedTilePanel.updateTileRiverImage(riverConnectors);
    }

    public void setTileRotationSelectionText(int tileRotation){
        updateZoomedRotation(tileRotation);
        tileSelectionPanel.setTileRotationText(String.valueOf(tileRotation));

    }

    public void setControllerAsKeyListener(MapEditorController mec){
        board.addKeyListener(mec);
    }

    // Rotate image in zoomed panel
    public void updateZoomedRotation(int rotation) {
        zoomedTilePanel.updateImageRotation(rotation);
    }


    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void attach(MapEditorObserver observer){
        mapEditorObservers.add(observer);
    }
    public void notifyAdd(){
        for(MapEditorObserver observer : mapEditorObservers){
            observer.updateAdd();
        }
    }
    public void notifyRemove(){
        for(MapEditorObserver observer : mapEditorObservers){
            observer.updateRemove();
        }
    }
    public void notifyAllObservers(){
        for(PanelObserver observer : observers){
            observer.update("MainMenuPanel");
        }
    }
    public void notifySave() {
        int mapFileChooserState = mapFileChooser.showSaveDialog(this);


        if (mapFileChooserState == JFileChooser.APPROVE_OPTION) {
            //mainMenuController.loadMapInModel(mapFileChooser.getSelectedFile().getAbsolutePath());
            for(MapEditorObserver observer : mapEditorObservers){
                observer.updateSave(mapFileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    public void updateBoard(Tile[][] mapAsGrid) {
        board.updateBoard(mapAsGrid);
    }

    public void highlightNorthWest(){
        board.highlightNorthWest();
    }
    public void highlightNorth(){
        board.highlightNorth();
    }
    public void highlightNorthEast(){
        board.highlightNorthEast();
    }
    public void highlightSouthWest(){
        board.highlightSouthWest();
    }
    public void highlightSouth(){
        board.highlightSouth();
    }
    public void highlightSouthEast(){
        board.highlightSouthEast();
    }

    public void moveCameraUp(){ board.moveCameraUp();}
    public void moveCameraDown(){ board.moveCameraDown();}
    public void moveCameraRight(){ board.moveCameraRight();}
    public void moveCameraLeft(){ board.moveCameraLeft();}

    public String getCurrentTerrainText(){
        return tileSelectionPanel.getTerrainTypeText();
    }
    public String getCurrentRiverConnectorsText() {
        return tileSelectionPanel.getRiverConnectorsText();
    }
    public String getTileRotationText(){
        return tileSelectionPanel.getTileRotationText();
    }
    public int getXCoord(){
        return board.getXCoord();
    }
    public int getYCoord(){
        return board.getYCoord();
    }

    //wrapper to refresh the board in the correct jpanel
    public void updateBoardInPanel(Tile[][] updatedBoard){
        board.updateBoard(updatedBoard);
    }

}

