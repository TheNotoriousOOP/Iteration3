package model.wonder;

import model.map.MapInterface;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class IrrigateObserver extends WonderObserver{

    public final static int IRRIGATE_NUMBER = 45;

    private MapInterface mapReference;

    public IrrigateObserver(MapInterface map) {
        super(IRRIGATE_NUMBER);
        this.mapReference = map;
    }

    @Override
    protected void trigger() {
        //TODO: put irrigation in map interface
        //map.irrigate()
    }
}
