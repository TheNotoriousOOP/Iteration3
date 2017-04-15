package model.resources;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TileStorage extends ResourceStorage{

    public TileStorage() {
    }

    @Override
    public void addGold(Gold gold) {
        pushGold(gold);
    }

    @Override
    public void addCoins(Coins coins) {
        pushCoins(coins);
    }

    @Override
    public void addStock(Stock stock) {
        pushStock(stock);
    }

    @Override
    public void addTrunks(Trunks trunks) {
        pushTrunks(trunks);
    }

    @Override
    public void addFuel(Fuel fuel) {
        pushFuel(fuel);
    }

    @Override
    public void addIron(Iron iron) {
        pushIron(iron);
    }

    @Override
    public void addClay(Clay clay) {
        pushClay(clay);
    }

    @Override
    public void addStone(Stone stone) {
        pushStone(stone);
    }

    @Override
    public void addBoards(Boards boards) {
        pushBoards(boards);
    }

    @Override
    public void addGoose(Goose goose) {
        pushGoose(goose);
    }
    //TODO implement nothing I think
}
