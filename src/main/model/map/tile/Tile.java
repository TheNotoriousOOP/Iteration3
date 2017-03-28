package model.map.tile;

import model.map.CubeVector;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Top of tile hierarchy for map editor and the game map
 * Responsibilities: Contain all attributes necessary across tile
 */
public abstract class Tile {

    private CubeVector location;
    private Zone[] zones;

    public Tile(CubeVector location, Zone[] zones){
        this.location = location;
        this.zones = zones;
    }

    public CubeVector getLocation() {
        return location;
    }

    public CubeVector getAdjustedLocation(int x, int y, int z) { return this.location.offsetCubeVector(x, y, z); }

    public CubeVector getAdjustedLocation(CubeVector offset) { return this.location.offsetCubeVector(offset); }

    public void setAdjustedLocation(CubeVector offset) { this.location = this.location.offsetCubeVector(offset); }

    public void setAdjustedLocation(int x, int y, int z) { this.location = this.location.offsetCubeVector(x, y, z); }

    public void setLocation(CubeVector location) {
        this.location = location;
    }

    public Zone[] getZones() {
        return zones;
    }

    //Offset by 1 for ease of use
    public Zone getSpecificZone(int number){
        if(number < 0 || number > 5){
            System.out.println("CLASS TILE: Error with zones");
            return zones[0];
        }
        return zones[number-1];
    }

    //public abstract void buildStructure(Structure target);
    //Not needed until Phase 2

    public String getZonesString() {

        //Return null string if there are no water zones
        String zonesString = "";

        //Append faces that have water
        for (int zoneIndex = 0; zoneIndex < zones.length; zoneIndex++) {
            if (zones[zoneIndex].isHasWater()) {
                //Account for switch from index to face number
                zonesString += String.valueOf(zoneIndex+1) + " ";
            }
        }

        //Append and prepend parens if there water zones were found in loop above
        if (!zonesString.equals("")) {
            zonesString = "( " + zonesString + ")";
        }

        return zonesString;
    }

}
