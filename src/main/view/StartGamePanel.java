package view;

import view.assets.AssetLoader;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by TK on 4/15/17.
 */
public class StartGamePanel extends JPanel{

    private JButton newGame;
    private JButton loadGame;
    private JFileChooser newGameMapChooser;
    private JFileChooser savedGameMapChooser;
    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    public StartGamePanel(AssetLoader assets){
        newGame = new JButton("New Game");
        loadGame = new JButton("Load Game");
        newGameMapChooser = new JFileChooser(System.getProperty("user.dir"));
        savedGameMapChooser = new JFileChooser(System.getProperty("user.dir"));
        newGameMapChooser.setFileFilter(selectFileFilter());
        savedGameMapChooser.setFileFilter(selectFileFilter());
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseNewGameMapFile();
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseSavedGameMapFile();
            }
        });

        this.add(newGame);
        this.add(loadGame);
    }
    private void chooseNewGameMapFile() {
        int newGameMapFileChooserState = newGameMapChooser.showOpenDialog(StartGamePanel.this);

        if (newGameMapFileChooserState == JFileChooser.APPROVE_OPTION) {
            //startGameController.loadMapInModel(newGameMapChooser.getSelectedFile().getAbsolutePath());
            notifyAllObservers("GameViewPanel");
        }
    }
    private void chooseSavedGameMapFile() {
        int savedGameMapFileChooserState = newGameMapChooser.showOpenDialog(StartGamePanel.this);

        if (savedGameMapFileChooserState == JFileChooser.APPROVE_OPTION) {
            //startGameController.loadMapInModel(newGameMapChooser.getSelectedFile().getAbsolutePath());
            notifyAllObservers("GameViewPanel");
        }
    }
    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void notifyAllObservers(String panelName){
        for(PanelObserver observer : observers){
            observer.update(panelName);
        }
    }

    private FileFilter selectFileFilter() {
        return new FileNameExtensionFilter("Map Text Files", "txt");
    }
}
