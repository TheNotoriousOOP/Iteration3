package view;

import controller.GameController;
import controller.GameControllerMediator;
import view.assets.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SwapOrderPanel extends JPanel {

    // Panel observers
    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    private AssetLoader loader; // Assets

    // Mediator to controller
    private GameControllerMediator controllerMediator;

    private JButton swapButton; // Swap button
    private JButton keepButton; // Keep button

    private Font fontButton = new Font("Times New Roman", Font.BOLD, 20);


    // Constructor
    public SwapOrderPanel(AssetLoader loader) {

        this.loader = loader;   // Set loader

        this.setLayout(new GridBagLayout());

        // Setup buttons
        swapButton = new JButton("Swap Turn Order");
        keepButton = new JButton("Keep Current Order");
        Dimension d = new Dimension(350, 200);
        swapButton.setPreferredSize(d);
        keepButton.setPreferredSize(d);
        
        // Setup button events
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerMediator.swapPlayers();
                notifyAllObservers("GameViewPanel");
            }
        });
        keepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers("GameViewPanel");
            }
        });

        // Add the buttons
        this.add(swapButton);
        this.add(keepButton);

    }

    // Attach new panel observer
    public void attach(PanelObserver observer){
        observers.add(observer);
    }

    // Notify observers
    public void notifyAllObservers(String panelName){
        for(PanelObserver observer : observers){
            observer.update(panelName);
        }
    }
    
    public void addControllerMediator(GameControllerMediator mediator) {
        this.controllerMediator = mediator;
    }


}
