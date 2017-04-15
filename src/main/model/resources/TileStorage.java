package model.resources;

import model.ability_management.ability.resource_abilities.PickUpGoldAbility;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TileStorage extends ResourceStorage {

    // Constructor
    public TileStorage() {
        super();
    }

    @Override
    void addResource(Resource resource) {

    }

    @Override
    void addGold(Gold gold) {
        //getAbilitySet().addValidAbility(new PickUpGoldAbility());
    }

    @Override
    void addCoins(Coins coins) {

    }

    @Override
    void addStock(Stock stock) {

    }

    @Override
    void addTrunks(Trunks trunks) {

    }

    @Override
    void addFuel(Fuel fuel) {

    }

    @Override
    void addIron(Iron iron) {

    }

    @Override
    void addClay(Clay clay) {

    }

    @Override
    void addStone(Stone stone) {

    }

    @Override
    void addBoards(Boards boards) {

    }

    @Override
    void addGoose(Goose goose) {

    }

    @Override
    Gold removeGold() {
        return null;
    }

    @Override
    Coins removeCoins() {
        return null;
    }

    @Override
    Stock removeStock() {
        return null;
    }

    @Override
    Trunks removeTrunks() {
        return null;
    }

    @Override
    Fuel removeFuel() {
        return null;
    }

    @Override
    Iron removeIron() {
        return null;
    }

    @Override
    Clay removeClay() {
        return null;
    }

    @Override
    Stone removeStone() {
        return null;
    }

    @Override
    Boards removeBoards() {
        return null;
    }

    @Override
    Goose removeGoose() {
        return null;
    }


    @Override
    public boolean exchangeFuel(Fuel fuel){
        if(canMakeFuel()) {
            removeFuelCost();
            addFuel(fuel);
            return true;
        }
        return false;
    }

}
