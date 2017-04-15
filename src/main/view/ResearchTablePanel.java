package view;

import view.assets.AssetLoader;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class ResearchTablePanel extends JPanel {

    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    private Icon brightIdea;
    private Icon drilling;
    private Icon enlargement;
    private Icon newShafts;
    private Icon rowing;
    private Icon shipping;
    private Icon specialization;
    private Icon trucking;

    private JButton truckingButton;
    private JButton brightIdeaButton;
    private JButton drillingButton;
    private JButton enlargementButton;
    private JButton rowingButton;
    private JButton newShaftsButton;
    private JButton shippingButton;
    private JButton specializationButton;

    public ResearchTablePanel(AssetLoader assets){

        this.brightIdea = new ImageIcon(assets.getImage("BRIGHT_IDEA"));
        this.drilling = new ImageIcon(assets.getImage("DRILLING"));
        this.enlargement = new ImageIcon(assets.getImage("ENLARGEMENT"));
        this.newShafts = new ImageIcon(assets.getImage("NEW_SHAFTS"));
        this.rowing = new ImageIcon(assets.getImage("ROWING"));
        this.shipping = new ImageIcon(assets.getImage("SHIPPING"));
        this.specialization = new ImageIcon(assets.getImage("SPECIALIZATION"));
        this.trucking = new ImageIcon(assets.getImage("TRUCKING"));

        this.truckingButton = new JButton(trucking);
        this.brightIdeaButton = new JButton(brightIdea);
        this.drillingButton = new JButton(drilling);
        this.enlargementButton = new JButton(enlargement);
        this.rowingButton = new JButton(rowing);
        this.newShaftsButton = new JButton(newShafts);
        this.shippingButton = new JButton(shipping);
        this.specializationButton = new JButton(specialization);

        this.add(truckingButton);
        this.add(brightIdeaButton);
        this.add(drillingButton);
        this.add(enlargementButton);
        this.add(rowingButton);
        this.add(newShaftsButton);
        this.add(shippingButton);
        this.add(specializationButton);
    }

    public void attach(PanelObserver observer){
        observers.add(observer);
    }
//    public void notifyAllObservers(String panelName){
//        for(PanelObserver observer : observers){
//            observer.update(panelName);
//        }
//    }
}
