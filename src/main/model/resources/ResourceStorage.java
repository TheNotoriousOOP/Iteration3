package model.resources;

import model.ability_management.ability_set.AbilitySet;
import model.resources.resourceVisitor.InnerResourceVisitor;
import model.resources.resourceVisitor.ResourceVisitor;

import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<Paper> paperArrayList = new ArrayList<>();


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
        size += paperArrayList.size();
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
    public abstract void addPaper(Paper paper);

    public abstract Gold removeGold();
    public abstract Coins removeCoins();
    public abstract Stock removeStock();
    public abstract Trunks removeTrunks();
    public abstract Fuel removeFuel();
    public abstract Iron removeIron();
    public abstract Clay removeClay();
    public abstract Stone removeStone();
    public abstract Boards removeBoards();
    public abstract Goose removeGoose();
    public abstract Paper removePaper();

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

    public ArrayList<Paper> getPaperArrayList() { return paperArrayList; }

    public abstract boolean exchangeFuel(Fuel fuel);
    public abstract boolean exchangeCoin(Coins coin);
    public abstract boolean exchangePaper(Paper paper);
    public abstract boolean exchangeBoards(Boards firstBoard, Boards secondBoard);
    public abstract boolean exchangeStock(Stock stockBond);
    public abstract boolean exchangeStone(Stone firstStone, Stone secondStone);

    protected boolean canMakeFuel(){
        if((boardsArrayList.size() + trunksArrayList.size()) >= 2)
            return true;
        return false;
    }

    protected void removeFuelCost(){
        int counter = 0;
        while(boardsArrayList.size() > 0){
            boardsArrayList.remove(trunksArrayList.size()-1);
            counter++;
            if(counter == 2)
                return;
        }
        while(trunksArrayList.size() > 0){
            trunksArrayList.remove(trunksArrayList.size()-1);
            counter++;
            if(counter == 2)
                return;
        }
    }

    protected boolean canMakeCoin() {
        if(goldArrayList.size() >= 2 && fuelArrayList.size() >= 1)
            return true;
        return false;
    }

    protected void removeCoinCost(){
        goldArrayList.remove(1);
        goldArrayList.remove(0);
        fuelArrayList.remove(0);
    }

    protected boolean canMakePaper(){
        if((boardsArrayList.size() + trunksArrayList.size()) >= 2){
            return true;
        }
        return false;
    }

    protected void removePaperCost(){
        int counter = 0;
        while(boardsArrayList.size() > 0){
            boardsArrayList.remove(trunksArrayList.size()-1);
            counter++;
            if(counter == 2)
                return;
        }
        while(trunksArrayList.size() > 0){
            trunksArrayList.remove(trunksArrayList.size()-1);
            counter++;
            if(counter == 2)
                return;
        }
    }
    protected boolean canMakeBoard(){
        if(trunksArrayList.size() >= 1)
            return true;
        return false;
    }
    protected void removeBoardCost(){
        trunksArrayList.remove(0);
    }

    public AbilitySet getAbilitySet() {
        return abilitySet;
    }

    protected boolean canMakeStock(){
        if(paperArrayList.size() >= 1 && coinsArrayList.size() >= 2)
            return true;
        return false;
    }
    protected void removeStockCost(){
        paperArrayList.remove(0);
        coinsArrayList.remove(1);
        coinsArrayList.remove(0);
    }

    protected boolean canMakeStone(){
        if(clayArrayList.size() >= 1)
            return true;
        return false;
    }
    protected void removeStoneCost(){
        clayArrayList.remove(0);
    }

    public List<String> getResourceStrings() {
        List<String> resourceStrings = new ArrayList<>();

        resourceStrings.add("Gold: " + goldArrayList.size());
        resourceStrings.add("Coins: " + coinsArrayList.size());
        resourceStrings.add("Stock: " + stockArrayList.size());
        resourceStrings.add("Trunks: " + trunksArrayList.size());
        resourceStrings.add("Iron: " + ironArrayList.size());
        resourceStrings.add("Fuel: " + fuelArrayList.size());
        resourceStrings.add("Clay: " + clayArrayList.size());
        resourceStrings.add("Stone: " + stoneArrayList.size());
        resourceStrings.add("Boards: " + boardsArrayList.size());
        resourceStrings.add("Goose: " + gooseArrayList.size());
        resourceStrings.add("Paper: " + paperArrayList.size());

        return resourceStrings;
    }



    //top-tier code
    public void accept(ResourceVisitor visitor) { visitor.visitResourceStorage(this);}
    public void acceptToAdd(InnerResourceVisitor visitor) {
        visitor.visitResourceStorageToAdd(this);
    }
    public void acceptToRemove(InnerResourceVisitor visitor) { visitor.visitResourceStorageToRemove(this);}
}
