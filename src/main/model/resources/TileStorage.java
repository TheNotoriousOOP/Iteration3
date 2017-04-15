package model.resources;

import model.ability_management.ability.Ability;
import model.ability_management.ability.resource_abilities.*;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TileStorage extends ResourceStorage {

    private ArrayList<PickUpBoardUtility> pickUpBoardAbilityAL = new ArrayList<>();
    private ArrayList<PickUpClayAbility> pickUpClayAbilityAL = new ArrayList<>();
    private ArrayList<PickUpCoinAbility> pickUpCoinAbilityAL = new ArrayList<>();
    private ArrayList<PickUpFuelAbility> pickUpFuelAbilityAL = new ArrayList<>();
    private ArrayList<PickUpGoldAbility> pickUpGoldAbilityAL = new ArrayList<>();
    private ArrayList<PickUpGooseAbility> pickUpGooseAbilityAL = new ArrayList<>();
    private ArrayList<PickUpIronAbility> pickUpIronAbilitiesAL = new ArrayList<>();
    private ArrayList<PickUpStockAbility> pickUpStockAbilityAL = new ArrayList<>();
    private ArrayList<PickUpTrunkAbility> pickUpTrunkAbilityAL = new ArrayList<>();
    private ArrayList<PickUpStoneAbility> pickUpStoneAbilitiesAL = new ArrayList<>();

    // Constructor
    public TileStorage() {
        super();
    }

    @Override
    void addResource(Resource resource) {

    }

    @Override
    public void addGold(Gold gold) {
        getGoldArrayList().add(gold);
        PickUpGoldAbility temp = new PickUpGoldAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpGoldAbilityAL.add(temp);
    }

    @Override
    public void addCoins(Coins coins) {
        getCoinsArrayList().add(coins);
        PickUpCoinAbility temp = new PickUpCoinAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpCoinAbilityAL.add(temp);
    }

    @Override
    public void addStock(Stock stock) {
        getStockArrayList().add(stock);
        PickUpStockAbility temp = new PickUpStockAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpStockAbilityAL.add(temp);
    }

    @Override
    public void addTrunks(Trunks trunks) {
        getTrunksArrayList().add(trunks);
        PickUpTrunkAbility temp = new PickUpTrunkAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpTrunkAbilityAL.add(temp);
    }

    @Override
    public void addFuel(Fuel fuel) {
        getFuelArrayList().add(fuel);
        PickUpFuelAbility temp = new PickUpFuelAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpFuelAbilityAL.add(temp);
    }

    @Override
    public void addIron(Iron iron) {
        getIronArrayList().add(iron);
        PickUpIronAbility temp = new PickUpIronAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpIronAbilitiesAL.add(temp);
    }

    @Override
    public void addClay(Clay clay) {
        getClayArrayList().add(clay);
        PickUpClayAbility temp = new PickUpClayAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpClayAbilityAL.add(temp);
    }

    @Override
    public void addStone(Stone stone) {
        getStoneArrayList().add(stone);
        PickUpStoneAbility temp = new PickUpStoneAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpStoneAbilitiesAL.add(temp);
    }

    @Override
    public void addBoards(Boards boards) {
        getBoardsArrayList().add(boards);
        PickUpBoardUtility temp = new PickUpBoardUtility();
        getAbilitySet().addValidAbility(temp);
        pickUpBoardAbilityAL.add(temp);
    }

    @Override
    public void addGoose(Goose goose) {
        getGooseArrayList().add(goose);
        PickUpGooseAbility temp = new PickUpGooseAbility();
        getAbilitySet().addValidAbility(temp);
        pickUpGooseAbilityAL.add(temp);
    }

    @Override
    public Gold removeGold() {
        getAbilitySet().removeAbilityFromValidList(pickUpGoldAbilityAL.remove(0));
        return getGoldArrayList().remove(0);
    }

    @Override
    public Coins removeCoins() {
        getAbilitySet().removeAbilityFromValidList(pickUpCoinAbilityAL.remove(0));
        return getCoinsArrayList().remove(0);
    }

    @Override
    public Stock removeStock() {
        getAbilitySet().removeAbilityFromValidList(pickUpStockAbilityAL.remove(0));
        return getStockArrayList().remove(0);
    }

    @Override
    public Trunks removeTrunks() {
        getAbilitySet().removeAbilityFromValidList(pickUpTrunkAbilityAL.remove(0));
        return getTrunksArrayList().remove(0);
    }

    @Override
    public Fuel removeFuel() {
        getAbilitySet().removeAbilityFromValidList(pickUpFuelAbilityAL.remove(0));
        return getFuelArrayList().remove(0);
    }

    @Override
    public Iron removeIron() {
        getAbilitySet().removeAbilityFromValidList(pickUpIronAbilitiesAL.remove(0));
        return getIronArrayList().remove(0);
    }

    @Override
    public Clay removeClay() {
        getAbilitySet().removeAbilityFromValidList(pickUpClayAbilityAL.remove(0));
        return getClayArrayList().remove(0);
    }

    @Override
    public Stone removeStone() {
        getAbilitySet().removeAbilityFromValidList(pickUpStoneAbilitiesAL.remove(0));
        return getStoneArrayList().remove(0);
    }

    @Override
    public Boards removeBoards() {
        getAbilitySet().removeAbilityFromValidList(pickUpBoardAbilityAL.remove(0));
        return getBoardsArrayList().remove(0);
    }

    @Override
    public Goose removeGoose() {
        getAbilitySet().removeAbilityFromValidList(pickUpGooseAbilityAL.remove(0));
        return getGooseArrayList().remove(0);
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
