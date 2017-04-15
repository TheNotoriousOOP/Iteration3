package model.resources;

import model.ability_management.ability.Ability;
import model.ability_management.ability.resource_abilities.*;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportStorage extends ResourceStorage {


    //lists of dropoff abilities
    ArrayList<DropOffGoldAbility> dropOffGoldAbilities = new ArrayList<>();
    ArrayList<DropOffCoinAbility> dropOffCoinAbilities = new ArrayList<>();
    ArrayList<DropOffStockAbility> dropOffStockAbilities = new ArrayList<>();
    ArrayList<DropOffTrunkAbility> dropOffTrunkAbilities = new ArrayList<>();
    ArrayList<DropOffFuelAbility> dropOffFuelAbilities = new ArrayList<>();
    ArrayList<DropOffIronAbility> dropOffIronAbilities = new ArrayList<>();
    ArrayList<DropOffClayAbility> dropOffClayAbilities = new ArrayList<>();
    ArrayList<DropOffStoneAbility> dropOffStoneAbilities = new ArrayList<>();
    ArrayList<DropOffBoardAbility> dropOffBoardAbilities = new ArrayList<>();
    ArrayList<DropOffGooseAbility> dropOffGooseAbilities = new ArrayList<>();

    // Capacity of the Transporter
    private int capacity;

    // Constructor
    public TransportStorage(int capacity) {
        this.capacity = capacity;
    }


    @Override
    void addResource(Resource resource) {

    }

    @Override
    void addGold(Gold gold) {
        getGoldArrayList().add(gold);

        DropOffGoldAbility tmp = new DropOffGoldAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffGoldAbilities.add(tmp);
    }

    @Override
    void addCoins(Coins coins) {
        getCoinsArrayList().add(coins);

        DropOffCoinAbility tmp = new DropOffCoinAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffCoinAbilities.add(tmp);
    }

    @Override
    void addStock(Stock stock) {
        getStockArrayList().add(stock);

        DropOffStockAbility tmp = new DropOffStockAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffStockAbilities.add(tmp);
    }

    @Override
    void addTrunks(Trunks trunks) {
        getTrunksArrayList().add(trunks);

        DropOffTrunkAbility tmp = new DropOffTrunkAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffTrunkAbilities.add(tmp);
    }

    @Override
    void addFuel(Fuel fuel) {
        getFuelArrayList().add(fuel);

        DropOffFuelAbility tmp = new DropOffFuelAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffFuelAbilities.add(tmp);

    }

    @Override
    void addIron(Iron iron) {
        getIronArrayList().add(iron);

        DropOffIronAbility tmp = new DropOffIronAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffIronAbilities.add(tmp);
    }

    @Override
    void addClay(Clay clay) {
        getClayArrayList().add(clay);

        DropOffClayAbility tmp = new DropOffClayAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffClayAbilities.add(tmp);
    }

    @Override
    void addStone(Stone stone) {
        getStoneArrayList().add(stone);

        DropOffStoneAbility tmp = new DropOffStoneAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffStoneAbilities.add(tmp);
    }

    @Override
    void addBoards(Boards boards) {
        getBoardsArrayList().add(boards);

        DropOffBoardAbility tmp = new DropOffBoardAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffBoardAbilities.add(tmp);
    }

    @Override
    void addGoose(Goose goose) {
        getGooseArrayList().add(goose);

        DropOffGooseAbility tmp = new DropOffGooseAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffGooseAbilities.add(tmp);
    }

    @Override
    Gold removeGold() {
        getAbilitySet().removeAbilityFromValidList(dropOffGoldAbilities.remove(0));
        return getGoldArrayList().remove(0);
    }

    @Override
    Coins removeCoins() {
        getAbilitySet().removeAbilityFromValidList(dropOffCoinAbilities.remove(0));
        return getCoinsArrayList().remove(0);
    }

    @Override
    Stock removeStock() {
        getAbilitySet().removeAbilityFromValidList(dropOffStockAbilities.remove(0));
        return getStockArrayList().remove(0);
    }

    @Override
    Trunks removeTrunks() {
        getAbilitySet().removeAbilityFromValidList(dropOffTrunkAbilities.remove(0));
        return getTrunksArrayList().remove(0);
    }

    @Override
    Fuel removeFuel() {
        getAbilitySet().removeAbilityFromValidList(dropOffFuelAbilities.remove(0));
        return getFuelArrayList().remove(0);
    }

    @Override
    Iron removeIron() {
        getAbilitySet().removeAbilityFromValidList(dropOffIronAbilities.remove(0));
        return getIronArrayList().remove(0);
    }

    @Override
    Clay removeClay() {
        getAbilitySet().removeAbilityFromValidList(dropOffClayAbilities.remove(0));
        return getClayArrayList().remove(0);
    }

    @Override
    Stone removeStone() {
        getAbilitySet().removeAbilityFromValidList(dropOffStoneAbilities.remove(0));
        return getStoneArrayList().remove(0);
    }

    @Override
    Boards removeBoards() {
        getAbilitySet().removeAbilityFromValidList(dropOffBoardAbilities.remove(0));
        return getBoardsArrayList().remove(0);
    }

    @Override
    Goose removeGoose() {
        getAbilitySet().removeAbilityFromValidList(dropOffGoldAbilities.remove(0));
        return getGooseArrayList().remove(0);
    }

    @Override
    public boolean exchangeFuel(Fuel fuel) {
        return false;
    }
}
