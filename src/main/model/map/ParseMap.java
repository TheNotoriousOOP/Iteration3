package model.map;

import model.map.tile.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

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


    private Tile parseStringForTile(String s) {


        boolean hasRiver = false;
        int numberOfParenthesesPair = s.length() - s.replaceAll("\\)", "").length();  //count pairs of parentheses

        if (numberOfParenthesesPair > 1 ){  //number of pair parentheses = 1 if nonrivered
            hasRiver = true;
        }


        int indexOfLocationLeftParenthesis = s.indexOf('(');
        int indexOfLocationRightParenthesis = s.indexOf(')', indexOfLocationLeftParenthesis) + indexOfLocationLeftParenthesis;
        String locationString = s.substring(indexOfLocationLeftParenthesis + 1, indexOfLocationRightParenthesis);


        int indexOfTerrainBegin = indexOfLocationRightParenthesis + 2;
        int indexOfTerrainEnd = s.length() - 1;
        if(hasRiver){   //if a river exists, overwrite the end of terrain index
            indexOfTerrainEnd = s.lastIndexOf('(') - 1;
        }
        String terrain = s.substring(indexOfTerrainBegin, indexOfTerrainEnd);


        Zone[] zones = new Zone[6];

        //fill in array of zones
        for(int i = 0; i < zones.length; i++){
            zones[i] = new Zone(false,false);
        }

        if (hasRiver){
            int indexOfRiverStart = indexOfTerrainEnd + 1;
            int indexOfRiverEnd = s.length() - 1;

            String river = s.substring(indexOfRiverStart + 1, indexOfRiverEnd);

            Scanner riverScanner = new Scanner(river);

            while(riverScanner.hasNextInt()){
                int zoneFace = riverScanner.nextInt();
                zones[zoneFace-1] = new Zone(true,false);
            }


        }


        //array of strings to correspond to x,y,z coords of cubevector
        String[] xyz = new String[3];
        int indx = 0;   //index in xyz array

        Scanner scanner = new Scanner(locationString);
        while ((scanner.hasNext())){
            xyz[indx] = scanner.next();
            indx++;
        }



        int x = Integer.valueOf(xyz[0]);
        int y = Integer.valueOf(xyz[1]);
        int z = Integer.valueOf(xyz[2]);

        CubeVector location = new CubeVector(x, y, z);

        System.out.println("PARSER: loc " + location.toString());
        System.out.println("PARSER: riv " + zones.toString());
        System.out.println("PARSER: ter " + terrain);
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


}
