package model.map;

import model.map.tile.*;
import model.map.tile.nodeRepresentation.*;

import java.util.ArrayList;
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


        ArrayList<Integer> listOfRiverFaces = new ArrayList<>();
        if (hasRiver){
            int indexOfRiverStart = indexOfTerrainEnd + 1;
            int indexOfRiverEnd = s.length() - 1;

            String river = s.substring(indexOfRiverStart + 1, indexOfRiverEnd);

            Scanner riverScanner = new Scanner(river);

            while(riverScanner.hasNextInt()){
                int riverFace = riverScanner.nextInt();
                listOfRiverFaces.add(riverFace);
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
        System.out.println("PARSER: riv " + listOfRiverFaces.toString());
        System.out.println("PARSER: ter " + terrain);


        NodeRepresentation nodeRepresentation = new NoRiverSetup(0);
        int rotation = determineRotationGivenRiverFaces(listOfRiverFaces);
        switch (listOfRiverFaces.size()){
            case 0:
                //0 rivers
                nodeRepresentation = new NoRiverSetup(rotation);
                break;
            case 1:
                //1 river = source
                nodeRepresentation = new SourceRiverSetup(rotation);
                break;
            case 2:
                //2 rivers = SharpCurve, LongCurve, or Straight
                int riverDistance = listOfRiverFaces.get(1) - listOfRiverFaces.get(0);

                if(riverDistance == 1){
                    nodeRepresentation = new SharpCurvedRiverSetup(rotation);
                } else if (riverDistance == 2){
                    nodeRepresentation = new LongCurvedRiverSetup(rotation);
                } else if (riverDistance == 3){
                    nodeRepresentation = new StraightRiverSetup(rotation);
                }else if (riverDistance == 4){   //edge case
                    nodeRepresentation = new LongCurvedRiverSetup(rotation);
                }else if (riverDistance == 5){   //edge case
                    nodeRepresentation = new SharpCurvedRiverSetup(rotation);
                }
                break;
            case 3:
                nodeRepresentation = new TriRiverSetup(rotation);

        }


        switch (terrain){
            case "woods":
                return new WoodsTile(location, nodeRepresentation);
            case "pasture":
                return new PastureTile(location, nodeRepresentation);
            case "rock":
                return new RockTile(location, nodeRepresentation);
            case "mountains":
                return new MountainsTile(location, nodeRepresentation);
            case "desert":
                return new DesertTile(location, nodeRepresentation);
            case "sea":
                return new SeaTile(location, new SeaSetup(rotation));
        }

        return null;
    }

    private int determineRotationGivenRiverFaces(ArrayList<Integer> riverFaces){
        int hexRotation = 0;
        int rotationBySides;
        //the rotation of the zone is the difference between index first watered zone and '1', multiplied by 60
        //'1' is the face in which all default river images begin
        switch (riverFaces.size()){
            case 0:
                hexRotation = 0;
                break;
            case 1:
                //determine rotation
                rotationBySides = riverFaces.get(0) - 1;
                hexRotation = rotationBySides*60;
                break;
            case 2:
                //determine rotation
                int riverDistance = (riverFaces.get(1) - riverFaces.get(0));

                rotationBySides = riverFaces.get(0) - 1;
                hexRotation = rotationBySides*60;
                if (riverDistance == 4){   //edge case
                    hexRotation = 300;
                    if (riverFaces.get(0) == 1){
                        hexRotation = 240;
                    }
                }else if (riverDistance == 5){   //edge case
                    hexRotation = 300;
                }
                break;
            case 3:
                //determine rotation
                rotationBySides = riverFaces.get(0) - 1;
                hexRotation = rotationBySides*60;
                break;
        }

        return hexRotation;

    }


}
