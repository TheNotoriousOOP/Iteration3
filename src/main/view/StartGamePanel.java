package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TK on 4/15/17.
 */
public class StartGamePanel extends JPanel{

    private JButton newGame;
    private JButton loadGame;
    private JFileChooser mapFileChooser;

    public StartGamePanel(){
        newGame = new JButton("New Game");
        loadGame = new JButton("Load Game");


        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
