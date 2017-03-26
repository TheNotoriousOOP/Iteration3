package model.map;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 *      Plain Old Data Class that holds cube coordinates of a tile
 * Responsibilities:
 *      Gives a Tiles location as a set of 3 integers
 *      Tile with Center of Gravity is given coordinates of 0,0,0
 */
public class CubeVector {
    private int x;
    private int y;
    private int z;

    public CubeVector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CubeVector subtractCubeVector(CubeVector target){
        CubeVector answer = new CubeVector(this.x - target.x,
                                            this.y - target.y,
                                            this.z - target.z);
        return answer;
    }
    public int getXCoord(){
        return this.x;
    }
    public int getYCoord(){
        return this.y;
    }
    public int getZCoord(){
        return this.z;
    }

    @Override
    public String toString() {
        return "( " + String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z) + " )";
    }
}
