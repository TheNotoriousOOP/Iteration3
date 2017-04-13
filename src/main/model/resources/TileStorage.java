package model.resources;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TileStorage extends ResourceStorage{

    @Override
    void addGold(Gold gold) {
        pushGold(gold);
    }

    @Override
    void addCoins(Coins coins) {
        pushCoins(coins);
    }

    @Override
    void addStock(Stock stock) {
        pushStock(stock);
    }

    @Override
    void addTrunks(Trunks trunks) {
        pushTrunks(trunks);
    }

    @Override
    void addFuel(Fuel fuel) {
        pushFuel(fuel);
    }

    @Override
    void addIron(Iron iron) {
        pushIron(iron);
    }

    @Override
    void addClay(Clay clay) {
        pushClay(clay);
    }

    @Override
    void addStone(Stone stone) {
        pushStone(stone);
    }

    @Override
    void addBoards(Boards boards) {
        pushBoards(boards);
    }

    @Override
    void addGoose(Goose goose) {
        pushGoose(goose);
    }
    //TODO implement nothing I think
}
