package model.resources;

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
    ArrayList<DropOffPaperAbility> dropOffPaperAbilities = new ArrayList<>();

    // Capacity of the Transporter
    private int capacity;

    // Constructor
    public TransportStorage(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return (getSize() >= getCapacity()) ? true : false;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void addResource(Resource resource) {
        resource.addToStorage(this);
    }

    @Override
    public void addGold(Gold gold) {
        getGoldArrayList().add(gold);
        DropOffGoldAbility tmp = new DropOffGoldAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffGoldAbilities.add(tmp);
    }

    @Override
    public void addCoins(Coins coins) {
        getCoinsArrayList().add(coins);
        DropOffCoinAbility tmp = new DropOffCoinAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffCoinAbilities.add(tmp);
    }

    @Override
    public void addStock(Stock stock) {
        getStockArrayList().add(stock);
        DropOffStockAbility tmp = new DropOffStockAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffStockAbilities.add(tmp);
    }

    @Override
    public void addTrunks(Trunks trunks) {
        getTrunksArrayList().add(trunks);
        DropOffTrunkAbility tmp = new DropOffTrunkAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffTrunkAbilities.add(tmp);
    }

    @Override
    public void addFuel(Fuel fuel) {
        getFuelArrayList().add(fuel);
        DropOffFuelAbility tmp = new DropOffFuelAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffFuelAbilities.add(tmp);

    }

    @Override
    public void addIron(Iron iron) {
        getIronArrayList().add(iron);
        DropOffIronAbility tmp = new DropOffIronAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffIronAbilities.add(tmp);
    }

    @Override
    public void addClay(Clay clay) {
        getClayArrayList().add(clay);
        DropOffClayAbility tmp = new DropOffClayAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffClayAbilities.add(tmp);
    }

    @Override
    public void addStone(Stone stone) {
        getStoneArrayList().add(stone);
        DropOffStoneAbility tmp = new DropOffStoneAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffStoneAbilities.add(tmp);
    }

    @Override
    public void addBoards(Boards boards) {
        getBoardsArrayList().add(boards);
        DropOffBoardAbility tmp = new DropOffBoardAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffBoardAbilities.add(tmp);
    }

    @Override
    public void addGoose(Goose goose) {
        getGooseArrayList().add(goose);
        DropOffGooseAbility tmp = new DropOffGooseAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffGooseAbilities.add(tmp);
    }

    @Override
    public void addPaper(Paper paper) {
        getPaperArrayList().add(paper);
        DropOffPaperAbility tmp = new DropOffPaperAbility();
        getAbilitySet().addValidAbility(tmp);
        dropOffPaperAbilities.add(tmp);
    }

    @Override
    public Gold removeGold() {
        getAbilitySet().removeAbilityFromValidList(dropOffGoldAbilities.remove(0));
        return getGoldArrayList().remove(0);
    }

    @Override
    public Coins removeCoins() {
        getAbilitySet().removeAbilityFromValidList(dropOffCoinAbilities.remove(0));
        return getCoinsArrayList().remove(0);
    }

    @Override
    public Stock removeStock() {
        getAbilitySet().removeAbilityFromValidList(dropOffStockAbilities.remove(0));
        return getStockArrayList().remove(0);
    }

    @Override
    public Trunks removeTrunks() {
        getAbilitySet().removeAbilityFromValidList(dropOffTrunkAbilities.remove(0));
        return getTrunksArrayList().remove(0);
    }

    @Override
    public Fuel removeFuel() {
        getAbilitySet().removeAbilityFromValidList(dropOffFuelAbilities.remove(0));
        return getFuelArrayList().remove(0);
    }

    @Override
    public Iron removeIron() {
        getAbilitySet().removeAbilityFromValidList(dropOffIronAbilities.remove(0));
        return getIronArrayList().remove(0);
    }

    @Override
    public Clay removeClay() {
        getAbilitySet().removeAbilityFromValidList(dropOffClayAbilities.remove(0));
        return getClayArrayList().remove(0);
    }

    @Override
    public Stone removeStone() {
        getAbilitySet().removeAbilityFromValidList(dropOffStoneAbilities.remove(0));
        return getStoneArrayList().remove(0);
    }

    @Override
    public Boards removeBoards() {
        getAbilitySet().removeAbilityFromValidList(dropOffBoardAbilities.remove(0));
        return getBoardsArrayList().remove(0);
    }

    @Override
    public Goose removeGoose() {
        getAbilitySet().removeAbilityFromValidList(dropOffGooseAbilities.remove(0));
        return getGooseArrayList().remove(0);
    }

    @Override
    public Paper removePaper() {
        getAbilitySet().removeAbilityFromValidList(dropOffPaperAbilities.remove(0));
        return getPaperArrayList().remove(0);
    }

    @Override
    public boolean exchangeFuel(Fuel fuel) {
        if(canMakeFuel()) {
            removeFuelCost();
            addFuel(fuel);
            return true;
        }
        return false;
    }

    @Override
    public boolean exchangeCoin(Coins coin){
        if(canMakeCoin()){
            removeCoinCost();
            addCoins(coin);
            return true;
        }
        return false;
    }

    @Override
    public boolean exchangePaper(Paper paper){
        if(canMakePaper()) {
            removePaperCost();
            addPaper(paper);
            return true;
        }
        return false;
    }

    @Override
    public boolean exchangeBoards(Boards boardOne, Boards boardTwo){
        if(canMakeBoard()) {
            removeBoardCost();
            addBoards(boardOne);
            addBoards(boardTwo);
            return true;
        }
        return false;
    }

    @Override
    public boolean exchangeStock(Stock stockBond){
        if(canMakeStock()){
            removeStockCost();
            addStock(stockBond);
            return true;
        }
        return false;
    }

    @Override
    public boolean exchangeStone(Stone stoneOne, Stone stoneTwo){
        if(canMakeStone()){
            removeStoneCost();
            addStone(stoneOne);
            addStone(stoneTwo);
            return true;
        }
        return false;
    }
}
