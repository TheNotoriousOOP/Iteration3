package model.resources;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportStorage extends ResourceStorage {

    // Capacity of the Transporter
    private int capacity;

    // Constructor
    public TransportStorage(int capacity) {
        this.capacity = capacity;
    }

    // Check if transporter capcacity filled
    public boolean isFull() {
        return (getSize() == getCapacity()) ? true : false;
    }

    // Return capcity
    public int getCapacity() {
        return capacity;
    }

    // Set new capacity for transporter
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Transport add methods
    @Override
    public void addResource(Resource resource) {
        resource.addToStorage(this);
    }

    @Override
    public void addGold(Gold gold) {
        if (!isFull()) pushGold(gold);
    }

    @Override
    public void addCoins(Coins coins) {
        if (!isFull()) pushCoins(coins);
    }

    @Override
    public void addStock(Stock stock) {
        if (!isFull()) pushStock(stock);
    }

    @Override
    public void addTrunks(Trunks trunks) {
        if (!isFull()) pushTrunks(trunks);
    }

    @Override
    public void addFuel(Fuel fuel) {
        if (!isFull()) pushFuel(fuel);
    }

    @Override
    public void addIron(Iron iron) {
        if (!isFull()) pushIron(iron);
    }

    @Override
    public void addClay(Clay clay) {
        if (!isFull()) pushClay(clay);
    }

    @Override
    public void addStone(Stone stone) {
        if (!isFull()) pushStone(stone);
    }

    @Override
    public void addBoards(Boards boards) {
        if (!isFull()) pushBoards(boards);
    }

    @Override
    public void addGoose(Goose goose) {
        if (!isFull()) pushGoose(goose);
    }

}
