package model.map;

import java.awt.*;

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

    //Conversion from View coordinates to Model coordinates
    public CubeVector(int col, int row){
        this.x = col-10; //TODO get rid of magic number
        this.z = (int) Math.ceil(-1 * this.x / 2.0) + row - 10; //TODO get rid of magic number
        this.y = -1*this.x - this.z;

        System.out.println("class CUBEVECTOR: converted " + col + ", " + row + " to " + this.x + ", " + this.y + ", " + this.z);
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

    //convert cubevector to point
    public Point getCubeVectorAsPoint(){
        Point xyPoint = new Point(21/2 +getXCoord(), 21/2 + Math.floorDiv(getZCoord() - getYCoord(), 2));

       // System.out.println("class CUBEVECTOR: converted "  + getXCoord() + ", " + getYCoord() + ", " + getZCoord() + " to " + xyPoint.getX() + ", " + xyPoint.getY() );
        return xyPoint;
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
