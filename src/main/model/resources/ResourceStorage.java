package model.resources;

import java.util.Stack;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class ResourceStorage {

    static public int size = 0;

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

    public ResourceStorage(){
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


    boolean isEmpty(){
        //TODO implement
        return true;
    }

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
    }

    protected void pushCoins(Coins coins){
        coinsStack.push(coins);
    }

    protected void pushStock(Stock stock){
        stockStack.push(stock);
    }

    protected void pushTrunks(Trunks trunks){
        trunksStack.push(trunks);
    }

    protected void pushFuel(Fuel fuel){
        fuelStack.push(fuel);
    }

    protected void pushIron(Iron iron){
        ironStack.push(iron);
    }

    protected void pushClay(Clay clay){
        clayStack.push(clay);
    }

    protected void pushStone(Stone stone){
        stoneStack.push(stone);
    }

    protected void pushBoards(Boards boards){
        boardsStack.push(boards);
    }

    protected void pushGoose(Goose goose){
        gooseStack.push(goose);
    }


    //List of Popping Functions
    Gold getGold(){
        return goldStack.pop();
    }

    Coins getCoins(){
        return coinsStack.pop();
    }

    Stock getStock(){
        return stockStack.pop();
    }

    Trunks getTrunks(){
        return trunksStack.pop();
    }

    Iron getIron(){
        return ironStack.pop();
    }

    Fuel getFuel(){
        return fuelStack.pop();
    }

    Clay getClay(){
        return clayStack.pop();
    }

    Stone getStone(){
        return stoneStack.pop();
    }

    Boards getBoards(){
        return boardsStack.pop();
    }

    Goose getGoose(){
        return gooseStack.pop();
    }


    //LIST OF ACCESSORS
    public Stack<Gold> getGoldStack() {
        return goldStack;
    }

    public void setGoldStack(Stack<Gold> goldStack) {
        this.goldStack = goldStack;
    }

    public Stack<Coins> getCoinsStack() {
        return coinsStack;
    }

    public void setCoinsStack(Stack<Coins> coinsStack) {
        this.coinsStack = coinsStack;
    }

    public Stack<Stock> getStockStack() {
        return stockStack;
    }

    public void setStockStack(Stack<Stock> stockStack) {
        this.stockStack = stockStack;
    }

    public Stack<Trunks> getTrunksStack() {
        return trunksStack;
    }

    public void setTrunksStack(Stack<Trunks> trunksStack) {
        this.trunksStack = trunksStack;
    }

    public Stack<Iron> getIronStack() {
        return ironStack;
    }

    public void setIronStack(Stack<Iron> ironStack) {
        this.ironStack = ironStack;
    }

    public Stack<Fuel> getFuelStack() {
        return fuelStack;
    }

    public void setFuelStack(Stack<Fuel> fuelStack) {
        this.fuelStack = fuelStack;
    }

    public Stack<Clay> getClayStack() {
        return clayStack;
    }

    public void setClayStack(Stack<Clay> clayStack) {
        this.clayStack = clayStack;
    }

    public Stack<Stone> getStoneStack() {
        return stoneStack;
    }

    public void setStoneStack(Stack<Stone> stoneStack) {
        this.stoneStack = stoneStack;
    }

    public Stack<Boards> getBoardsStack() {
        return boardsStack;
    }

    public void setBoardsStack(Stack<Boards> boardsStack) {
        this.boardsStack = boardsStack;
    }

    public Stack<Goose> getGooseStack() {
        return gooseStack;
    }

    public void setGooseStack(Stack<Goose> gooseStack) {
        this.gooseStack = gooseStack;
    }

}
