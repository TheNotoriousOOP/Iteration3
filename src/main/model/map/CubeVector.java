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

    // Constructor with defined coords
    public CubeVector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Default constructor
    public CubeVector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // Create a cube vector by subtracting the target from this vector
    public CubeVector subtractCubeVector(CubeVector target) {
        CubeVector answer = new CubeVector(this.x - target.x,
                                            this.y - target.y,
                                            this.z - target.z);
        return answer;
    }

    // Create a new offset cube vector by certain values
    public CubeVector offsetCubeVector(int x, int y, int z) {
        return new CubeVector(this.x + x, this.y + y, this.z + z);
    }

    // Create a new offset cube vector by certain values
    public CubeVector offsetCubeVector(CubeVector offset) {
        return new CubeVector(this.x + offset.getXCoord(), this.y + offset.getYCoord(), this.z + offset.getZCoord());
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

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

}
