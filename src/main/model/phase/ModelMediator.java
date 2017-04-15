package model.phase;

import model.game.GameModel;
import model.phase.visitors.PhaseNotificationVisitor;

// Setup mediator to communicate between the GameModel && PhaseManager
public class ModelMediator {

    private GameModel model;    // Model ref

    // Constructor
    public ModelMediator(GameModel model) {
        this.model = model;
    }

    // Mediate to model the visitors to notify current phase
    public void updateModel(PhaseNotificationVisitor v) {
        this.model.accept(v);
    }

}
