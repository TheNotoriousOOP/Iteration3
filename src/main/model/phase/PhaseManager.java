package model.phase;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PhaseManager {

    private Phase[] phases;
    private Phase currentPhase;


    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
    }

    public Phase[] getPhases() {
        return phases;
    }

    public void setPhases(Phase[] phases) {
        this.phases = phases;
    }
}
