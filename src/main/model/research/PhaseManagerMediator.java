package model.research;

import model.phase.Phase;
import model.phase.PhaseManager;

/**
 * Created by TheNotoriousOOP on 4/14/2017.
 * Class Description:
 * Responsibilities:
 */
public class PhaseManagerMediator {

    private PhaseManager phaseManager;

    public PhaseManagerMediator(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;
    }

    public void updatePhaseManager(){
        //TODO implement
    }

    public PhaseManager getPhaseManager() {
        return phaseManager;
    }

    public void setPhaseManager(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;
    }
}
