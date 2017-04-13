package model.wonder;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class WonderObserver {

    private int wonderSize;

    public void update(Wonder wonder){
        //TODO implement
    }

    protected void trigger(){
        //TODO implement
        //TODO laugh at triggered meme
    }

    public int getWonderSize() {
        return wonderSize;
    }

    public void setWonderSize(int wonderSize) {
        this.wonderSize = wonderSize;
    }
}
