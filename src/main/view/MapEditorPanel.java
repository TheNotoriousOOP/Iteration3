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

    public MapEditorPanel(Dimension d) {

        this.setPreferredSize(d);
        this.setLayout(new GridBagLayout());

        this.exit = new JButton("Exit");
        this.save = new JButton("Save");
        this.addOrRemove = new JButton("Add/Remove");
        this.mapName = new JTextField("Map Name");

        Dimension b = new Dimension(90, 30);
        mapName.setPreferredSize(b);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(mapName, c);

        JPanel mapPlaceHolder = new JPanel();
        Dimension mapDimension = new Dimension(700, 550);
        mapPlaceHolder.setPreferredSize(mapDimension);
        mapPlaceHolder.setBackground(Color.black);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 5;
        c.weighty = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        this.add(mapPlaceHolder, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        this.add(exit, c);

        JPanel terrainInfoPanel = new JPanel();
        Dimension terrainInfoDimension = new Dimension(400, 150);
        terrainInfoPanel.setPreferredSize(terrainInfoDimension);
        terrainInfoPanel.setBackground(Color.black);
        c.gridx = 1;
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(terrainInfoPanel, c);

        JPanel zoomedTilePanel = new JPanel();
        Dimension zoomedTileDimension = new Dimension(300, 100);
        terrainInfoPanel.setPreferredSize(zoomedTileDimension);
        terrainInfoPanel.setBackground(Color.black);
        c.gridx = 2;
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(zoomedTilePanel, c);

    }
}
