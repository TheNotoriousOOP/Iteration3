package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TheNotoriousOOP on 3/28/2017.
 * Class Description: the jpanel box on the bottom of the screen
 * Responsibilities: allow the player to select a type of tile to place
 */
public class TileSelectionPanel extends JPanel{
    private final JLabel selectTerrainTypeLabel = new JLabel("SHIFT  + \u2191 / \u2193 Terrain Type:", SwingConstants.CENTER); //SHIFT + up & down arrow keys
    private final JLabel selectRiverConnectorsLabel =  new JLabel(" \u2191 / \u2193 # River Connectors:", SwingConstants.CENTER);//up & down arrow keys
    private final JLabel selectTileRotationLabel =  new JLabel(" \u2190 / \u2192 Tile Rotation Degree: ", SwingConstants.CENTER);//up & down arrow keys

    private JLabel terrainTypesLabel = new JLabel("Woods", SwingConstants.CENTER);
    private JLabel riverConnectorsLabel = new JLabel("0", SwingConstants.CENTER);
    private JLabel tileRotationsLabel = new JLabel("0", SwingConstants.CENTER);


    private MapEditorPanel mapEditorPanel;
    public TileSelectionPanel(){
        this.setLayout(new GridLayout(6,1));    //create 2x2 grid layout for labels

        this.add(selectTerrainTypeLabel);   //select terrain type on top left
        selectTerrainTypeLabel.setFont( new Font("TimesRoman", Font.PLAIN, 20));
        selectTerrainTypeLabel.setForeground(Color.white);

        this.add(terrainTypesLabel);        //terrain types on top right
        terrainTypesLabel.setFont( new Font("TimesRoman", Font.BOLD, 20));
        terrainTypesLabel.setForeground(Color.white);

        this.add(selectRiverConnectorsLabel);   //select river connectors on bottom left
        selectRiverConnectorsLabel.setFont( new Font("TimesRoman", Font.PLAIN, 20));
        selectRiverConnectorsLabel.setForeground(Color.white);

        this.add(riverConnectorsLabel);         //river connectors on bottom right
        riverConnectorsLabel.setFont( new Font("TimesRoman", Font.BOLD, 20));
        riverConnectorsLabel.setForeground(Color.white);

        this.add(selectTileRotationLabel);
        selectTileRotationLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        selectTileRotationLabel.setForeground(Color.white);

        this.add(tileRotationsLabel);         //river connectors on bottom right
        tileRotationsLabel.setFont( new Font("TimesRoman", Font.BOLD, 20));
        tileRotationsLabel.setForeground(Color.white);
        tileRotationsLabel.


        requestFocusInWindow();
        setFocusable(true);

    }

    public void setTerrainTypeLabelText(String text){
        terrainTypesLabel.setText(text);
    }

    public void setRiverConnectorsLabelText(String text){
        riverConnectorsLabel.setText(text);
    }

    public void setTileRotationText(String text) {
        tileRotationsLabel.setText(text);
    }

    public String getTerrainTypeText(){
        return terrainTypesLabel.getText();
    }

    public String getRiverConnectorsText(){
        return riverConnectorsLabel.getText();
    }

    public String getTileRotationText() {
        return tileRotationsLabel.getText();
    }

}
