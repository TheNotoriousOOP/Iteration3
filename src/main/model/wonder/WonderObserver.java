package model.wonder;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class WonderObserver {

    private int wonderSize;

    protected WonderObserver(int wonderSize) {
        this.wonderSize = wonderSize;
    }

    public void update(Wonder wonder){
        if (wonderSize == wonder.getSize())
            trigger();
    }

    protected abstract void trigger(); //TODO laugh at triggered meme

    public int getWonderSizeTrigger() {
        return wonderSize;
    }
}
