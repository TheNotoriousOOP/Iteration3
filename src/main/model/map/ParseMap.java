package model.map;

import model.map.tile.*;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Customer-PC on 3/26/2017.
 */
public class ParseMap {

    private String tileData[];
    private int size;

    public ParseMap(String[] data) {
        this.size = Integer.decode(data[0]);
        this.tileData = Arrays.copyOfRange(data, 1, data.length);
    }

    public Iterator getIterator() {
        return new Iterator() {
            int itr;

            @Override
            public boolean hasNext() {
                return (itr < size);
            }

            @Override
            public Object next() {
                return parse(tileData[itr++]);
            }
        };
    }

    //This is awful - don't look up to it
    private Tile parse(String s) {
        System.out.println("Parsing string " + s);
        boolean river = s.length() > 6;
        String[] parts = s.split("\\s+");
        CubeVector v = new CubeVector(Integer.decode(parts[1]), Integer.decode(parts[2]), Integer.decode(parts[3]));
        Zone[] zones = new Zone[6];
        if(river) {
            for(int iii = 0; iii <6; iii++)
                zones[iii] = new Zone(false, true);
            int connections = s.length() - 8;
            boolean[] water = new boolean[6];
            for(int iii = 0; iii < connections; iii++) {
                water[Integer.decode(parts[7+iii])] = true;
            }
            for(int iii = 0; iii <6; iii++) {
                zones[iii] = new Zone(water[iii], true);
            }

        } else {
            for(int iii = 0; iii <6; iii++)
                zones[iii] = new Zone(false, true);
        }
        switch(parts[5]) {
            case "woods":
                return new WoodsTile(v, zones);
            case "pasture":
                return new PastureTile(v, zones);
            case "rock":
                return new RockTile(v, zones);
            case "mountains":
                return new MountainsTile(v, zones);
            case "desert":
                return new DesertTile(v, zones);
            case "sea":
                return new SeaTile(v, zones);
        }
        return null;
    }
}
