package model.resources;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportStorage extends ResourceStorage{
    private int capacity;

    public TransportStorage(int capacity) {
        this.capacity = capacity;
    }

    boolean isFull(){
        return false;
    }

    @Override
    public void addGold(Gold gold) {
        //TODO implement with limit
        pushGold(gold);
    }

    @Override
    public void addCoins(Coins coins) {
        //TODO implement with limit
        pushCoins(coins);
    }

    @Override
    public void addStock(Stock stock) {
        //TODO implement with limit
        pushStock(stock);
    }

    @Override
    public void addTrunks(Trunks trunks) {
        //TODO implement with limit
        pushTrunks(trunks);
    }

    @Override
    public void addFuel(Fuel fuel) {
        //TODO implement with limit
        pushFuel(fuel);
    }

    @Override
    public void addIron(Iron iron) {
        //TODO implement with limit
        pushIron(iron);
    }

    @Override
    public void addClay(Clay clay) {
        //TODO implement with limit
        pushClay(clay);
    }

    @Override
    public void addStone(Stone stone) {
        //TODO implement with limit
        pushStone(stone);
    }

    @Override
    public void addBoards(Boards boards) {
        //TODO implement with limit
        pushBoards(boards);
    }

    @Override
    public void addGoose(Goose goose) {
        //TODO implement with limit
        pushGoose(goose);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
