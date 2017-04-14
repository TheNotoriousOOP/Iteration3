package model.phase;

import model.game.GameModel;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PhaseManager {

    private Phase[] phases;             // List of phases
    private ModelMediator mediator;     // Mediator to model

    private Phase currentPhase;         // Current phase
    private int currentPhaseIndex = 0;  // Current index of phase

    // Constructor
    public PhaseManager(ModelMediator mediator) {

        this.mediator = mediator;
        setupPhases();

    }

    // Initialize phases
    private void setupPhases() {

        Phase[] phases = new Phase[5];

        phases[0] = new TradingPhase();
        phases[1] = new ProductionPhase();
        phases[2] = new BuildPhase();
        phases[3] = new MovementPhase();
        phases[4] = new WonderPhase();

        this.phases = phases;
        this.currentPhase = phases[this.currentPhaseIndex];

    }

    // Get the current phase
    public Phase getCurrentPhase() {
        return currentPhase;
    }

    // Set the chosen phase to current
    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
    }

    // Get all phases
    public Phase[] getPhases() {
        return phases;
    }

    // Set the phases
    public void setPhases(Phase[] phases) {
        this.phases = phases;
    }

    // Move to next phase
    public void nextPhase() {

        endCurrentPhase();

        this.currentPhase = phases[this.currentPhaseIndex++];
        this.currentPhaseIndex %= phases.length;

        startCurrentPhase();

    }

    // Start the current phase
    public void startCurrentPhase() {
        this.currentPhase.startPhase(this.mediator);
    }

    // End the current phase
    public void endCurrentPhase() {
        this.currentPhase.endPhase(this.mediator);
    }

}
