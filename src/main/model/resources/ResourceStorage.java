package model.resources;

import model.ability_management.ability_set.AbilitySet;
import model.resources.resourceVisitor.ResourceVisitor;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class ResourceStorage {
    //keeps track of abilities of that set
    private AbilitySet abilitySet = new AbilitySet();

    // Size
    private int size = 0;

    //Resource ArrayLists
    private ArrayList<Gold> goldArrayList = new ArrayList<>();
    private ArrayList<Coins> coinsArrayList = new ArrayList<>();
    private ArrayList<Stock> stockArrayList =  new ArrayList<>();
    private ArrayList<Trunks> trunksArrayList = new ArrayList<>();
    private ArrayList<Iron> ironArrayList = new ArrayList<>();
    private ArrayList<Fuel> fuelArrayList = new ArrayList<>();
    private ArrayList<Clay> clayArrayList = new ArrayList<>();
    private ArrayList<Stone> stoneArrayList = new ArrayList<>();
    private ArrayList<Boards> boardsArrayList = new ArrayList<>();
    private ArrayList<Goose> gooseArrayList = new ArrayList<>();


    // Constructor
    public ResourceStorage(){

    }

    // Get count of resources in storage
    public int getSize() {
        int size = 0;
        size += goldArrayList.size();
        size += coinsArrayList.size();
        size += stockArrayList.size();
        size += trunksArrayList.size();
        size += ironArrayList.size();
        size += fuelArrayList.size();
        size += clayArrayList.size();
        size += stoneArrayList.size();
        size += boardsArrayList.size();
        size += gooseArrayList.size();
        return size;
    }

    // Check if the resource storage object is empty
    public boolean isEmpty() {
        return  (getSize() == 0) ? true : false;
    }

    public abstract void addResource(Resource resource);
    public abstract void addGold(Gold gold);
    public abstract void addCoins(Coins coins);
    public abstract void addStock(Stock stock);
    public abstract void addTrunks(Trunks trunks);
    public abstract void addFuel(Fuel fuel);
    public abstract void addIron(Iron iron);
    public abstract void addClay(Clay clay);
    public abstract void addStone(Stone stone);
    public abstract void addBoards(Boards boards);
    public abstract void addGoose(Goose goose);

    abstract Gold removeGold();
    abstract Coins removeCoins();
    abstract Stock removeStock();
    abstract Trunks removeTrunks();
    abstract Fuel removeFuel();
    abstract Iron removeIron();
    abstract Clay removeClay();
    abstract Stone removeStone();
    abstract Boards removeBoards();
    abstract Goose removeGoose();

    public ArrayList<Gold> getGoldArrayList() {
        return goldArrayList;
    }

    public ArrayList<Coins> getCoinsArrayList() {
        return coinsArrayList;
    }

    public ArrayList<Stock> getStockArrayList() {
        return stockArrayList;
    }

    public ArrayList<Trunks> getTrunksArrayList() {
        return trunksArrayList;
    }

    public ArrayList<Iron> getIronArrayList() {
        return ironArrayList;
    }

    public ArrayList<Fuel> getFuelArrayList() {
        return fuelArrayList;
    }

    public ArrayList<Clay> getClayArrayList() {
        return clayArrayList;
    }

    public ArrayList<Stone> getStoneArrayList() {
        return stoneArrayList;
    }

    public ArrayList<Boards> getBoardsArrayList() {
        return boardsArrayList;
    }

    public ArrayList<Goose> getGooseArrayList() {
        return gooseArrayList;
    }

    public abstract boolean exchangeFuel(Fuel fuel);

    protected boolean canMakeFuel(){
        if((boardsArrayList.size() + trunksArrayList.size()) >= 2)
            return true;
        return false;
    }

    protected void removeFuelCost(){
        int counter = 0;
        while(boardsArrayList.size() > 0){
            boardsArrayList.remove(trunksArrayList.size()-1);
            if(counter == 2)
                return;
        }
        while(trunksArrayList.size() > 0){
            trunksArrayList.remove(trunksArrayList.size()-1);
            if(counter == 2)
                return;
        }
    }

    public AbilitySet getAbilitySet() {
        return abilitySet;
    }

    public void acceptToAdd(ResourceVisitor visitor) {
        visitor.visitResourceStorageToAdd(this);
    }
    public void acceptToRemove(ResourceVisitor visitor) { visitor.visitResourceStorageToRemove(this);}
}
