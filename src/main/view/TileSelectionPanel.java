package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by TheNotoriousOOP on 3/28/2017.
 * Class Description: the jpanel box on the bottom of the screen
 * Responsibilities: allow the player to select a type of tile to place
 */
public class TileSelectionPanel extends JPanel{
    private final JLabel selectTerrainTypeLabel = new JLabel("SHIFT  + \u2191 / \u2193 Terrain Type:"); //SHIFT + up & down arrow keys
    private final JLabel selectRiverConnectorsLabel =  new JLabel(" \u2191 / \u2193 # River Connectors:");//up & down arrow keys

    private JLabel terrainTypesLabel = new JLabel("Woods");
    private JLabel riverConnectorsLabel = new JLabel("1");

/*    private final String[] terrainTypes = {"Woods", "Pasture", "Rock", "Mountains", "Desert", "Sea"};
    private final String[] riverConnectorNumbers = {"0", "1" , "2 sharp", "2 wide", "3"};

    private int currentTerrainTypeIndex = 0;
    private int currentRiverConnectorsIndex = 0;

    private static final int SHIFT_KEY_CODE = 1;
    private static final int LEFT_KEY_CODE = 37;
    private static final int UP_KEY_CODE = 38;
    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE = 40;*/

    public TileSelectionPanel(){
        this.setLayout(new GridLayout(2,2));    //create 2x2 grid layout for labels

        this.add(selectTerrainTypeLabel);   //select terrain type on top left
        selectTerrainTypeLabel.setFont( new Font("TimesRoman", Font.PLAIN, 14));

        this.add(terrainTypesLabel);        //terrain types on top right
        terrainTypesLabel.setFont( new Font("TimesRoman", Font.BOLD, 20));

        this.add(selectRiverConnectorsLabel);   //select river connectors on bottom left
        selectRiverConnectorsLabel.setFont( new Font("TimesRoman", Font.PLAIN, 14));

        this.add(riverConnectorsLabel);         //river connectors on bottom right
        riverConnectorsLabel.setFont( new Font("TimesRoman", Font.BOLD, 20));



        requestFocusInWindow();
        setFocusable(true);

    }

    public void setTerrainTypeLabelText(String text){
        terrainTypesLabel.setText(text);
    }

    public void setRiverConnectorsLabelText(String text){
        riverConnectorsLabel.setText(text);
    }


}
