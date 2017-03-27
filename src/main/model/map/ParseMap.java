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
                return parseStringForTile(tileData[itr++]);
            }
        };
    }

    //sample '( 1 0 0 ) sea ( 1 4 6 )'
    private Tile parseStringForTile(String s) {

        s = s.replaceAll("\\s+","");    //remove all whitespaces

        //sample (100)sea(146)

        boolean hasRiver = false;
        int numberOfParenthesesPair = s.length() - s.replaceAll("\\)", "").length();  //count pairs of parentheses

        if (numberOfParenthesesPair > 1 ){  //number of pair parentheses = 1 if nonrivered
            hasRiver = true;
        }

        int indexOfLocationLeftParenthesis = s.indexOf('(');    //0
        int indexOfLocationRightParenthesis = s.indexOf(')', indexOfLocationLeftParenthesis) + indexOfLocationLeftParenthesis;  //4

        String locationString = s.substring(indexOfLocationLeftParenthesis + 1, indexOfLocationRightParenthesis);   //0-4 TODO check


        int indexOfTerrainBegin = indexOfLocationRightParenthesis + 1; //5
        int indexOfTerrainEnd = s.length(); //~12
        if(hasRiver){
            indexOfTerrainEnd = s.lastIndexOf('(') - 1; //7
        }

        String terrain = s.substring(indexOfTerrainBegin, indexOfTerrainEnd + 1); //5-7 TODO check

        Zone[] zones = new Zone[6];
        //TODO check if blank zones are made by default

        if (hasRiver){
            int indexOfRiverStart = indexOfTerrainEnd + 1; //8
            int indexOfRiverEnd = s.length(); //10

            String river = s.substring(indexOfRiverStart + 1, indexOfRiverEnd);



            for (Character c : river.toCharArray()){
                int zoneFace = Character.getNumericValue(c);
                zones[zoneFace-1] = new Zone(true, false);
            }

        }

        int x = Character.getNumericValue(locationString.charAt(0));
        int y = Character.getNumericValue(locationString.charAt(1));
        int z = Character.getNumericValue(locationString.charAt(2));

        CubeVector location = new CubeVector(x, y, z);

        System.out.println("Terrain: "  + terrain);
        System.out.println("Coord: " + locationString);
        System.out.println("rivers? : " + hasRiver  + "\n");

        switch (terrain){
            case "woods":
                return new WoodsTile(location, zones);
            case "pasture":
                return new PastureTile(location, zones);
            case "rock":
                return new RockTile(location, zones);
            case "mountains":
                return new MountainsTile(location, zones);
            case "desert":
                return new DesertTile(location, zones);
            case "sea":
                return new SeaTile(location, zones);
        }


        return null;
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
