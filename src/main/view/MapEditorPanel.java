package view;

import controller.MapEditorController;
import model.map.tile.Tile;
import view.assets.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class MapEditorPanel extends JPanel{
    private JTextField mapName;
    private JButton exit;
    private JButton save;
    private JButton add;
    private JButton remove;
    private JPanel topArea;
    private JPanel bottomArea;
    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();
    private java.util.List<AddOrRemoveObserver> addOrRemoveObservers = new ArrayList<AddOrRemoveObserver>();
    private AssetLoader assets;

    private TileSelectionPanel tileSelectionPanel;
    private BoardPanel board;

    public MapEditorPanel(Dimension d, AssetLoader assets) {

        this.setPreferredSize(d);
        this.setLayout(new GridBagLayout());

        // Add assets
        this.assets = assets;

        this.topArea = new JPanel(new GridBagLayout());
        this.exit = new JButton("Exit");
        this.save = new JButton("Save");
        this.add = new JButton("Add");
        this.remove = new JButton("Remove");

        add.setFocusable(false);
        remove.setFocusable(false);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAdd();
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyRemove();
            }
        });
        Dimension mN = new Dimension(300, 30);
        this.mapName = new JTextField("");
        mapName.setPreferredSize(mN);

        this.tileSelectionPanel = new TileSelectionPanel();
        this.board = new BoardPanel();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers();
            }
        });

        Dimension b = new Dimension(90, 30);
        //mapName.setPreferredSize(b);
        save.setPreferredSize(b);
        exit.setPreferredSize(b);

        GridBagConstraints c = new GridBagConstraints();

        board.setBackground(Color.white);
        JScrollPane jSP = new JScrollPane(board);
        Dimension jPB = new Dimension(1200, 550);
        jSP.setPreferredSize(jPB);
        jSP.setFocusable(false);

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        topArea.add(mapName, c);
        c.gridx = 1;
        topArea.add(save, c);
        c.gridx = 2;
        topArea.add(exit, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        topArea.add(jSP, c);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        this.add(topArea, c);
        bottomArea = new JPanel(new GridBagLayout());
        tileSelectionPanel = new TileSelectionPanel(); //init JPanel to TileSelectionPanel
        Dimension terrainInfoDimension = new Dimension(500, 120);
        tileSelectionPanel.setPreferredSize(terrainInfoDimension);
        tileSelectionPanel.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0,250, 5, 20);
        c.anchor = GridBagConstraints.CENTER;
        bottomArea.add(tileSelectionPanel, c);
        JPanel zoomedTilePanel = new JPanel();
        Dimension zoomedTileDimension = new Dimension(120, 120);
        zoomedTilePanel.setPreferredSize(zoomedTileDimension);
        zoomedTilePanel.setBackground(Color.blue);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0, 10, 5, 0);
        bottomArea.add(zoomedTilePanel, c);

        c.gridx = 2;
        c.insets = new Insets(0,40,0,0);
        bottomArea.add(add, c);
        c.gridx = 3;
        c.insets = new Insets(0,5,0,0);
        bottomArea.add(remove, c);
        GridBagConstraints bA = new GridBagConstraints();
        bA.gridx = 0;
        bA.gridy = 1;
        bA.gridwidth = 5;
        bA.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(bottomArea, bA);
    }
    public void getFocusToBoard(){
        board.setFocusable(true);
        board.requestFocusInWindow();
    }
    //sets JLabel text in TileSelectionPanel for terrain
    public void setTerrainInTileSelectionText(String terrain){
        tileSelectionPanel.setTerrainTypeLabelText(terrain);
    }

    //sets JLabel text in TileSelectionPanel for river
    public void setRiverConnectorsInTileSelectionText(String riverConnectors){
        tileSelectionPanel.setRiverConnectorsLabelText(riverConnectors);
    }

    public void setControllerAsKeyListener(MapEditorController mec){
        board.addKeyListener(mec);
    }


    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void attach(AddOrRemoveObserver observer){
        addOrRemoveObservers.add(observer);
    }
    public void notifyAdd(){
        for(AddOrRemoveObserver observer : addOrRemoveObservers){
            observer.updateAdd();
        }
    }
    public void notifyRemove(){
        for(AddOrRemoveObserver observer : addOrRemoveObservers){
            observer.updateRemove();
        }
    }
    public void notifyAllObservers(){
        for(PanelObserver observer : observers){
            observer.update("MainMenuPanel");
        }
    }

    public void updateBoard(Tile[][] mapAsGrid) {
        board.updateBoard(mapAsGrid);
    }

    public void highlightNorthWest(){
        board.highlightNorthWest();
    }
    public void hightlightNorth(){
        board.hightlightNorth();
    }
    public void hightlightNorthEast(){
        board.hightlightNorthEast();
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


    public String getCurrentTerrainText(){
        return tileSelectionPanel.getTerrainTypeText();
    }
    public String getCurrentRiverConnectorsText() {
        return tileSelectionPanel.getRiverConnectorsText();
    }
    public int getX(){
        return board.getX();
    }
    public int getY(){
        return board.getY();
    }

    //wrapper to refresh the board in the correct jpanel
    public void updateBoardInPanel(Tile[][] updatedBoard){
        board.updateBoard(updatedBoard);
    }

}

