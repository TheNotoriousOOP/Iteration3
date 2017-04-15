package view;

import controller.GameController;
import view.assets.AssetLoader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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

    public GameViewPanel(AssetLoader assetLoader){
        this.assetLoader = assetLoader;
        this.setLayout(new GridBagLayout());
        gameBoard = new BoardPanel(assetLoader);

        sidePanel = new JPanel(new GridBagLayout());
        Dimension sidePanelDimension = new Dimension(250, 700);
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
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(3, 0, 0, 0);
//        sidePanel.add(label, c);
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(0, -130, 0, 0);
        c.gridx = 1;
//        sidePanel.add(phase, c);

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
        c.gridx = 3;
        c.gridy = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weighty = 1000;
        c.insets = new Insets(0, 0, 0, 0);
        researchButton.setFocusable(false);
        extraInfoPanel.add(researchButton);
//        sidePanel.add(researchButton);

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
        c.gridx = 4;
        c.gridy = 1;
        wonderButton.setFocusable(false);
        exitButton.setFocusable(false);
        extraInfoPanel.add(wonderButton);
        extraInfoPanel.add(exitButton);

//        sidePanel.add(wonderButton);

        JButton saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        extraInfoPanel.add(saveButton);
        sidePanel.add(extraInfoPanel);

        JPanel tileInfoPanel = new JPanel();
        tileInfoPanel.setFocusable(false);
        Dimension tileInfoD = new Dimension(300, 200);
        tileInfoPanel.setMinimumSize(tileInfoD);
        //tileInfoPanel.setBackground(Color.black);
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 400;
        c.weighty = 700;
        c.gridy = 3;

        TitledBorder tileInfoBorder = BorderFactory.createTitledBorder("Tile Information");
        tileInfoPanel.setBorder(tileInfoBorder);
        sidePanel.add(tileInfoPanel, c);

        JPanel resourceInfoPanel = new JPanel();
        resourceInfoPanel.setFocusable(false);
        Dimension resourceInfoD = new Dimension(300, 200);
        resourceInfoPanel.setMinimumSize(resourceInfoD);

        TitledBorder resourceInfoBorder = BorderFactory.createTitledBorder("Resource Information");
        resourceInfoPanel.setBorder(resourceInfoBorder);

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
}
