package view;

import view.assets.AssetLoader;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

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
    private JTextField phase;
    private JLabel player;
    private JTextField playerName;
    private JButton researchButton;
    private JButton wonderButton;

    public GameViewPanel(Dimension d, AssetLoader assetLoader){
        this.assetLoader = assetLoader;
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(d);
        gameBoard = new BoardPanel(assetLoader);

        sidePanel = new JPanel(new GridBagLayout());
        Dimension sidePanelDimension = new Dimension(200, 700);
        sidePanel.setPreferredSize(sidePanelDimension);
        JLabel label = new JLabel("Phase: ");
        phase = new JTextField("sdfsdf");
        Dimension textFieldD = new Dimension(80, 15);
        phase.setMinimumSize(textFieldD);
        phase.setEditable(false);
        phase.setFocusable(false);
        label.setLabelFor(phase);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(3, 0, 0, 0);
        sidePanel.add(label, c);
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(0, -130, 0, 0);
        c.gridx = 1;
        sidePanel.add(phase, c);

        player = new JLabel("Player:");
        playerName = new JTextField("dsfsdfdsf");
        playerName.setEditable(false);
        playerName.setFocusable(false);
        player.setLabelFor(playerName);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 30;
        c.insets = new Insets(3, 0, 0, 0);
        sidePanel.add(player,c);
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(0, -130, 0, 0);
        c.gridx = 1;
        sidePanel.add(playerName, c);

//        researchButton = new JButton("View Research");
//        c.gridx = 0;
//        c.gridy = 2;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.weighty = 1000;
//        c.insets = new Insets(0, 0, 0, 0);
//        sidePanel.add(researchButton);
//
//        wonderButton = new JButton("View Wonder");
//        c.gridx = 1;
//        c.gridy = 2;
//        sidePanel.add(wonderButton);

        JPanel tileInfoPanel = new JPanel();
        Dimension tileInfoD = new Dimension(300, 200);
        tileInfoPanel.setMinimumSize(tileInfoD);
        tileInfoPanel.setBackground(Color.black);
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 400;
        c.weighty = 700;
        c.gridy = 3;
        sidePanel.add(tileInfoPanel, c);

        JPanel resourceInfoPanel = new JPanel();
        Dimension resourceInfoD = new Dimension(300, 200);
        resourceInfoPanel.setMinimumSize(resourceInfoD);
        resourceInfoPanel.setBackground(Color.blue);
        c.gridx = 0;
        c.insets = new Insets(3, 0, 0, 0);
        c.weighty = 200;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 4;
        sidePanel.add(resourceInfoPanel, c);

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
    public void attach(PanelObserver observer){
        observers.add(observer);
    }
}
