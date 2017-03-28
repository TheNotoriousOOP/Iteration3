package model.map.tile;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: represents the division of a hex tile
 * Responsibilities:
 *  for editor deliverable: only used for water matching validation
 */
public class Zone {
    ZoneTypeEnum zoneType;
    ArrayList<Zone> neighbors;

    public Zone(ZoneTypeEnum zoneType){
        this.zoneType = zoneType;
        this.neighbors = new ArrayList<Zone>();
    }

    public void connectZone(Zone zone){
        neighbors.add(zone);
    }
    public void disconnectZone(Zone zone){
        neighbors.remove(zone);
    }

    public boolean isCompatible(Zone otherZone){
        if(this.zoneType == ZoneTypeEnum.SEA || otherZone.zoneType == ZoneTypeEnum.SEA)
            return true;
        else {
            if (this.zoneType == ZoneTypeEnum.RIVER) {
                if (otherZone.zoneType == ZoneTypeEnum.RIVER || otherZone.zoneType == ZoneTypeEnum.SOURCE)
                    return true;
                else
                    return false;
            }
            else if (this.zoneType == ZoneTypeEnum.SOURCE) {
                if (otherZone.zoneType == ZoneTypeEnum.RIVER || otherZone.zoneType == ZoneTypeEnum.SOURCE)
                    return true;
                else
                    return false;
            }
            else if (this.zoneType == ZoneTypeEnum.TERRAIN && otherZone.zoneType == ZoneTypeEnum.TERRAIN) {
                return true;
            }
            else
                return false;
        }
    }
    private boolean isRiver(){
        if(this.zoneType == ZoneTypeEnum.RIVER)
            return true;
        else
            return false;
    }
    public void connectRivers(Zone[] zones){
        for(Zone zone : zones) {
            if (this.isRiver() && zone.isRiver())
                this.connectZone(zone);
        }
    }
    public boolean hasWater(){
        if(this.zoneType == ZoneTypeEnum.RIVER || this.zoneType == ZoneTypeEnum.SOURCE)
            return true;
        else
            return false;
    }
}

