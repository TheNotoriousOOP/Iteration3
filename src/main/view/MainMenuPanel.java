package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */

public class MainMenuPanel extends JPanel{
    private JLabel title;
    private JButton startGame;
    private JButton newMap;
    private JButton loadMap;
    private JButton exit;

    public MainMenuPanel(Dimension d){
        this.setPreferredSize(d);
        this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();

        this.title = new JLabel("Dinoboats & Dinoroads");
        Font titleFont = new Font("Times New Roman", Font.BOLD|Font.ITALIC, 72);
        title.setFont(titleFont);

        Font buttonFont = new Font("Times New Roman", Font.ITALIC, 36);
        this.startGame = new JButton("Start Game");
        this.newMap = new JButton("New Map");
        this.loadMap = new JButton(("Load Map"));
        this.exit = new JButton(("Exit"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startGame.setFont(buttonFont);
        newMap.setFont(buttonFont);
        loadMap.setFont(buttonFont);
        exit.setFont(buttonFont);

        Dimension buttonDimension = new Dimension(200, 60);
        startGame.setPreferredSize(buttonDimension);
        newMap.setPreferredSize(buttonDimension);
        loadMap.setPreferredSize(buttonDimension);
        exit.setPreferredSize(buttonDimension);

        GridBagConstraints t = new GridBagConstraints();
        t.gridx = 0;
        t.gridy = 0;
        t.insets = new Insets(0,0,160,0);
        t.fill = GridBagConstraints.BOTH;
        this.add(title, t);
        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(5, 0, 0, 0);
        this.add(startGame, c);
        c.gridy = 2;
        c.gridx = 0;
        this.add(newMap, c);
        c.gridy = 3;
        c.gridx = 0;
        this.add(loadMap, c);
        c.gridy = 4;
        c.gridx = 0;
        this.add(exit, c);


    }

}

class BgPanel extends JPanel {
    Image bg = new ImageIcon("src/main/view/dinotopia-1-huge.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}