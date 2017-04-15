package controller;

import javafx.scene.input.KeyCode;
import model.transporters.TransportManager;

import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class TransporterController extends KeyEventHandler {
    TransportManager currentTransportManager;
    AbilityController abilityController;

    public TransporterController(AbilityController abilityController, TransportManager transportManager) {
        this.abilityController = abilityController;
        this.currentTransportManager = transportManager;
    }

    @Override
    public void handle(int keyCode) throws IllegalArgumentException{
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                cycleLeft();
                break;
            case KeyEvent.VK_RIGHT:
                cycleRight();
                break;
            default:
                throw new IllegalArgumentException("class TransporterController does not recognize input: " + KeyEvent.getKeyText(keyCode));
        }
    }

    public void setCurrentTransportManager(TransportManager transportManager) {
        this.currentTransportManager = transportManager;
    }

    private void cycleLeft() {
        //Get prev transporter ability set
        updateAbilityController();
    }

    private void cycleRight() {
        //Get next transporter ability set
    }

    private void updateAbilityController() {
        abilityController.setAbilitySet();
    }
}
