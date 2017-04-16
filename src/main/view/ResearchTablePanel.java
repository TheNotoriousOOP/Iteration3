package view;

import com.sun.xml.internal.ws.resources.DispatchMessages;
import view.assets.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

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
    private JButton backToGame;

    private JPanel researchInfoPanel;
    private JTextArea researchInfo;
    private Image background;
    private AssetLoader assets;
    private HashMap<JButton, String> researchInfoTexts = new HashMap<>();
    public ResearchTablePanel(AssetLoader assets){

        this.assets = assets;
        this.background = assets.getImage("RESEARCHBG");
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

        truckingButton.setBackground(Color.black);
        brightIdeaButton.setBackground(Color.black);
        drillingButton.setBackground(Color.black);
        enlargementButton.setBackground(Color.black);
        rowingButton.setBackground(Color.black);
        newShaftsButton.setBackground(Color.black);
        shippingButton.setBackground(Color.black);
        specializationButton.setBackground(Color.black);

        researchInfoTexts.put(rowingButton, "Rowing: Upon researching, ability to build rowboat factories is achieved.");
        researchInfoTexts.put(brightIdeaButton, "Bright Idea: No effect. Reserved for expansion rules.");
        researchInfoTexts.put(truckingButton, "Trucking: Upon researching, ability to build truck factories is achieved.");
        researchInfoTexts.put(shippingButton, "Shipping: Upon researching, ability to build steam-ship factories is achieved.");
        researchInfoTexts.put(drillingButton, "Drilling: Upon researching, ability to build oil-rigs is achieved.");
        researchInfoTexts.put(specializationButton, "Specialization: Upon researching, ability to fill mine bags with either gold or iron is achieved.");
        researchInfoTexts.put(enlargementButton, "Enlargement: Upon researching, ability to fill mine bags with 5 gold and 5 iron is achieved.");
        researchInfoTexts.put(newShaftsButton, "New Shafts: Upon researching, ability to replenish bags of existing mines is achieved.");

        this.backToGame = new JButton("Back to Game");
        Dimension ddd = new Dimension(30,30);
        backToGame.setPreferredSize(ddd);
        backToGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers("GameViewPanel");
            }
        });

        JPanel buttonPanels = new JPanel();
        buttonPanels.add(truckingButton);
        buttonPanels.add(brightIdeaButton);
        buttonPanels.add(drillingButton);
        buttonPanels.add(enlargementButton);
        buttonPanels.add(rowingButton);
        buttonPanels.add(newShaftsButton);
        buttonPanels.add(shippingButton);
        buttonPanels.add(specializationButton);
        buttonPanels.setBackground(Color.black);

        shippingButton.getText();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        this.add(buttonPanels, c);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;

        researchInfoPanel = new JPanel(new GridLayout(2,1));
        researchInfo = new JTextArea(" ");
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        researchInfo.setFont(font);
        researchInfo.setForeground(Color.cyan);
        researchInfo.setBackground(Color.black);
        Dimension d = new Dimension(500, 60);
        researchInfo.setPreferredSize(d);
        researchInfo.setEditable(false);
        researchInfo.setLineWrap(true);
        researchInfo.setWrapStyleWord(true);
        researchInfoPanel.add(researchInfo);
        researchInfoPanel.add(backToGame);
        researchInfoPanel.setBackground(Color.black);

        truckingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(truckingButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        brightIdeaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(brightIdeaButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        drillingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(drillingButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        enlargementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(enlargementButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        specializationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(specializationButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        rowingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(rowingButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        newShaftsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(newShaftsButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });
        shippingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                researchInfo.setText(researchInfoTexts.get(shippingButton));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                researchInfo.setText(" ");
            }
        });

        this.add(researchInfoPanel, c);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);

        g2.drawImage(background, 0,0,getWidth(), getHeight(), this);
    }

    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void notifyAllObservers(String panelName){
        for(PanelObserver observer : observers){
            observer.update(panelName);
        }
    }
}
