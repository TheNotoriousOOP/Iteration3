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

    public boolean isFull(){
        if(currentSize() < capacity)
            return false;
        return true;
    }

    @Override
    public void addGold(Gold gold) {
        if(!isFull())
            pushGold(gold);
    }

    @Override
    public void addCoins(Coins coins) {
        if(!isFull())
            pushCoins(coins);
    }

    @Override
    public void addStock(Stock stock) {
        if(!isFull())
            pushStock(stock);
    }

    @Override
    public void addTrunks(Trunks trunks) {
        if(!isFull())
            pushTrunks(trunks);
    }

    @Override
    public void addFuel(Fuel fuel) {
        if(!isFull())
            pushFuel(fuel);
    }

    @Override
    public void addIron(Iron iron) {
        if(!isFull())
            pushIron(iron);
    }

    @Override
    public void addClay(Clay clay) {
        if(!isFull())
            pushClay(clay);
    }

    @Override
    public void addStone(Stone stone) {
        if(!isFull())
            pushStone(stone);
    }

    @Override
    public void addBoards(Boards boards) {
        if(!isFull())
            pushBoards(boards);
    }

    @Override
    public void addGoose(Goose goose) {
        if(!isFull())
            pushGoose(goose);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
