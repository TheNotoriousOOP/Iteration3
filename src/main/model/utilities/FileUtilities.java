package model.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 *      Creates and writes to or loads a .txt file filled with
 * Responsibilities:
 *      Creates a file of the map a user wants to save
 *      Gives the map the tiles that it will be composed of as a String Array
 */
public class FileUtilities {
    //TODO decide if we need private member variable here. Also probably don't need constructor
    //private String[] array;

    //public FileUtilities(){
    //}

    public static void saveMap(String fileName, String[] array){
        //TODO
    }

    public static String[] loadMap(String filename){
        Path pathToMapFile = Paths.get(filename);
        File mapFile = new File(pathToMapFile.toUri());
        List<String> mapFileLines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(mapFile))) {
            for(String line; (line = br.readLine()) != null; ) {
                mapFileLines.add(line);
            }
        }
        catch (IOException e) {
            System.out.println("IOException while trying to load " + filename);
            System.out.println(e.toString());
        }


        return mapFileLines.toArray( new String[] {});
    }
}
