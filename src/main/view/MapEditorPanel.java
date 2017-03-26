package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class MapEditorPanel extends Panel{
    private JTextField mapName;
    private JButton exit;
    private JButton save;
    private JButton addOrRemove;

    public MapEditorPanel(){

        this.setLayout(new GridBagLayout());
        this.exit = new JButton("Exit");
        this.save = new JButton("Save");
        this.mapName = new JTextField("Map Name");
    }
}
