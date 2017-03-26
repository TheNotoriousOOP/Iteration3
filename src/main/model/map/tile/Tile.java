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

}
