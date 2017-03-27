package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JPanel topArea;
    private JPanel bottomArea;
    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    public MapEditorPanel(Dimension d) {

        this.setPreferredSize(d);
        this.setLayout(new GridBagLayout());

        this.topArea = new JPanel(new GridBagLayout());
        this.exit = new JButton("Exit");
        this.save = new JButton("Save");
        this.addOrRemove = new JButton("Add/Remove");
        Dimension mN = new Dimension(300, 30);
        this.mapName = new JTextField("");
        mapName.setPreferredSize(mN);
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

        JPanel mapPlaceHolder = new JPanel();
        Dimension mapDimension = new Dimension(1200, 550);
        mapPlaceHolder.setPreferredSize(mapDimension);
        mapPlaceHolder.setBackground(Color.black);
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
        topArea.add(mapPlaceHolder, c);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        this.add(topArea, c);

        bottomArea = new JPanel(new GridBagLayout());
        JPanel terrainInfoPanel = new JPanel();
        Dimension terrainInfoDimension = new Dimension(500, 120);
        terrainInfoPanel.setPreferredSize(terrainInfoDimension);
        terrainInfoPanel.setBackground(Color.black);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0,250, 5, 20);
        c.anchor = GridBagConstraints.CENTER;
        bottomArea.add(terrainInfoPanel, c);

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
        bottomArea.add(addOrRemove, c);
        GridBagConstraints bA = new GridBagConstraints();
        bA.gridx = 0;
        bA.gridy = 1;
        bA.gridwidth = 5;
        bA.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(bottomArea, bA);

    }
    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void notifyAllObservers(){
        for(PanelObserver observer : observers){
            observer.update("MainMenuPanel");
        }
    }
}
