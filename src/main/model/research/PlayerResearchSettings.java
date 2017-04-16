package model.research;

import model.research.research_node_observers.ResearchObserver;

public class PlayerResearchSettings implements ResearchObserver {

    // Settings for player
    private boolean oilRigsEnabled = false;
    private boolean additionalMineEnabled = false;
    private boolean bigMineEnabled = false;
    private boolean specializedMineEnabled = false;
    private boolean steamBoatsEnabled = false;
    private boolean rowBoatsEnabled = false;
    private boolean trucksEnabled = false;


    // Constructor
    public PlayerResearchSettings() {}

    // Enable oil rigs for this player
    private void enableOilRigs() { this.oilRigsEnabled = true; }

    // Enable additional mines for this player
    private void enableAddtionalMines() { this.additionalMineEnabled = true; }

    // Check if addtional mines enabled
    private boolean areAdditionalMinesEnabled() { return this.additionalMineEnabled; }

    // Enable big mines for this player
    private void enableBigMines() { this.bigMineEnabled = true; }

    // Enable specialized mines for this player
    private void enableSpecializedMines() { this.specializedMineEnabled = true; }

    // Enable steam boats for this player
    private void enableSteamBoats() { this.steamBoatsEnabled = true; }

    // Enable row boats for this player
    private void enableRowBoats() { this.rowBoatsEnabled = true; }

    // Enable trucks for this player
    private void enableTrucks() { this.trucksEnabled = true; }

    public boolean oilRigsEnabled() { return this.oilRigsEnabled; }

    public boolean additonalMineEnabled() { return this.additionalMineEnabled; }

    public boolean bigMineEnabled() { return this.bigMineEnabled; }

    public boolean specializedMineEnabled() { return this.specializedMineEnabled; }

    public boolean steamBoatsEnabled() { return steamBoatsEnabled; }

    public boolean rowBoatsEnabled() { return rowBoatsEnabled; }

    public boolean trucksEnabled() { return trucksEnabled; }

    @Override
    public void onTruckFactoryResearched() {
        enableTrucks();
    }

    @Override
    public void onSteamBoatFactoryResearched() {
        enableSteamBoats();
    }

    @Override
    public void onRowBoatFactoryResearched() {
        enableRowBoats();
    }

    @Override
    public void onAdditionalMineShaftResearched() {
        enableAddtionalMines();
    }

    @Override
    public void onBigMineResearched() {
        enableBigMines();
    }

    @Override
    public void onSpecializedMineResearched() {
        enableSpecializedMines();
    }

    @Override
    public void onOilRigResearched() {
        enableOilRigs();
    }

    @Override
    public void onLightBulbResearched() {
        // Rip
    }
}
