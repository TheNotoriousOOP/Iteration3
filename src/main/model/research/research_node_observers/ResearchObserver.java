package model.research.research_node_observers;

public interface ResearchObserver {
    void onTruckFactoryResearched();
    void onSteamBoatFactoryResearched();
    void onRowBoatFactoryResearched();
    void onAdditionalMineShaftResearched();
    void onBigMineResearched();
    void onSpecializedMineResearched();
    void onOilRigResearched();
    void onLightBulbResearched();
}
