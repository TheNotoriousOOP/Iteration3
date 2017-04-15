package model.resources;

import java.util.Stack;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class ResourceStorage {

    // Size
    private int size = 0;

    // Resource stacks
    private Stack<Gold> goldStack;
    private Stack<Coins> coinsStack;
    private Stack<Stock> stockStack;
    private Stack<Trunks> trunksStack;
    private Stack<Iron> ironStack;
    private Stack<Fuel> fuelStack;
    private Stack<Clay> clayStack;
    private Stack<Stone> stoneStack;
    private Stack<Boards> boardsStack;
    private Stack<Goose> gooseStack;

    // Constructor
    public ResourceStorage(){

        // Setup resource stacks
        this.goldStack = new Stack<Gold>();
        this.coinsStack = new Stack<Coins>();
        this.stockStack = new Stack<Stock>();
        this.trunksStack = new Stack<Trunks>();
        this.ironStack = new Stack<Iron>();
        this.fuelStack = new Stack<Fuel>();
        this.clayStack = new Stack<Clay>();
        this.stoneStack = new Stack<Stone>();
        this.boardsStack = new Stack<Boards>();
        this.gooseStack = new Stack<Goose>();

    }

    // Get count of resources in storage
    public int getSize() { return this.size; }

    // Check if the resource storage object is empty
    public boolean isEmpty() {
        return  (getSize() == 0) ? true : false;
    }

    // Add to the size count
    protected void incrementSize() { this.size++; }

    // Decrement from the size count
    protected void decrementSize() { this.size--; }

    //Abstract functions to add to stack
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

    protected void pushGold(Gold gold){
        goldStack.push(gold);
        incrementSize();
    }

    protected void pushCoins(Coins coins){
        coinsStack.push(coins);
        incrementSize();
    }

    protected void pushStock(Stock stock){
        stockStack.push(stock);
        incrementSize();
    }

    protected void pushTrunks(Trunks trunks){
        trunksStack.push(trunks);
        incrementSize();
    }

    protected void pushFuel(Fuel fuel){
        fuelStack.push(fuel);
        incrementSize();
    }

    protected void pushIron(Iron iron){
        ironStack.push(iron);
        incrementSize();
    }

    protected void pushClay(Clay clay){
        clayStack.push(clay);
        incrementSize();
    }

    protected void pushStone(Stone stone){
        stoneStack.push(stone);
        incrementSize();
    }

    protected void pushBoards(Boards boards){
        boardsStack.push(boards);
        incrementSize();
    }

    protected void pushGoose(Goose goose){
        gooseStack.push(goose);
        incrementSize();
    }


    //List of Popping Functions
    public Gold getGold() {
        decrementSize();
        return goldStack.pop();
    }

    public Coins getCoins() {
        decrementSize();
        return coinsStack.pop();
    }

    public Stock getStock() {
        decrementSize();
        return stockStack.pop();
    }

    public Trunks getTrunks() {
        decrementSize();
        return trunksStack.pop();
    }

    public Iron getIron() {
        decrementSize();
        return ironStack.pop();
    }

    public Fuel getFuel() {
        decrementSize();
        return fuelStack.pop();
    }

    public Clay getClay() {
        decrementSize();
        return clayStack.pop();
    }

    public Stone getStone() {
        decrementSize();
        return stoneStack.pop();
    }

    public Boards getBoards() {
        decrementSize();
        return boardsStack.pop();
    }

    public Goose getGoose() {
        decrementSize();
        return gooseStack.pop();
    }


    public abstract boolean exchangeFuel(Fuel fuel);

    protected boolean canMakeFuel(){
        if((boardsStack.size() + trunksStack.size()) >= 2)
            return true;
        return false;
    }

    protected void removeFuelCost(){
        int counter = 0;
        while(boardsStack.size() > 0){
            boardsStack.pop();
            if(counter == 2)
                return;
        }
        while(trunksStack.size() > 0){
            trunksStack.pop();
            if(counter == 2)
                return;
        }
    }
}
