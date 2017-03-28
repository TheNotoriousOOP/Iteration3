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


    //written by Or, needs to be tested
    private Tile parseStringForTile(String s) {

        s = s.replaceAll("\\s+","");    //remove all whitespaces

        boolean hasRiver = false;
        int numberOfParenthesesPair = s.length() - s.replaceAll("\\)", "").length();  //count pairs of parentheses

        if (numberOfParenthesesPair > 1 ){  //number of pair parentheses = 1 if nonrivered
            hasRiver = true;
        }


        int indexOfLocationLeftParenthesis = s.indexOf('(');
        int indexOfLocationRightParenthesis = s.indexOf(')', indexOfLocationLeftParenthesis) + indexOfLocationLeftParenthesis;
        String locationString = s.substring(indexOfLocationLeftParenthesis + 1, indexOfLocationRightParenthesis);


        int indexOfTerrainBegin = indexOfLocationRightParenthesis + 1;
        int indexOfTerrainEnd = s.length() - 1;
        if(hasRiver){   //if a river exists, overwrite the end of terrain index
            indexOfTerrainEnd = s.lastIndexOf('(') - 1;
        }
        String terrain = s.substring(indexOfTerrainBegin, indexOfTerrainEnd + 1);


        Zone[] zones = new Zone[6];

        //fill in array of zones
        for(int i = 0; i < zones.length; i++){
            zones[i] = new Zone(false,false);
        }

        if (hasRiver){
            int indexOfRiverStart = indexOfTerrainEnd + 1;
            int indexOfRiverEnd = s.length() - 1;

            String river = s.substring(indexOfRiverStart + 1, indexOfRiverEnd);

            //initializing rivered zones correctly
            for (Character c : river.toCharArray()){
                int zoneFace = Character.getNumericValue(c);
                zones[zoneFace-1] = new Zone(true, false);
            }

        }


        //array of strings to correspond to x,y,z coords of cubevector
        String[] xyz = new String[3];

        int i = 0;  //iterator
        int iTmp;   //used for substring
        int indx = 0;   //index in xyz array
        while( i < locationString.length() ){   //iterate through the location string
            iTmp = i;   //reset temp

            if (locationString.charAt(i) == '-'){   //if a '-' exists, the coord is a negative value
                xyz[indx] = locationString.substring(i, iTmp + 2);  //add to the xyz array the current char (-) & the number following
                i++;
            } else{
                xyz[indx] = locationString.substring(i,iTmp + 1 );  //add to the xyz array the number
            }
            i++;
            indx++;
        }

        int x = Integer.valueOf(xyz[0]);
        int y = Integer.valueOf(xyz[1]);
        int z = Integer.valueOf(xyz[2]);

        CubeVector location = new CubeVector(x, y, z);


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
                //fill in array of zones for sea as both bools true
                for(int j = 0; j < zones.length; j++){
                    zones[j] = new Zone(true,true);
                }
                return new SeaTile(location, zones);
        }

        return null;
    }

    //TODO remove?
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
