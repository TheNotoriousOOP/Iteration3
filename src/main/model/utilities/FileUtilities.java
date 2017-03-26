package model.utilities;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 *      Creates and writes to or loads a .txt file filled with
 * Responsibilities:
 *      Creates a file of the map a user wants to save
 *      Gives the map the tiles that it will be composed of as a String Array
 */
public class FileUtilities {
    private String[] array;

    public FileUtilities(){
    }

    public void saveMap(String fileName, String[] array){
        this.array = array;
    }

    public String[] loadMap(String filename){
        return array;
    }
}
