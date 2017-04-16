package model.phase.observers;

import model.phase.WonderPhaseMediator;

// Observe phase changes
public interface PhaseObserver {
    void onTradePhaseStart();
    void onProductionPhaseStart();
    void onBuildPhaseStart();
    void onMovementPhaseStart();
    void onWonderPhaseStart(WonderPhaseMediator mediator);
}
