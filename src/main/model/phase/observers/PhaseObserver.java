package model.phase.observers;

// Observe phase changes
public interface PhaseObserver {
    void onTradePhaseStart();
    void onProductionPhaseStart();
    void onBuildPhaseStart();
    void onMovementPhaseStart();
    void onWonderPhaseStart();
}
